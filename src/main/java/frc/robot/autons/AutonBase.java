package frc.robot.autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.commands.AutonDriveCmd;
import frc.robot.subsystems.driveTrain;

public class AutonBase extends SequentialCommandGroup{

    public AutonBase() {
        addCommands(
           new AutonDriveCmd(-87, .4)
        );

        // new SequentialCommandGroup(
        //     new AutonDriveCmd(dr, -100)
        // );
    }

}
