package frc.robot.commands;

import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmTiltSubsystem;
import com.revrobotics.CANSparkMax;

public class ArmTiltPIDCmd extends CommandBase{
    private double rotations;
    private ArmTiltSubsystem armSub;

    private boolean done;

    public ArmTiltPIDCmd(ArmTiltSubsystem armSub, double r){
        this.armSub = armSub;
        rotations = r;
        done = false;
        addRequirements(armSub);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        armSub.setReference(rotations);
        done = true;
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return done;
    }
}