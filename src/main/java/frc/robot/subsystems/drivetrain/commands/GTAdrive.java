package frc.robot.subsystems.drivetrain.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrain.Drivetrain;

import static frc.robot.Constants.Drivetrain.*;
import static frc.robot.Ports.Drivetrain.*;

public class GTAdrive extends CommandBase {
    private PIDController pidController = new PIDController(kP, kI, kD);
    private Drivetrain drivetrain;
    private Joystick right_joystick = new Joystick(RIGHT_JOYSTICK);
    private Joystick left_joystick = new Joystick(LEFT_JOYSTICK);
    private double X;
    private double Y;

    public GTAdrive(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    @Override
    public void initialize() {
        addRequirements();
    }

    @Override
    public void execute() {
        Y = pidController.calculate(left_joystick.getY());
        X = pidController.calculate(right_joystick.getX());

        drivetrain.setOutput(Y, X);
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
