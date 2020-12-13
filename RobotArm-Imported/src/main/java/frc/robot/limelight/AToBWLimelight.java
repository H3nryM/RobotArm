package frc.robot.limelight;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.servo.MyServo;

public class AToBWLimelight extends CommandBase {
  
  private MyServo myServo;
  private LimelightSub limelight;
  private double p1;
  private double p2;
  private double runCount;
  private boolean done;
  private double iT;
  private double totalTurn;
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
    System.out.println(p1 + " " + p2);
    runCount = 0;
    done = false;
  }

  @Override
  public void execute() {
    System.out.println(myServo.getAngle());
    runCount++;
    if(runCount == 1){
    iT = System.currentTimeMillis();
    totalTurn = p2-p1;
    delay=Math.abs(totalTurn)*5;
    myServo.setAngle(p1);
    }
    if(horizontal){
    if(System.currentTimeMillis() - iT > delay){
    myServo.setAngle(p1+limelight.getTx());
    if(limelight.getTx()<1){
      // done = true;
        }
      }
    } else {
      if(System.currentTimeMillis() - iT > delay){
      myServo.setAngle(p1+limelight.getTy());
      if(limelight.getTy()<1){
      // done = true;
        }
      }
    }

  }

  @Override
  public void end(boolean interrupted) {
    // myServo.stopMotor();
    runCount = 0;
    done = false;
    System.out.println("done");
  }
  
  @Override
  public boolean isFinished() {
    return done;
  }

}
