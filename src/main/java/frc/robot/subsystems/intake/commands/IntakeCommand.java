package frc.robot.subsystems.intake.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake.Intake;

public class IntakeCommand extends CommandBase {
    private Intake intake = new Intake();
    private boolean intakeMode;

    public IntakeCommand(boolean intakeMode) {
        this.intakeMode = intakeMode;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        intake.setIntakeMode(intakeMode);
        intake.setIntake();
    }

    @Override
    public void end(boolean interrupted) {
        intake.terminate();
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
