package frc.robot.autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonOneConeMidExit extends SequentialCommandGroup{

    public AutonOneConeMidExit(){
        addCommands(
            new AutonOneConeMid(),
            new AutonBase()
        );
    }

    
}
