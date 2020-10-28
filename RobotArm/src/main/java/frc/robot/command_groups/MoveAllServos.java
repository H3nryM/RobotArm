package frc.robot.command_groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.servo.MoveServo;
import frc.robot.servo.MyServo;
import frc.robot.servo.ServoChannels;

public class MoveAllServos extends SequentialCommandGroup {

  private final static MyServo hingeMyServo = new MyServo(ServoChannels.HingeServoChannel.val);
  private final static MyServo spinMyServo = new MyServo(ServoChannels.SpinServoChannel.val);
  private final static MyServo leftBaseMyServo = new MyServo(ServoChannels.LeftBaseServoChannel.val);
  private final static MyServo rightBaseMyServo = new MyServo(ServoChannels.RightBaseServoChannel.val);
  private final static MyServo extenderMyServo = new MyServo(ServoChannels.ExtenderServoChannel.val);
  private final static MyServo tipUpDownMyServo = new MyServo(ServoChannels.TipUpDownServoChannel.val);


  /**
   * Creates a new MoveAllServos to move all of the servos.
   */
  public MoveAllServos(double hinge, double spin, double lBase, double rBase, double extender, double tipUpDown, boolean brake) {
    super(new MoveServo(hingeMyServo, hinge, brake), new MoveServo(spinMyServo, spin, brake), new MoveServo(leftBaseMyServo, lBase, 
    brake), new MoveServo(rightBaseMyServo, rBase, brake), new MoveServo(extenderMyServo, extender, brake), new MoveServo(tipUpDownMyServo, 
    tipUpDown, brake));
  }
}
