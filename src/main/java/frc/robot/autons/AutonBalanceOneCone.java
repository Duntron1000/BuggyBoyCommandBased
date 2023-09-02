package frc.robot.autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonBalanceOneCone extends SequentialCommandGroup {
    public AutonBalanceOneCone(){
        addCommands(
            new AutonOneCone(),
            new AutonBalance()
        );
    }
}
