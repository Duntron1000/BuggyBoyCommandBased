package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Pneumatics extends SubsystemBase {
    //Intake pneumatic
    private final Compressor compress = new Compressor(PneumaticsModuleType.CTREPCM);
    private final DoubleSolenoid soul = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

    //Checks intake position
    public boolean cubeMode = false;

    public void toggle() {
        if (cubeMode) retract();
        else extend();
    }

    public void extend() {
        soul.set(Value.kForward);
        cubeMode = true;
    }

    public void retract() {
        soul.set(Value.kReverse);
        cubeMode = false;
    }
}
