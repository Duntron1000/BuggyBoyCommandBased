package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Pneumatics;

public class CloseGrabberCmd extends CommandBase {
    private Pneumatics pneu;

    public CloseGrabberCmd(Pneumatics pneu){
        this.pneu = pneu;
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        pneu.retract();
    }

    @Override
    public void end(boolean interrupted){
    }
}
