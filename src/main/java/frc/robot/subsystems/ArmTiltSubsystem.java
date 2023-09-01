// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.BooleanSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmTiltSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private CANSparkMax armTilt = new CANSparkMax(Constants.CAN_ARMTILT, MotorType.kBrushless);

  private RelativeEncoder encoder = armTilt.getEncoder();

  private SparkMaxPIDController m_PidController;

  private static ArmTiltSubsystem tilt;

  private double setPoint;

  public ArmTiltSubsystem() {
    m_PidController = armTilt.getPIDController();
    m_PidController.setP(Constants.TILT_KP);
    m_PidController.setI(Constants.TILT_KI);
    m_PidController.setD(Constants.TILT_KD);
    m_PidController.setIZone(Constants.TILT_KIz);
    m_PidController.setFF(Constants.TILT_KFF);
    m_PidController.setOutputRange(Constants.TILT_KMinOutput, Constants.TILT_KMaxOutput);
  }

  //Returns if pos arm is moving to is higher than current pos
  public BooleanSupplier bigger(double itemOne){
    return () -> itemOne < getEncoder();
  }

  //Returns if pos arm is moving to is lower than current pos
  public BooleanSupplier unbigger(double thing){
    return () -> thing > getEncoder();
  }

  
  public void run(double speed){
    armTilt.set(speed);
  }

  public void setReference(double r){
     m_PidController.setReference(r, CANSparkMax.ControlType.kPosition);
     setPoint = r;
     //SmartDashboard.putNumber("Tilt Setpoint", r);
  }

  public double getEncoder() {
    return encoder.getPosition();
  }

  public double getSetpoint(){
    return setPoint;
  }

  public static ArmTiltSubsystem getInstance(){
    if (tilt == null){
      tilt = new ArmTiltSubsystem();
    }
    return tilt;
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
