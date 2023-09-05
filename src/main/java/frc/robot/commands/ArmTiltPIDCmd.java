package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmTiltSubsystem;

public class ArmTiltPIDCmd extends CommandBase{
    private double rotations;
    private ArmTiltSubsystem armSub;

    public ArmTiltPIDCmd(double r){
        this.armSub = ArmTiltSubsystem.getInstance();
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

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return (armSub.getEncoder() < rotations+1 && armSub.getEncoder() > rotations-1);
    }
}