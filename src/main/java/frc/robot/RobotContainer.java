// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.autons.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //temp var

  //Subsystems
  private final driveTrain driveSubsystem = driveTrain.getInstance();
  public final ArmTiltSubsystem armTiltSubsystem = ArmTiltSubsystem.getInstance();
  private final ArmInOutSubsystem armInOutSubsystem = ArmInOutSubsystem.getInstance();
  private final IntakeSubsytem intakeSubsytem = IntakeSubsytem.getInstance();
  private final Pneumatics pneumatics = Pneumatics.getInstance();
  private final ShuffleBoardHandler shuffle = ShuffleBoardHandler.getInstance();

  //Controllers
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final Joystick joystick = new Joystick(Constants.driverControllerPort);
  private final CommandXboxController xbox = new CommandXboxController(Constants.operatorControllerPort);


  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings

    //For driving the robot
    driveSubsystem.setDefaultCommand(new ArcadeDriveCmd(() -> joystick.getY(), () -> joystick.getX()));


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
    
    //Pid positions
    //new JoystickButton(joystick, 6).onTrue(new AutonBase(driveSubsystem));
    //new JoystickButton(joystick, 6).onTrue());

    //Low
    xbox.a().onTrue(new ArmInOutPIDCmd(Constants.pidExtendPos1).andThen(new ArmTiltPIDCmd(Constants.pidTiltPos1)));
    
    //Human player station
    xbox.b().and(armTiltSubsystem.bigger(Constants.pidTiltPos2)).onTrue(new SequentialCommandGroup(new ArmTiltPIDCmd(Constants.pidTiltPos2),  new ArmInOutPIDCmd(Constants.pidExtendPos2)));
    xbox.b().and(armTiltSubsystem.unbigger(Constants.pidTiltPos2)).onTrue(new SequentialCommandGroup( new ArmInOutPIDCmd(Constants.pidExtendPos2),  new ArmTiltPIDCmd(Constants.pidTiltPos2)));

    //Mid
    xbox.x().and(() -> pneumatics.getCubeMode()).and(armTiltSubsystem.bigger(Constants.pidTiltPos3)).onTrue(new SequentialCommandGroup(new ArmTiltPIDCmd(Constants.pidTiltPos3),  new ArmInOutPIDCmd(Constants.pidExtendPos3Cube)));
    xbox.x().and(() -> pneumatics.getCubeMode()).and(armTiltSubsystem.unbigger(Constants.pidTiltPos3)).onTrue(new SequentialCommandGroup( new ArmInOutPIDCmd(Constants.pidExtendPos3Cube),  new ArmTiltPIDCmd(Constants.pidTiltPos3)));
    
    xbox.x().and(() -> !pneumatics.getCubeMode()).and(armTiltSubsystem.bigger(Constants.pidTiltPos3)).onTrue(new SequentialCommandGroup(new ArmTiltPIDCmd(Constants.pidTiltPos3),  new ArmInOutPIDCmd(Constants.pidExtendPos3Cone)));
    xbox.x().and(() -> !pneumatics.getCubeMode()).and(armTiltSubsystem.unbigger(Constants.pidTiltPos3)).onTrue(new SequentialCommandGroup( new ArmInOutPIDCmd(Constants.pidExtendPos3Cone),  new ArmTiltPIDCmd(Constants.pidTiltPos3)));
    
    //High
    xbox.y().onTrue(new SequentialCommandGroup(new ArmTiltPIDCmd(Constants.pidTiltPos4),  new ArmInOutPIDCmd(Constants.pidExtendPos4)));
    
    //Tilt manual
    xbox.pov(Constants.xdPadUp).whileTrue(new ManualArmTiltCmd(-Constants.pidManualTiltSpeed));
    xbox.pov(Constants.xdPadDown).whileTrue(new ManualArmTiltCmd(Constants.pidManualTiltSpeed));
    
    //In out manual
    xbox.pov(Constants.xdPadRight).whileTrue(new ManualArmInOutCmd(-Constants.pidManualExtendSpeed));
    xbox.pov(Constants.xdPadLeft).whileTrue(new ManualArmInOutCmd(Constants.pidManualExtendSpeed));

    //Grabber motors
    xbox.leftBumper().whileTrue(new RunIntakeCmd(Constants.holdSpeed));
    //xbox.rightBumper().and(xbox.back()).whileTrue(new RunIntakeCmd(Constants.outSlowSpeed));
    xbox.rightBumper().whileTrue(new RunIntakeCmd(Constants.outFastSpeed));
    //xbox.a()
    
    //Grabber toggle position
    new JoystickButton(joystick, 5).whileTrue(new ToggleIntakeCmd());

    //new JoystickButton(joystick, 8).whileTrue(new driveForwardCmd(driveSubsystem, .1, 50.0));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    //return new AutonBase(driveSubsystem);
    //return new AutonOneCone(armTiltSubsystem);
    String m_autoSelected = shuffle.getSelected();
    
    System.out.println("Auto selected: " + m_autoSelected);
    if (m_autoSelected.equals(Constants.kCustomAuto1)) return new AutonBase();
    else if (m_autoSelected.equals(Constants.kCustomAuto2)) return new AutonOneCone();
    else if (m_autoSelected.equals(Constants.kCustomAuto3)) return new AutonOneConeExit();
    else if (m_autoSelected.equals(Constants.kCustomAuto4)) return new AutonOneConeMid();
    else if (m_autoSelected.equals(Constants.kCustomAuto5)) return new AutonOneConeMidExit();
    else if (m_autoSelected.equals(Constants.kCustomAuto6)) return new AutonOneConeMidShoot();
    else if (m_autoSelected.equals(Constants.kCustomAuto7)) return new AutonBalance();
    else if (m_autoSelected.equals(Constants.kCustomAuto8)) return new AutonBalanceOneCone();
    else if (m_autoSelected.equals(Constants.kCustomAuto9)) return new AutonOneConeMid();
    else if (m_autoSelected.equals(Constants.kCustomAuto10)) return new AutonOneHighCube();
    else if (m_autoSelected.equals(Constants.kCustomAuto11)) return new CubeMidCmd();
    else if (m_autoSelected.equals(Constants.kCustomAuto12)) return new AutonCubeMidExit();
    else if (m_autoSelected.equals(Constants.kCustomAuto13)) return new AutonOneHighCubeExit();
    else return null;
    //return new AutonOneConeExit(driveSubsystem);
  }
}