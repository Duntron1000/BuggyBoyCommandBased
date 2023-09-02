package frc.robot.autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ArmInOutPIDCmd;
import frc.robot.commands.ArmTiltPIDCmd;
import frc.robot.commands.CloseGrabberCmd;
import frc.robot.commands.SetIntakeCmd;
import frc.robot.commands.ToggleIntakeCmd;
import frc.robot.subsystems.*;

public class AutonOneConeMid extends SequentialCommandGroup {
    
    public AutonOneConeMid(){
        addCommands(
            new SetIntakeCmd(-.25),
            new ArmTiltPIDCmd(-68),
            new ArmInOutPIDCmd(-450.2),
            new ToggleIntakeCmd(), 
            new SetIntakeCmd(0),
            new ArmInOutPIDCmd(0),
            new ArmTiltPIDCmd(-1)
        );
    }
}
