package frc.robot.autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ArmTiltPIDCmd;
import frc.robot.subsystems.ArmTiltSubsystem;
import frc.robot.subsystems.driveTrain;
import frc.robot.commands.AutonDriveCmd;

public class AutonOneConeExit extends SequentialCommandGroup {
    
    public AutonOneConeExit(ArmTiltSubsystem a, driveTrain dt) {
        addCommands(
            new ArmTiltPIDCmd(a, -20),
            new ArmTiltPIDCmd(a, -5),
            new AutonDriveCmd(dt, 30)
        );
    }
}
