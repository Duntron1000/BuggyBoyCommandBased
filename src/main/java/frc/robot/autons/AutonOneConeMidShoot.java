package frc.robot.autons;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.ArmInOutPIDCmd;
import frc.robot.commands.ArmTiltPIDCmd;
import frc.robot.commands.SetIntakeCmd;
import frc.robot.subsystems.ArmInOutSubsystem;

public class AutonOneConeMidShoot extends SequentialCommandGroup {
    
    public AutonOneConeMidShoot(){
        addCommands(
            new SetIntakeCmd(-.5),
            new ParallelCommandGroup(new ArmTiltPIDCmd(-80), new ArmInOutPIDCmd(-30)),
            new SetIntakeCmd(1),
            new WaitCommand(.2),
            new SetIntakeCmd(0),
            new ParallelCommandGroup(new ArmInOutPIDCmd(0), new ArmTiltPIDCmd(-0))
        );
    }
}
