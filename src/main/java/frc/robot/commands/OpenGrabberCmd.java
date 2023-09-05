package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Pneumatics;

public class OpenGrabberCmd extends CommandBase {
    private Pneumatics pneu;

    public OpenGrabberCmd(){
        this.pneu = Pneumatics.getInstance();
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        pneu.extend();
    }

    @Override
    public void end(boolean interrupted){
    }
}
