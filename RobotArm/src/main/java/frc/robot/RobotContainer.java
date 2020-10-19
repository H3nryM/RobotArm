package frc.robot;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.limelight.LimelightSub;
import frc.robot.limelight.MoveToTx;
import frc.robot.servo.MoveServo;
import frc.robot.servo.ServoAToBwBPs;
import frc.robot.servo.ServoPointAToB;
import frc.robot.servo.SpeedServo;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

  private final PaddedXbox joystick = new PaddedXbox();
  private final LimelightSub limelight = new LimelightSub();
  private final Servo testServo = new Servo(1);


  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    joystick.getA()
    .whenPressed(new MoveServo(testServo, 170));
    // joystick.getB()
    // .whenPressed(new MoveServo(testServo, 15));
    // joystick.getA()
    // .whenPressed(new SpeedServo(testServo, 150, 10));
    // joystick.getB()
    // .whenPressed(new SpeedServo(testServo, 90, 3));
    // joystick.getXButtonValue()
    // .whenPressed(new SpeedServo(testServo, 45, 3));
    // joystick.getYButtonValue()
    // .whileHeld(new MoveToTx(limelight, testServo));
    joystick.getB()
    .whenPressed(new ServoPointAToB(testServo, 75, 135));
    joystick.getXButtonValue()
    .whenPressed(new ServoPointAToB(testServo, 150, 45));
    joystick.getYButtonValue()
    .whenPressed(new ServoAToBwBPs(testServo, 20, 160, 4));

  }

}
