package frc.robot.commands;

import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmTiltSubsystem;
import com.revrobotics.CANSparkMax;

public class ArmTiltPIDCmd extends CommandBase{
    private double rotations;
    private ArmTiltSubsystem armSub;

    public ArmTiltPIDCmd(ArmTiltSubsystem armSub, double r){
        this.armSub = armSub;
        rotations = r;
        addRequirements(armSub);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        armSub.setReference(rotations);
    }
}