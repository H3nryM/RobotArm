package frc.robot.commands;

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
  }

  @Override
  public void execute() {
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
