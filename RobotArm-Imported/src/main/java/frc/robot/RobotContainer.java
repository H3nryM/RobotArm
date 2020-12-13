package frc.robot;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.limelight.*;
import frc.robot.command_groups.AAToBBWithWait;
import frc.robot.command_groups.ExtendersBrake;
import frc.robot.command_groups.MoveAllServos;
import frc.robot.command_groups.StopAllServos;
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
  private final MyServo spinMyServo = new MyServo(ServoChannels.SpinServoChannel.val);
  private final MyServo leftBaseMyServo = new MyServo(ServoChannels.LeftBaseServoChannel.val);
  private final MyServo rightBaseMyServo = new MyServo(ServoChannels.RightBaseServoChannel.val);
  private final MyServo extenderMyServo = new MyServo(ServoChannels.ExtenderServoChannel.val);
  // private final MyServo tipUpDownMyServo = new MyServo(ServoChannels.TipUpDownServoChannel.val);


  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    joystick.getA()
    .whenPressed(new AToBWLimelight(limelight, spinMyServo, ServoStartingPositions.SpinServoCar.val, true));

    joystick.getB()
    .whenPressed(new AToBWLimelight(limelight, extenderMyServo, ServoStartingPositions.ExtenderServoWall.val, false));

    // joystick.getB()
    // .whenPressed(new StopAllServos(hingeMyServo, spinMyServo, leftBaseMyServo, rightBaseMyServo,
    // extenderMyServo));

    joystick.getXButtonValue()
    .whenPressed(new MoveAllServos(spinMyServo, ServoStartingPositions.SpinServoWall.val, spinMyServo, 
    ServoStartingPositions.SpinServoWall.val, leftBaseMyServo, ServoStartingPositions.LeftBaseServoWall.val, rightBaseMyServo, 
    extenderMyServo, ServoStartingPositions.ExtenderServoWall.val));
     
    joystick.getYButtonValue()
    .whenPressed(new MoveAllServos(spinMyServo, ServoStartingPositions.SpinServoCar.val, spinMyServo, 
    ServoStartingPositions.SpinServoCar.val, leftBaseMyServo, ServoStartingPositions.LeftBaseServoCar.val, rightBaseMyServo, 
    extenderMyServo, ServoStartingPositions.ExtenderServoCar.val));

  }

}
