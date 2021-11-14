package frc.robot.subsystems.shooter.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.Shooter;

public class Shoot extends CommandBase {
    private Shooter shooter;

    public Shoot(Shooter shooter) {
        this.shooter = shooter;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        shooter.setVelocity(
                shooter.calcInitialVelocity()
        );
    }

    @Override
    public void end(boolean interrupted) {
        shooter.terminate();
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
