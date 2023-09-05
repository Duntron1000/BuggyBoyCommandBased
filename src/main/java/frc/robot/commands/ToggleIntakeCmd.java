package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Pneumatics;

public class ToggleIntakeCmd extends CommandBase {
    private Pneumatics pneu;
    private boolean done = false;

    public ToggleIntakeCmd(){
        this.pneu = Pneumatics.getInstance();
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        done = false;
        pneu.toggle();
        done = true;
    }

    @Override
    public void end(boolean interrupted){
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return done;
    }
}
