package frc.robot.servo;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class MoveServo extends CommandBase {
  
  private Servo servo;
  private double position;
  private boolean done;
  private double iT;
  private double runCount;

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
    runCount = 0;
    done = false;
  }

  @Override
  public void execute() {
    runCount++;
    System.out.println(servo.getAngle());
    System.out.println(servo);
    if(runCount==1){
      iT=System.currentTimeMillis();
      }
      servo.setAngle(position);
      if(System.currentTimeMillis() - iT > 500 && servo.getAngle() == position){
        done = true;
      }
  }

  @Override
  public void end(boolean interrupted) {
    servo.stopMotor();
    done = false;
    runCount = 0;
    System.out.println("done");
  }
  
  @Override
  public boolean isFinished() {
    return done;
  }

}
