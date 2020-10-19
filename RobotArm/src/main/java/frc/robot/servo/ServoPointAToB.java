package frc.robot.servo;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ServoPointAToB extends CommandBase {
  
  private Servo servo;
  private double p1;
  private double p2;
  private double runCount;
  private boolean done;
  private double iT;

  /**
   * Creates a new MoveServo.
   */
  public ServoPointAToB(Servo servo, double p1, double p2) {
  this.servo = servo;
  this.p1 = p1;
  this.p2 = p2;
  }

  @Override
  public void initialize() {
    System.out.println(servo.getAngle());
    System.out.println(p1 + " " + p2);
    runCount = 0;
    done = false;
  }

  @Override
  public void execute() {
    System.out.println(servo.getAngle());
    runCount++;
    if(runCount == 1){
    iT = System.currentTimeMillis();
      servo.setAngle(p1);
    }
    if(System.currentTimeMillis() - iT > 500){
    servo.setAngle(p2);
    if(System.currentTimeMillis() - iT > 1000){
      done = true;
      }
    }
  }

  @Override
  public void end(boolean interrupted) {
    servo.stopMotor();
    runCount = 0;
    done = false;
    System.out.println("done");
  }
  
  @Override
  public boolean isFinished() {
    return done;
  }

}
