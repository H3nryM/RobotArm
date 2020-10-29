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
  double lBase, MyServo rightBaseMyServo, double rBase, MyServo extenderMyServo, double extender, MyServo tipUpDownMyServo, 
  double tipUpDown, boolean brake) {
    super(new MoveServo(hingeMyServo, hinge, brake), new MoveServo(spinMyServo, spin, brake), new MoveServo(leftBaseMyServo, lBase, 
    brake), new MoveServo(rightBaseMyServo, rBase, brake), new MoveServo(extenderMyServo, extender, brake), new MoveServo(tipUpDownMyServo, 
    tipUpDown, brake));
  }
}
