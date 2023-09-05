package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmInOutSubsystem extends SubsystemBase{
    private static ArmInOutSubsystem armInOutSubsystem;
    private CANSparkMax inout = new CANSparkMax(Constants.ARM_INOUT, MotorType.kBrushless);
    private RelativeEncoder encoder;
    private SparkMaxPIDController pidController;
    private double setpoint = 0;

    public ArmInOutSubsystem(){
        encoder = inout.getEncoder();
        pidController = inout.getPIDController();
        pidController.setP(Constants.EXTEND_KP);
        pidController.setI(Constants.EXTEND_KI);
        pidController.setD(Constants.EXTEND_KD);
        pidController.setIZone(Constants.EXTEND_KIz);
        pidController.setFF(Constants.EXTEND_KFF);
        pidController.setOutputRange(Constants.EXTEND_KMinOutput, Constants.TILT_KMaxOutput);
    }

    public void setReference(double position){
        pidController.setReference(position, CANSparkMax.ControlType.kPosition);
        setpoint = position;
        System.out.println(position);
        //SmartDashboard.putNumber("Extension Setpoint", position);
    }

    public double getEncoder(){
        return encoder.getPosition();
    }

    public double getSetpoint(){
        return setpoint;
    }

    public void resetEncoders(){
        encoder.setPosition(0);
    }

    public static ArmInOutSubsystem getInstance(){
        if (armInOutSubsystem == null){
            armInOutSubsystem = new ArmInOutSubsystem();
        }
        return armInOutSubsystem;
    }
}
