package frc.robot.autonCmds;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain;

public class driveForwardCmd extends CommandBase {

    private driveTrain driveSubsystem;
    private double speed;
    private double distance;
    private boolean done;
    
    public driveForwardCmd(driveTrain driveSubsystem, double speed, double distance){
        this.driveSubsystem = driveSubsystem;
        this.speed = speed;
        this.distance = distance;
        done = false;
        driveSubsystem.resetEncoders();

        addRequirements(driveSubsystem);
    }

    @Override
    public void execute(){
        driveSubsystem.drive(0, speed);

        if(driveSubsystem.getEncoder() >= distance){
            done = true;
        }
    }

    @Override
    public boolean isFinished(){
        return done;
    }
    
}
