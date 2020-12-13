package frc.robot.limelight;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.servo.MyServo;

public class AToBWLimelight extends CommandBase {
  
  private MyServo myServo;
  private LimelightSub limelight;
  private double p1;
  private double ca; // current angle
  private double runCount;
  private boolean done;
  private double iT;
  private double delay;
  private boolean horizontal;

  /**
   * Creates a new MovemyServo.
   */
  public AToBWLimelight(LimelightSub limelight, MyServo myServo, double p1, boolean horizontal) {
  // addRequirements(limelight);
  this.limelight = limelight;
  this.myServo = myServo;
  this.p1 = p1;
  this.horizontal = horizontal;
  }

  @Override
  public void initialize() {
    System.out.println(myServo.getAngle());
    System.out.println(ca);
    runCount = 0;
    done = false;
  }

  @Override
  public void execute() {
    System.out.println(myServo.getAngle());
    runCount++;
    if(runCount == 1){
    iT = System.currentTimeMillis();
    delay=300;
    myServo.setAngle(p1);
    ca=p1;
    }

    if(horizontal){
    if(System.currentTimeMillis() - iT > delay){
    // if(ca+limelight.getTx() > 15 || ca+limelight.getTx() < -15){
    //   ca=ca-(0.25*limelight.getTx());
    // } else{ca=ca-(limelight.getTx());}
    ca=ca-limelight.getTx();
    myServo.setAngle(ca);
    if(limelight.getTx()<1 && limelight.getTx()>-1){
      done = true;
        }
        delay=delay+System.currentTimeMillis()-iT;
      }
    } else {
      if(System.currentTimeMillis() - iT > delay){
      myServo.setAngle(p1+limelight.getTy());
      if(limelight.getTy()<1 && limelight.getTy()>-1){
      done = true;
        }
      }
    }

  }

  @Override
  public void end(boolean interrupted) {
    myServo.stopMotor();
    runCount = 0;
    done = false;
    System.out.println("done");
  }
  
  @Override
  public boolean isFinished() {
    return done;
  }

}
