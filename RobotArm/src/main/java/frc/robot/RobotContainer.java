package frc.robot;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.limelight.LimelightSub;
import frc.robot.limelight.MoveToTx;
import frc.robot.servo.MoveServo;
import frc.robot.servo.MyServo;
import frc.robot.servo.ServoAToBwBPs;
import frc.robot.servo.ServoChannels;
import frc.robot.servo.ServoPointAToB;
import frc.robot.servo.ServoStartingPositions;
import frc.robot.servo.SpeedServo;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

  private final PaddedXbox joystick = new PaddedXbox();
  private final LimelightSub limelight = new LimelightSub();

  // Servos
  private final MyServo hingeMyServo = new MyServo(ServoChannels.HingeServoChannel.val);
  private final MyServo spinServo = new MyServo(ServoChannels.SpinServoChannel.val);


  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    // joystick.getA()
    // .whenPressed(new MoveServo(hingeMyServo, 0));
    // joystick.getB()
    // .whenPressed(new MoveServo(hingeMyServo, 135));
    joystick.getA()
    .whenPressed(new ServoAToBwBPs(hingeMyServo, 0, 135, 5));
    joystick.getB()
    .whenPressed(new ServoAToBwBPs(hingeMyServo, 135, 0, 5));
    joystick.getXButtonValue()
    .whenPressed(new ServoPointAToB(hingeMyServo, 0, 135));
    joystick.getYButtonValue()
    .whenPressed(new ServoPointAToB(hingeMyServo, 135, 0));

  }

}
