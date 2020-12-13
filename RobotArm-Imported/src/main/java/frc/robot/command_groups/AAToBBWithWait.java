package frc.robot.command_groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.limelight.AToBWLimelight;
import frc.robot.limelight.LimelightSub;
import frc.robot.servo.MyServo;
import frc.robot.servo.StopServo;

public class AAToBBWithWait extends SequentialCommandGroup {

  /**
   * Creates a new AAToBBWithWait.
   * @param wait in ms
   */
  public AAToBBWithWait(LimelightSub limelight, MyServo myServo1, double p1s1, MyServo myServo2, double p1s2, double wait) {
    super(new AToBWLimelight(limelight, myServo1, p1s1, true), new MyWait(wait), new StopServo(myServo1),
    new AToBWLimelight(limelight, myServo2, p1s2, true), new MyWait(wait), new StopServo(myServo2));
  }
}
