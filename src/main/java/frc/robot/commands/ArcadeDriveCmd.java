// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain;

/** An example command that uses an example subsystem. */
public class ArcadeDriveCmd extends CommandBase {
  
  private driveTrain dirveSubsystem;
  private DoubleSupplier speedFunction;
  private DoubleSupplier turnFunction;

  public ArcadeDriveCmd(driveTrain dirveSubsystem, DoubleSupplier speedFunction, DoubleSupplier turnFunction) {
    this.dirveSubsystem = dirveSubsystem;
    this.speedFunction = speedFunction;
    this.turnFunction = turnFunction;
    

    addRequirements(dirveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double realTimeSpeed = speedFunction.getAsDouble();
    double realTimeTurn = turnFunction.getAsDouble();

    dirveSubsystem.drive(realTimeSpeed, realTimeTurn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("ArcadeDriveEnded");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
