package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsytem;

public class SetIntakeCmd extends CommandBase {
    private IntakeSubsytem intake;
    private double speed;

    public SetIntakeCmd(double speed){
        this.intake = IntakeSubsytem.getInstance();
        this.speed = speed;
    }

    @Override
    public void initialize(){
        intake.run(speed);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}
