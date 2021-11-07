package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import static frc.robot.Ports.Intake.*;

public class Intake {
    private TalonSRX motor_main = new TalonSRX(MOTOR_MAIN);
    private boolean intakeMode;

    public Intake() {
        motor_main.setInverted(INVERTED);
        motor_main.setSensorPhase(SENSOR_PHASE);
    }

    public void setIntakeMode(boolean intakeMode) {
        this.intakeMode = intakeMode;
    }

    public boolean getIntakeMode() {
        return intakeMode;
    }

    public void setIntake() {
        motor_main.set(ControlMode.PercentOutput, intakeMode ? 1 : -1);
    }

    public void terminate(){
        motor_main.set(ControlMode.PercentOutput, 0);
    }
}
