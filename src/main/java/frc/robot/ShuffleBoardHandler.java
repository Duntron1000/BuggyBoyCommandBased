package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.networktables.GenericEntry;
import frc.robot.subsystems.*;

public class ShuffleBoardHandler {

    private ShuffleboardTab driveTab;
    private ArmInOutSubsystem inout;
    private ArmTiltSubsystem tilt;
    private driveTrain drive;
    private IntakeSubsytem intake;
    private Pneumatics p;
    private static ShuffleBoardHandler handler;
    private SendableChooser m_chooser;

    private ShuffleboardTab tab;
    private GenericEntry inoutSetpoint, tiltSetpoint;

    public ShuffleBoardHandler(){
        driveTab = Shuffleboard.getTab("Drive");
        this.inout = ArmInOutSubsystem.getInstance();
        this.tilt = ArmTiltSubsystem.getInstance();
        this.drive = driveTrain.getInstance();
        this.intake = IntakeSubsytem.getInstance();
        this.p = Pneumatics.getInstance();
        m_chooser = new SendableChooser<>();
    }

    public void setup(){
        tab = Shuffleboard.getTab("Drive"); 

        tab.add("Autons", m_chooser);       

        inoutSetpoint = tab.add("Arm Inout SetPosition: ", inout.getSetpoint()).getEntry();
        tiltSetpoint = tab.add("Arm Tilt setpoint: ", tilt.getSetpoint()).getEntry();
  


        m_chooser.setDefaultOption("Nothing", Constants.kDefaultAuto);
        m_chooser.addOption("Exit Community", Constants.kCustomAuto1);
        m_chooser.addOption("One Cone", Constants.kCustomAuto2);
        m_chooser.addOption("One Cone Exit", Constants.kCustomAuto3);

    }

    public void update(){
        inoutSetpoint.setDouble(inout.getSetpoint());
        tiltSetpoint.setDouble(tilt.getSetpoint());
    }

    public static ShuffleBoardHandler getInstance(){
        if (handler == null){
            handler = new ShuffleBoardHandler();
        }
        return handler;
    }
    
}
