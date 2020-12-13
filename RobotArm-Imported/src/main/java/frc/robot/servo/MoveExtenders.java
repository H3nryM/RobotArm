package frc.robot.servo;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.servo.MyServo;

public class MoveExtenders extends CommandBase {
  
  private MyServo leftBaseMyServo;
  private MyServo rightBaseMyServo;
  private MyServo extenderMyServo;
  private double lPos;
  private double rPos;
  private double ePos;
  private boolean done;
  private double iT;
  private double runCount;
  private boolean brake;

  /**
   * Creates a new MoveServo.
   */
  public MoveExtenders(MyServo leftBaseMyServo, double lPos, MyServo rightBaseMyServo, MyServo extenderMyServo, double ePos,
   boolean brake) {
    this.leftBaseMyServo = leftBaseMyServo;
    this.rightBaseMyServo = rightBaseMyServo;
    this.extenderMyServo = extenderMyServo;
    this.lPos = lPos;
    this.rPos = 180-lPos;
    this.ePos = ePos;
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
      System.out.println("left " + leftBaseMyServo.getAngle() + " extender " + extenderMyServo.getAngle());
      leftBaseMyServo.setAngle(lPos);
      rightBaseMyServo.setAngle(rPos);
      extenderMyServo.setAngle(ePos);
      if(System.currentTimeMillis()-iT > 1000){
        done = true;
    }
  }

  @Override
  public void end(boolean interrupted) {
    if(!brake){
      leftBaseMyServo.stopMotor(); 
      rightBaseMyServo.stopMotor(); 
      extenderMyServo.stopMotor();
    }
    done = false;
    runCount = 0;
    System.out.println("done");
  }
  
  @Override
  public boolean isFinished() {
    return done;
  }

}
