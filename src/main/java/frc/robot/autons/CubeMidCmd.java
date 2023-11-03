package frc.robot.autons;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.*;
import frc.robot.Constants;
import frc.robot.autons.*;

public class CubeMidCmd extends SequentialCommandGroup {

    public CubeMidCmd(){
        addCommands(
            new SetIntakeCmd(-.3),
            new ParallelCommandGroup(new ArmTiltPIDCmd(Constants.pidTiltPos3), new ArmInOutPIDCmd(-90)),
            new SetIntakeCmd(1),
            new WaitCommand(.5),
            new SetIntakeCmd(0),
            new ParallelCommandGroup(new ArmInOutPIDCmd(0), new ArmTiltPIDCmd(-0))
        );
    }
    
}
