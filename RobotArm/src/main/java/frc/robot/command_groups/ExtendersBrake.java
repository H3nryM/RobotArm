package frc.robot.command_groups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.servo.MoveServo;
import frc.robot.servo.MyServo;

public class ExtendersBrake extends ParallelCommandGroup {
  
  /**
   * Creates a new ExtendersBrake.
   */
  public ExtendersBrake(MyServo leftBaseMyServo, double lPos, MyServo rightBaseMyServo, MyServo extenderMyServo, double ePos) {
    super(new MoveServo(leftBaseMyServo, lPos, true), new MoveServo(rightBaseMyServo, 180-lPos, true),
    new MoveServo(extenderMyServo, ePos, true));
  }
}
