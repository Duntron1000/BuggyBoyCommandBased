package frc.robot.commands;

import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmTiltSubsystem;
import com.revrobotics.CANSparkMax;

public class ManualArmTiltCmd extends CommandBase{
    private double rotations;
    private ArmTiltSubsystem armSub;
    private double dir;

    public ManualArmTiltCmd(ArmTiltSubsystem armSub, double r){
        this.armSub = armSub;
        System.out.print(rotations);
        rotations = armSub.getEncoder();
        dir = r;
        addRequirements(armSub);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        armSub.setReference(rotations = armSub.getEncoder() + dir);
        System.out.print(rotations);
    }
}