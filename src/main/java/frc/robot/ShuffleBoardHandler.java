package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.subsystems.*;

public class ShuffleBoardHandler {

    private ShuffleboardTab driveTab;
    private ArmInOutSubsystem inout;
    private ArmTiltSubsystem tilt;
    private driveTrain drive;
    private IntakeSubsytem intake;
    private Pneumatics p;

    public ShuffleBoardHandler(ArmInOutSubsystem inout, ArmTiltSubsystem tilt, driveTrain drive, IntakeSubsytem intake, Pneumatics p){
        driveTab = Shuffleboard.getTab("Drive");
        this.inout = inout;
        this.tilt = tilt;
        this.drive = drive; 
        this.intake = intake;
        this.p = p;
    }

    public void update(){
        driveTab.add("Arm Tilt Position: ", inout.getSetpoint());
    }
    
}
