package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmInOutSubsystem;

public class ManualArmInOutCmd extends CommandBase{
    private double rotations;
    private ArmInOutSubsystem armSub;
    private double dir;

    public ManualArmInOutCmd(double r){
        this.armSub = ArmInOutSubsystem.getInstance();
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