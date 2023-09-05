package frc.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.driveTrain;

public class AutonDriveCmd extends CommandBase {

    private double setpoint;
    private double speed;
    private driveTrain dt;
    
    public AutonDriveCmd (double setpoint, double speed) {
        this.dt = driveTrain.getInstance();
        dt.resetEncoders();
        SmartDashboard.putNumber("Encoder", dt.getEncoder());
        this.setpoint = setpoint;
        this.speed = speed;
        addRequirements(dt);
    }
    
    // @Override
    // public void initialize() {
        
    //     System.out.print("starting!");
    // }
    @Override
    public void execute() {
        dt.drive(speed, 0);
        SmartDashboard.putNumber("Encoder", dt.getEncoder());
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if(setpoint > 0){
            return (dt.getEncoder() >= setpoint);
        }else{
            return (dt.getEncoder() <= setpoint);
        }
    }

    @Override
    public void end(boolean interrupted) {
        dt.drive(0,0);
    }
}
