package frc.robot.autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ArmTiltPIDCmd;
import frc.robot.subsystems.ArmTiltSubsystem;

public class AutonOneCone extends SequentialCommandGroup {
    
    public AutonOneCone(ArmTiltSubsystem a) {
        addCommands(
            new ArmTiltPIDCmd(a, -20),
            new ArmTiltPIDCmd(a, -5)
        );
    }
}
