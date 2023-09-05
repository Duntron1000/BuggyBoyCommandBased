package frc.robot.autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ArmTiltPIDCmd;
import frc.robot.subsystems.ArmTiltSubsystem;
import frc.robot.subsystems.driveTrain;
import frc.robot.commands.AutonDriveCmd;

public class AutonOneConeExit extends SequentialCommandGroup {
    
    public AutonOneConeExit() {
        addCommands(
            new ArmTiltPIDCmd(-20),
            new ArmTiltPIDCmd(-5),
            new AutonDriveCmd(30, .5)
        );
    }
}
