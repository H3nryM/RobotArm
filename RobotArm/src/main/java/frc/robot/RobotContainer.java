package frc.robot;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.limelight.*;
import frc.robot.command_groups.ExtendersBrake;
import frc.robot.command_groups.MoveAllServos;
import frc.robot.command_groups.StopAllServos;
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
  // private final MyServo tipUpDownMyServo = new MyServo(ServoChannels.TipUpDownServoChannel.val);


  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    
    // joystick.getA()
    // .whenPressed(new MoveServo(extenderMyServo, ServoStartingPositions.ExtenderServoMid.val, true));

    joystick.getA()
    // .whenPressed(new AToBWLimelight(limelight, spinMyServo, ServoStartingPositions.SpinServoCar.val, true)
    .whenPressed(new MoveServo(leftBaseMyServo, ServoStartingPositions.LeftBaseServoMid.val, false)
    .andThen(new MoveServo(extenderMyServo, ServoStartingPositions.ExtenderServoCar.val, false))
    .andThen(new MoveServo(leftBaseMyServo, ServoStartingPositions.LeftBaseServoCar.val, false)));
    // .andThen(new AToBWLimelight(limelight, leftB, , false)));
    // we need to then find the distance away, figure out how much to move LB then extender.
    // .andThen(new AToBWLimelight(limelight, leftBaseMyServo, ServoStartingPositions.LeftBaseServoCar.val, false)));

    joystick.getB()
    .whenPressed(new StopAllServos(hingeMyServo, spinMyServo, leftBaseMyServo, rightBaseMyServo,
    extenderMyServo));

    joystick.getXButtonValue()
    .whenPressed(new MoveAllServos(spinMyServo, ServoStartingPositions.SpinServoWall.val, spinMyServo, 
    ServoStartingPositions.SpinServoWall.val, leftBaseMyServo, ServoStartingPositions.LeftBaseServoWall.val, rightBaseMyServo, 
    extenderMyServo, ServoStartingPositions.ExtenderServoWall.val));
     
    joystick.getYButtonValue()
    .whenPressed(new MoveAllServos(spinMyServo, ServoStartingPositions.SpinServoCar.val, spinMyServo, 
    ServoStartingPositions.SpinServoCar.val, leftBaseMyServo, ServoStartingPositions.LeftBaseServoCar.val, rightBaseMyServo, 
    extenderMyServo, ServoStartingPositions.ExtenderServoCar.val));



    // joystick.getA()
    // .whenPressed(new AAToBBLimelight(limelight, spinMyServo, ServoStartingPositions.SpinServoCar.val, 
    // leftBaseMyServo, ServoStartingPositions.LeftBaseServoCar.val));

    // joystick.getB()
    // .whenPressed(new ExtenderGroup(limelight, leftBaseMyServo, ServoStartingPositions.LeftBaseServoCar.val, rightBaseMyServo, 
    // extenderMyServo, ServoStartingPositions.ExtenderServoCar.val));
    

  }

}
