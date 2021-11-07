package frc.robot.subsystems.turret;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.controller.PIDController;
import frc.robot.subsystems.UnitModel;

import static frc.robot.Constants.Turret.*;
import static frc.robot.Ports.Turret.*;

public class Turret {
    private double currAngle;
    private TalonSRX motor_main;
    private TalonSRX motor_aux;
    private PIDController pidController = new PIDController(kP, kI, kD);
    private UnitModel unitModel = new UnitModel(TICKS_PER_DEGREE);

    public Turret(TalonSRX motor_main, TalonSRX motor_aux) {
        this.motor_main = motor_main;
        this.motor_aux = motor_aux;

        motor_main.setInverted(MAIN_INVERTED);
        motor_aux.setInverted(AUX_INVERTED);

        motor_main.setSensorPhase(MAIN_SENSOR_PHASE);
        motor_aux.setSensorPhase(AUX_SENSOR_PHASE);

        motor_aux.follow(motor_main);
    }

    public double getCurrAngle() {
        return currAngle;
    }

    public void setCurrAngle(double currAngle) {
        this.currAngle = currAngle;
    }

    public void setAngle(double angle) {
        angle += pidController.calculate(angle - currAngle);
        motor_main.set(ControlMode.Position, unitModel.toTicks(angle));
    }

    public void terminate() {
        motor_main.set(ControlMode.PercentOutput, 0);
    }
}
