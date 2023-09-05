package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmTiltSubsystem;

public class ManualArmTiltCmd extends CommandBase{
    private double rotations;
    private ArmTiltSubsystem armSub;
    private double dir;

    public ManualArmTiltCmd(double r){
        this.armSub = ArmTiltSubsystem.getInstance();
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