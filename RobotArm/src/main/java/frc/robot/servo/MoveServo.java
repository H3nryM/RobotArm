package frc.robot.servo;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class MoveServo extends CommandBase {
  
  private Servo servo;
  private double position;

  /**
   * Creates a new MoveServo.
   */
  public MoveServo(Servo servo, double position) {
  this.servo = servo;
  this.position = position;
  }

  @Override
  public void initialize() {
    System.out.println(servo.getAngle());
  }

  @Override
  public void execute() {
    System.out.println(servo.getAngle());
    servo.setAngle(position);
  }

  @Override
  public void end(boolean interrupted) {
  }
  
  @Override
  public boolean isFinished() {
    if (servo.getAngle() == position){return true;}
    else{return false;}
  }

}
