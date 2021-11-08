package frc.robot.subsystems.turret.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.turret.Turret;

public class Gunner extends CommandBase {
    private double currAngle;
    private Turret turret;
    private XboxController xboxController;

    public Gunner(Turret turret, XboxController xboxController) {
        this.turret = turret;
        this.xboxController = xboxController;
    }

    @Override
    public void initialize() {
        currAngle = 0;
    }

    @Override
    public void execute() {
        turret.setCurrAngle(currAngle);
        double angle = Math.toDegrees(Math.atan2(-xboxController.getY(GenericHID.Hand.kRight), xboxController.getX(GenericHID.Hand.kRight)));
        turret.setAngle(angle);
    }

    @Override
    public void end(boolean interrupted) {
        turret.terminate();
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
