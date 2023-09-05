package frc.robot.autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ArmTiltPIDCmd;
import frc.robot.subsystems.ArmTiltSubsystem;

public class AutonOneCone extends SequentialCommandGroup {
    
    public AutonOneCone() {
        addCommands(
            new ArmTiltPIDCmd(-20),
            new ArmTiltPIDCmd(-5)
        );
    }
}
