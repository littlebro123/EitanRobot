/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.drivetrain.Drivetrain;
import frc.robot.subsystems.drivetrain.commands.GTAdrive;
import frc.robot.subsystems.funnel.Funnel;
import frc.robot.subsystems.funnel.commands.DigestBall;
import frc.robot.subsystems.funnel.commands.Minimize;
import frc.robot.subsystems.intake.commands.IntakeCommand;
import frc.robot.subsystems.turret.Turret;
import frc.robot.subsystems.turret.commands.Gunner;

import static frc.robot.Ports.RIGHT_JOYSTICK;
import static frc.robot.Ports.LEFT_JOYSTICK;
import static frc.robot.Ports.ADDITIONAL_JOYSTICK;
import static frc.robot.Ports.XBOX;
import static frc.robot.Ports.Turret.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    Drivetrain drivetrain = new Drivetrain();
    Joystick right_joystick = new Joystick(RIGHT_JOYSTICK);
    Joystick left_joystick = new Joystick(LEFT_JOYSTICK);
    XboxController xboxController = new XboxController(XBOX);
    JoystickButton a = new JoystickButton(xboxController, XboxController.Button.kA.value);
    JoystickButton x = new JoystickButton(xboxController, XboxController.Button.kX.value);
    JoystickButton b = new JoystickButton(xboxController, XboxController.Button.kB.value);
    JoystickButton y = new JoystickButton(xboxController, XboxController.Button.kY.value);
    Turret turret = new Turret(new TalonSRX(MOTOR_MAIN), new TalonSRX(MOTOR_AUX));
    Funnel funnel = new Funnel();
    // The robot's subsystems and commands are defined here...


    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        new ParallelCommandGroup(
                new GTAdrive(drivetrain, right_joystick, left_joystick),
                new Gunner(turret, xboxController)
        );
        a.whileHeld(new IntakeCommand(true));
        x.whileHeld(new IntakeCommand(false));
        b.whileHeld(new DigestBall(funnel));
        y.whileHeld(new Minimize(funnel));
    }


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return null;
    }
}
