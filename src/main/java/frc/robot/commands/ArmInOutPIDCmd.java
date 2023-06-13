package frc.robot.commands;

import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmInOutSubsystem;
import com.revrobotics.CANSparkMax;

public class ArmInOutPIDCmd extends CommandBase{
    private double rotations;
    private ArmInOutSubsystem armSub;

    public ArmInOutPIDCmd(ArmInOutSubsystem armSub, double r){
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