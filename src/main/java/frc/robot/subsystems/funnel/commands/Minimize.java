package frc.robot.subsystems.funnel.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.funnel.Funnel;

public class Minimize extends CommandBase {
    private boolean funnelMode;
    private Funnel funnel;

    public Minimize(Funnel funnel) {
        this.funnel = funnel;
    }

    @Override
    public void initialize() {
        funnelMode = false;
    }

    @Override
    public void execute() {
        funnel.setFunnelMode(funnelMode);
        funnel.setPower(0.75);
    }

    @Override
    public void end(boolean interrupted) {
        funnel.terminate();
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
