package frc.robot.servo;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.servo.MyServo;

public class MoveServo extends CommandBase {
  
  private Servo servo;
  private MyServo myServo;
  private double position;
  private boolean done;
  private double iT;
  private double runCount;
  private boolean isServo;

  /**
   * Creates a new Servo MoveServo.
   */
  public MoveServo(Servo servo, double position) {
  this.servo = servo;
  this.position = position;
  }

  /**
   * Creates a new MyServo MoveServo.
   */
  public MoveServo(MyServo myServo, double position) {
    this.myServo = myServo;
    this.position = position;
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
      if(servo!=null){isServo=true;}
      else{isServo=false;}
      iT=System.currentTimeMillis();
      }
      if(isServo){
      System.out.println(servo.getAngle());
      servo.setAngle(position);
      if(System.currentTimeMillis() - iT > 500 && servo.getAngle() == position){
        done = true;
      }
    } else {
      System.out.println(myServo.getAngle());
      myServo.setAngle(position);
      if(System.currentTimeMillis() - iT > 500){
        done = true;
      }
    }
  }

  @Override
  public void end(boolean interrupted) {
    if(isServo){servo.stopMotor();}
    else{myServo.stopMotor();}
    done = false;
    runCount = 0;
    System.out.println("done");
  }
  
  @Override
  public boolean isFinished() {
    return done;
  }

}
