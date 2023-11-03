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

  //Controller ports
  public static final int driverControllerPort = 0;
  public static final int operatorControllerPort = 1;

  //Xbox d-pad
  public static final int xdPadUp = 0;
  public static final int xdPadDown = 180;
  public static final int xdPadRight = 90;
  public static final int xdPadLeft = 270;
  
  //Can controllers for motors
  public static final int CAN_LEFT1 = 1;
  public static final int CAN_LEFT2 = 2;
  public static final int CAN_RIGHT1 = 3;
  public static final int CAN_RIGHT2 = 4;
  public static final int CAN_ARMTILT = 6;
  public static final int ARM_INOUT = 7;
  public static final int INTAKE_LEFT = 8;
  public static final int INTAKE_RIGHT = 9;

  //Tilt pid settings
  public static final double TILT_KP = 0.075; 
  public static final double TILT_KI = 0;
  public static final double TILT_KD = 0; 
  public static final double TILT_KIz = 0; 
  public static final double TILT_KFF = 0; 
  public static final double TILT_KMaxOutput = 1; 
  public static final double TILT_KMinOutput = -1;

  //Extend pid settings
  public static final double EXTEND_KP = 0.15; 
  public static final double EXTEND_KI = 0;
  public static final double EXTEND_KD = 0; 
  public static final double EXTEND_KIz = 0; 
  public static final double EXTEND_KFF = 0; 
  public static final double EXTEND_KMaxOutput = 1; 
  public static final double EXTEND_KMinOutput = -1;

  //Tilt pid values
  public static final double pidManualTiltSpeed = 4;
  public static final double pidTiltPos1 = -10.2;
  public static final double pidTiltPos2 = -73;
  public static final double pidTiltPos3 = -53.6;
  public static final double pidTiltPos4 = -76;

  //Extend pid values
  public static final double pidManualExtendSpeed = 4;
  public static final double pidExtendPos1 = 0;
  public static final double pidExtendPos2 = -40;
  public static final double pidExtendPos3Cube = 0;
  public static final double pidExtendPos3Cone = -419.4;
  public static final double pidExtendPos4 = 0;

  //Grabber motor speeds
  public static final double holdSpeed = -.2;
  public static final double outSlowSpeed = .2;
  public static final double outFastSpeed = .6;

  public static final String kDefaultAuto = "Nothing";
  public static final String kCustomAuto1 = "communityExit";
  public static final String kCustomAuto2 = "oneCone";
  public static final String kCustomAuto3 = "oneConeExit";
  public static final String kCustomAuto4 = "oneConeMid";
  public static final String kCustomAuto5 = "oneConeMidExit";
  public static final String kCustomAuto6 = "oneConeMidShoot";
  public static final String kCustomAuto7 = "Balance";
  public static final String kCustomAuto8 = "oneConeBalance";
  public static final String kCustomAuto9 = "oneConeMidBalance";
  public static final String kCustomAuto10 = "oneHighCube";
  public static final String kCustomAuto11 = "Mid Cube";
  public static final String kCustomAuto12 = "Mid Cube Exit";
  public static final String kCustomAuto13 = "High Cube Exit";





}
