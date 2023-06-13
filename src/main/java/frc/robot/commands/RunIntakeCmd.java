package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsytem;

public class RunIntakeCmd extends CommandBase{
    private double speed;
    private IntakeSubsytem intakeSub;

    public RunIntakeCmd(IntakeSubsytem intakeSub, double speed){
        this.intakeSub = intakeSub;
        this.speed = speed;
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        intakeSub.run(speed);
    }

    @Override
    public void end(boolean interrupted){
        intakeSub.run(0);
    }

}
