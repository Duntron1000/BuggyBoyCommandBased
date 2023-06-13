// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static final int CAN_LEFT1 = 1;
  public static final int CAN_LEFT2 = 2;
  public static final int CAN_RIGHT1 = 3;
  public static final int CAN_RIGHT2 = 4;
  public static final int CAN_ARMTILT = 6;

  public static final double TILT_KP = 0.075; 
  public static final double TILT_KI = 0;
  public static final double TILT_KD = 0; 
  public static final double TILT_KIz = 0; 
  public static final double TILT_KFF = 0; 
  public static final double TILT_KMaxOutput = 1; 
  public static final double TILT_KMinOutput = -1;

  public static final double EXTEND_KP = 0.15; 
  public static final double EXTEND_KI = 0;
  public static final double EXTEND_KD = 0; 
  public static final double EXTEND_KIz = 0; 
  public static final double EXTEND_KFF = 0; 
  public static final double EXTEND_KMaxOutput = 1; 
  public static final double EXTEND_KMinOutput = -1;

  public static final int INTAKE_LEFT = 8;
  public static final int INTAKE_RIGHT = 9;

  public static final int ARM_INOUT = 7;
}
