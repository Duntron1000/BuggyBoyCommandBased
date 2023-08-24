package frc.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.driveTrain;

public class AutonDriveCmd extends CommandBase {

    private double setpoint;
    private driveTrain dt;
    
    public AutonDriveCmd (driveTrain dt, double setpoint) {
        dt.resetEncoders();
        SmartDashboard.putNumber("Encoder", dt.getEncoder());
        this.setpoint = setpoint;
        this.dt = dt;
        addRequirements(dt);
    }

    // @Override
    // public void initialize() {
        
    //     System.out.print("starting!");
    // }
    @Override
    public void execute() {
        dt.drive(0.1, 0);
        SmartDashboard.putNumber("Encoder", dt.getEncoder());
        System.out.print("whoa!");
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return (dt.getEncoder() >= setpoint);
    }

    @Override
    public void end(boolean interrupted) {
        dt.drive(0,0);
    }
}
