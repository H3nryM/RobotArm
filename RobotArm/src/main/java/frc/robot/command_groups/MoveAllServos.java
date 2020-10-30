package frc.robot.command_groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.servo.MoveServo;
import frc.robot.servo.MyServo;
import frc.robot.servo.ServoChannels;

public class MoveAllServos extends SequentialCommandGroup {

  /**
   * Creates a new MoveAllServos to move all of the servos.
   */
  public MoveAllServos(MyServo hingeMyServo, double hinge, MyServo spinMyServo, double spin, MyServo leftBaseMyServo, 
  double lBase, MyServo rightBaseMyServo, MyServo extenderMyServo, double extender, MyServo tipUpDownMyServo, 
  double tipUpDown) {
    super(new MoveServo(hingeMyServo, hinge, false), new MoveServo(spinMyServo, spin, false), new MoveServo(leftBaseMyServo, lBase, 
    false), new MoveServo(rightBaseMyServo, 180-lBase, false), new MoveServo(extenderMyServo, extender, false), 
    new MoveServo(tipUpDownMyServo, tipUpDown, false)/*, new ExtendersBrake(leftBaseMyServo, lBase, rightBaseMyServo, 180-lBase,
    extenderMyServo, extender)*/);
  }
}
