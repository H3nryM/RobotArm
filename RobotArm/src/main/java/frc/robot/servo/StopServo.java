package frc.robot.servo;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class StopServo extends CommandBase {
  
  private MyServo myServo;

  /**
   * Creates a new StopServo.
   */
  public StopServo(MyServo myServo) {
    this.myServo = myServo;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
    myServo.stopMotor();
  }

  @Override
  public boolean isFinished() {
    return true;
  }

}
