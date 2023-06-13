package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ArmInOutPIDCmd;
import frc.robot.commands.ArmTiltPIDCmd;
import frc.robot.subsystems.ArmInOutSubsystem;
import frc.robot.subsystems.ArmTiltSubsystem;

public class ArmPidCommandGroup extends SequentialCommandGroup {
    
    public ArmPidCommandGroup(ArmInOutSubsystem extend, ArmTiltSubsystem tilt, double angle, double extension) {
        addCommands(
            new ArmTiltPIDCmd(tilt, 0)
        );
    }
}
