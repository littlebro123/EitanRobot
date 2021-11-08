package frc.robot.subsystems.funnel.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.funnel.Funnel;

public class DigestBall extends CommandBase {
    private boolean funnelMode;
    private Funnel funnel;

    public DigestBall(Funnel funnel) {
        this.funnel = funnel;
    }

    @Override
    public void initialize() {
        funnelMode = true;
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
