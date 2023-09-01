// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class driveTrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  //Objects for each of the drivetrain's motorcontrollers
  private final CANSparkMax left1 = new CANSparkMax(Constants.CAN_LEFT1, MotorType.kBrushless);
  private final CANSparkMax left2 = new CANSparkMax(Constants.CAN_LEFT2, MotorType.kBrushless);
  private final CANSparkMax right1 = new CANSparkMax(Constants.CAN_RIGHT1, MotorType.kBrushless);
  private final CANSparkMax right2 = new CANSparkMax(Constants.CAN_RIGHT2, MotorType.kBrushless);

  //encoders
  private final RelativeEncoder leftEncoder = left1.getEncoder();
  private final RelativeEncoder rightEncoder = right1.getEncoder();

  //Groups the motor controllers based on the side of the drive train they are on
  private final MotorControllerGroup left = new MotorControllerGroup(left1, left2);
  private final MotorControllerGroup right = new MotorControllerGroup(right1, right2);

  //DIFFDRIVE!!
  private final DifferentialDrive diffdrive = new DifferentialDrive(left, right);

  //Drive Train
  private static driveTrain drivetrain;

  //
  public driveTrain() {
    left.setInverted(true);

    //leftEncoder = left1.getEncoder();
    //rightEncoder = right1.getEncoder();
  }

  //Takes in controller inputs
  public void drive(double y, double x) {
    diffdrive.arcadeDrive(y, x);
  }
  
  //Returns one drive train encoder
  public double getEncoder() {
    return rightEncoder.getPosition();
  }

  //resets drive train encoders
  public void resetEncoders() {
    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0); 
  }

  public static driveTrain getInstance(){
    if (drivetrain == null){
      drivetrain = new driveTrain();
    }
    return drivetrain;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
