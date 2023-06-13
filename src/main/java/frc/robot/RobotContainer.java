// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.autons.AutonBase;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.autonCmds.driveForwardCmd;
import frc.robot.autons.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final driveTrain driveSubsystem = new driveTrain();
  private final ArmTiltSubsystem armSubsystem = new ArmTiltSubsystem();
  private final IntakeSubsytem intakeSubsytem = new IntakeSubsytem();
  private final Pneumatics pneumatics = new Pneumatics();

  private final Joystick joystick = new Joystick(0);
  private final Joystick joystick2 = new Joystick(3);
  private final XboxController xbox = new XboxController(1);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    driveSubsystem.setDefaultCommand(new ArcadeDriveCmd(driveSubsystem, () -> joystick.getY(), () -> joystick2.getY()));

    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    //Tilt pid
    new JoystickButton(xbox, 1).whileTrue(new ArmTiltPIDCmd(armSubsystem, -1));
    new JoystickButton(xbox, 2).whileTrue(new ArmTiltPIDCmd(armSubsystem, -50));
    new JoystickButton(xbox, 3).whileTrue(new ArmTiltPIDCmd(armSubsystem, -72.4));
    new JoystickButton(xbox, 4).whileTrue(new ArmTiltPIDCmd(armSubsystem, -76));
    //Tilt manual
    new POVButton(xbox, 0).whileTrue(new ManualArmTiltCmd(armSubsystem, -4));
    new POVButton(xbox, 180).whileTrue(new ManualArmTiltCmd(armSubsystem, 4));
    //In Out PID
    
    //In out manual

    //Grabber
    new JoystickButton(xbox, 5).whileTrue(new RunIntakeCmd(intakeSubsytem, -.2));
    new JoystickButton(xbox, 6).whileTrue(new RunIntakeCmd(intakeSubsytem, .6));

    //Grabber position
    new JoystickButton(joystick, 5).whileTrue(new ToggleIntakeCmd(pneumatics));

    new JoystickButton(joystick, 8).whileTrue(new driveForwardCmd(driveSubsystem, .1, 50.0));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}