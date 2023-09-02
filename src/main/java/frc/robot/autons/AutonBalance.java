package frc.robot.autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutonDriveCmd;
import frc.robot.commands.BalanceCmd;

public class AutonBalance extends SequentialCommandGroup {
    //change the auton drive cmmand to take in a speed
    public AutonBalance(){
        addCommands(
            new AutonDriveCmd(100),
            new BalanceCmd()
        );
    }
}
