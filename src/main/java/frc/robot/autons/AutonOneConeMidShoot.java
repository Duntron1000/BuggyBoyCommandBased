package frc.robot.autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.ArmTiltPIDCmd;
import frc.robot.commands.SetIntakeCmd;

public class AutonOneConeMidShoot extends SequentialCommandGroup {
    
    public AutonOneConeMidShoot(){
        addCommands(
            new SetIntakeCmd(-.25),
            new ArmTiltPIDCmd(-68), // temp value
            new SetIntakeCmd(.6),
            new WaitCommand(.2),
            new SetIntakeCmd(0),
            new ArmTiltPIDCmd(-1)
        );
    }
}
