package frc.robot.autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonOneHighCubeExit extends SequentialCommandGroup {
    public AutonOneHighCubeExit(){
        addCommands(new AutonOneHighCubeExit(), new AutonBase());
    }
    
}
