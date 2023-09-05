package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import java.util.Map;

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
    private SendableChooser<String> m_chooser;

    private ShuffleboardTab tab;
    private ShuffleboardLayout list;
    private GenericEntry inoutSetpoint, tiltSetpoint, inoutEncoder, tiltEncoder, leftEncoder, intakeMode, gyroPitch;

    public ShuffleBoardHandler(){
        driveTab = Shuffleboard.getTab("Drive");
        this.inout = ArmInOutSubsystem.getInstance();
        this.tilt = ArmTiltSubsystem.getInstance();
        this.drive = driveTrain.getInstance();
        this.intake = IntakeSubsytem.getInstance();
        this.p = Pneumatics.getInstance();
        m_chooser = new SendableChooser<String>();
    }

    public void setup(){
        tab = Shuffleboard.getTab("Drive"); 
        list = tab.getLayout("Arm", BuiltInLayouts.kList).withProperties(Map.of("Number of columns", 1, "Number of rows", 4));

        //Auton chooser
        tab.add("Autons", m_chooser);       
        
        m_chooser.setDefaultOption("Nothing", Constants.kDefaultAuto);
        m_chooser.addOption("Exit Community", Constants.kCustomAuto1);
        m_chooser.addOption("One Cone", Constants.kCustomAuto2);
        m_chooser.addOption("One Cone Exit", Constants.kCustomAuto3);
        m_chooser.addOption("One Cone Mid", Constants.kCustomAuto4);
        m_chooser.addOption("One Cone Mid Exit", Constants.kCustomAuto5);
        m_chooser.addOption("One Cone Mid Shoot", Constants.kCustomAuto6);
        m_chooser.addOption("Balance", Constants.kCustomAuto7);
        m_chooser.addOption("One Cone Balance", Constants.kCustomAuto8);
        m_chooser.addOption("Mid Cone Balance", Constants.kCustomAuto9);

        //Adds values we want to shuffleboard
        inoutSetpoint = list.add("Arm Inout SetPosition: ", inout.getSetpoint()).getEntry();
        tiltSetpoint = list.add("Arm Tilt setpoint: ", tilt.getSetpoint()).getEntry();
        inoutEncoder = list.add("Arm InOut Encoder", inout.getEncoder()).getEntry();
        tiltEncoder = list.add("Arm Tilt Encoder", tilt.getEncoder()).getEntry();
        leftEncoder = tab.add("L DT Encoder", drive.getEncoder()).getEntry();
        intakeMode = tab.add("Intake Mode", p.getCubeMode()).getEntry();
        gyroPitch = tab.add("Pitch", drive.getPitch()).getEntry();

    }

    public void update(){
        inoutSetpoint.setDouble(inout.getSetpoint());
        tiltSetpoint.setDouble(tilt.getSetpoint());
        inoutEncoder.setDouble(inout.getEncoder());
        tiltEncoder.setDouble(tilt.getEncoder());
        leftEncoder.setDouble(drive.getEncoder());
        intakeMode.setBoolean(p.getCubeMode());
        gyroPitch.setDouble(drive.getPitch());
    }

    public static ShuffleBoardHandler getInstance(){
        if (handler == null){
            handler = new ShuffleBoardHandler();
        }
        return handler;
    }
    
    public String getSelected(){
        String thing = (String)m_chooser.getSelected();
        return thing;
    }
}
