package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsytem extends SubsystemBase {
    private CANSparkMax left = new CANSparkMax(Constants.INTAKE_LEFT, MotorType.kBrushless);
    private RelativeEncoder leftEncoder;
    private CANSparkMax right = new CANSparkMax(Constants.INTAKE_RIGHT, MotorType.kBrushless);
    private RelativeEncoder rightEncoder;

    public IntakeSubsytem(){
        leftEncoder = left.getEncoder();
        rightEncoder = right.getEncoder();
    }

    public void run(double speed){
        left.set(-speed);
        right.set(speed);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }

}
