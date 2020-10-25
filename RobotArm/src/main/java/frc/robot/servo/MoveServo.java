package frc.robot.servo;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.servo.MyServo;

public class MoveServo extends CommandBase {
  
  private MyServo myServo;
  private double position;
  private boolean done;
  private double iT;
  private double runCount;
  private boolean brake;

  /**
   * Creates a new MoveServo.
   */
  public MoveServo(MyServo myServo, double position, boolean brake) {
    this.myServo = myServo;
    this.position = position;
    this.brake = brake;
    }

  @Override
  public void initialize() {
    runCount = 0;
    done = false;
  }

  @Override
  public void execute() {
    runCount++;
    if(runCount==1){
      iT=System.currentTimeMillis();
      }
      System.out.println(myServo.getAngle());
      myServo.setAngle(position);
      if(System.currentTimeMillis()-iT > 500){
        done = true;
    }
  }

  @Override
  public void end(boolean interrupted) {
    if(!brake){myServo.stopMotor();}
    done = false;
    runCount = 0;
    System.out.println("done");
  }
  
  @Override
  public boolean isFinished() {
    return done;
  }

}
