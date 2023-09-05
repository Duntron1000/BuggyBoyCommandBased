package frc.robot.autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonBalanceOneConeMid extends SequentialCommandGroup {
    public AutonBalanceOneConeMid() {
        addCommands(
            new AutonOneConeMidShoot(),
            new AutonBalance()
        );
    }
}
