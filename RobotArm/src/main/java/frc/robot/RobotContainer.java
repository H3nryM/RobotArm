package frc.robot;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.command_groups.MoveAllServos;
import frc.robot.limelight.AToBWLimelight;
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
  private final MyServo spinMyServo = new MyServo(ServoChannels.SpinServoChannel.val);
  private final MyServo leftBaseMyServo = new MyServo(ServoChannels.LeftBaseServoChannel.val);
  private final MyServo rightBaseMyServo = new MyServo(ServoChannels.RightBaseServoChannel.val);
  private final MyServo extenderMyServo = new MyServo(ServoChannels.ExtenderServoChannel.val);
  private final MyServo tipUpDownMyServo = new MyServo(ServoChannels.TipUpDownServoChannel.val);


  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    joystick.getA()
    .whileHeld(new AToBWLimelight(limelight, spinMyServo, ServoStartingPositions.SpinServoCar.val, true));
    
    // joystick.getXButtonValue()
    // .whenPressed(new MoveAllServos(hingeMyServo, ServoStartingPositions.HingeServoWall.val, spinMyServo, 
    // ServoStartingPositions.SpinServoWall.val, leftBaseMyServo, ServoStartingPositions.LeftBaseServoWall.val, rightBaseMyServo, 
    // ServoStartingPositions.RightBaseServoWall.val, extenderMyServo, ServoStartingPositions.ExtenderServoWall.val, 
    // tipUpDownMyServo, ServoStartingPositions.TipUpDownServoWall.val, true));
     
    // joystick.getYButtonValue()
    // .whenPressed(new MoveAllServos(hingeMyServo, ServoStartingPositions.HingeServoCar.val, spinMyServo, 
    // ServoStartingPositions.SpinServoCar.val, leftBaseMyServo, ServoStartingPositions.LeftBaseServoCar.val, rightBaseMyServo, 
    // ServoStartingPositions.RightBaseServoCar.val, extenderMyServo, ServoStartingPositions.ExtenderServoCar.val, 
    // tipUpDownMyServo, ServoStartingPositions.TipUpDownServoCar.val, true));

  }

}
