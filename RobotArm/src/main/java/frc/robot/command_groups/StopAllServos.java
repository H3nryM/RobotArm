package frc.robot.command_groups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.servo.MyServo;
import frc.robot.servo.StopServo;

public class StopAllServos extends ParallelCommandGroup {

  /**
   * Stops all servos. Does not brake.
   */
  public StopAllServos(MyServo hingeMyServo, MyServo spinMyServo, MyServo leftBaseMyServo, MyServo rightBaseMyServo, 
  MyServo extenderMyServo) {
    super(new StopServo(hingeMyServo), new StopServo(spinMyServo), new StopServo(leftBaseMyServo), new StopServo(rightBaseMyServo),
    new StopServo(extenderMyServo));
  }
}
