package frc.robot.commands;

import java.io.PipedInputStream;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain;

public class BalanceCmd extends CommandBase{
    private double driveTrainSetPoint;
    private static double driveTrainGain = -.5;
    private driveTrain d = driveTrain.getInstance();

    private static PIDController pid = new PIDController(.046, 0, 0);

    @Override
    public void execute(){
        driveTrainSetPoint = driveTrainGain*pid.calculate(deadZone(d.getPitch(), 3.25), 0);

        d.drive(0, driveTrainSetPoint);
    }

    private double deadZone(double pitch, double limit){
        if(Math.abs(pitch) < limit || Math.abs(pitch) > 20){
            return 0;
        }else{
            return pitch;
        }
    }
}
