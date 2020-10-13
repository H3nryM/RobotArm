package frc.robot;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.limelight.LimelightSub;
import frc.robot.limelight.MoveToTx;
import frc.robot.servo.MoveServo;
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
    // joystick.getA()
    // .whenPressed(new MoveServo(testServo, 150));
    // joystick.getB()
    // .whenPressed(new MoveServo(testServo, 15));
    joystick.getA()
    .whenPressed(new SpeedServo(testServo, 150, 10));
    joystick.getB()
    .whenPressed(new SpeedServo(testServo, 90, 3));
    joystick.getXButtonValue()
    .whenPressed(new SpeedServo(testServo, 45, 3));
    joystick.getYButtonValue()
    .whileHeld(new MoveToTx(limelight, testServo));

  }

}
