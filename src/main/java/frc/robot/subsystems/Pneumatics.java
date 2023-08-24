package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Pneumatics extends SubsystemBase {
    //Intake pneumatic
    //COmpressor object required to make it turn on
    private final Compressor compress = new Compressor(PneumaticsModuleType.CTREPCM);
    private final DoubleSolenoid soul = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

    //Checks intake position
    public boolean cubeMode = false;

    //Toggles the piston
    public void toggle() {
        if (cubeMode) retract();
        else extend();
    }

    //Tells the  solenoid to send air into the piston
    public void extend() {
        soul.set(Value.kForward);
        cubeMode = true;
    }

    //Tells the solenoid to send air out of the piston
    public void retract() {
        soul.set(Value.kReverse);
        cubeMode = false;
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Cube Mode: ", cubeMode);
    }
}
