package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.Subsystem;

import static frc.robot.Constants.Drivetrain.*;
import static frc.robot.Ports.Drivetrain.*;

public class Drivetrain {
    private TalonSRX fr_motor = new TalonSRX(FR_MOTOR);
    private TalonSRX fl_motor = new TalonSRX(FL_MOTOR);
    private TalonSRX rr_motor = new TalonSRX(RR_MOTOR);
    private TalonSRX rl_motor = new TalonSRX(RL_MOTOR);

    public Drivetrain() {
        fr_motor.setInverted(FR_INVERTED);
        fl_motor.setInverted(FL_INVERTED);
        rr_motor.setInverted(RR_INVERTED);
        rl_motor.setInverted(RL_INVERTED);

        fr_motor.setSensorPhase(FR_SENSOR_PHASE);
        fl_motor.setSensorPhase(FL_SENSOR_PHASE);
        rr_motor.setSensorPhase(RR_SENSOR_PHASE);
        rl_motor.setSensorPhase(RL_SENSOR_PHASE);
    }

    public void setOutputRight(double output) {
        fr_motor.set(ControlMode.PercentOutput, output);
        rr_motor.set(ControlMode.PercentOutput, output);
    }

    public void setOutputLeft(double output) {
        fl_motor.set(ControlMode.PercentOutput, output);
        rl_motor.set(ControlMode.PercentOutput, output);
    }

    public void setOutput(double joystick_left, double joystick_right){
        joystick_left *= -1;
        joystick_right *= TURN_MULTIPLIER;

        double power_left = joystick_left + joystick_right;
        double power_right = joystick_left - joystick_right;

        setOutputLeft(power_left);
        setOutputRight(power_right);
    }

    public void terminate(){
        fr_motor.set(ControlMode.PercentOutput, 0);
        fl_motor.set(ControlMode.PercentOutput, 0);
        rr_motor.set(ControlMode.PercentOutput, 0);
        rl_motor.set(ControlMode.PercentOutput, 0);
    }
}
