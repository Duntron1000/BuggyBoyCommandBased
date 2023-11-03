package frc.robot.autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonCubeMidExit extends SequentialCommandGroup{
    public AutonCubeMidExit(){
        addCommands(new CubeMidCmd(),
        new AutonBase());
    }
}
