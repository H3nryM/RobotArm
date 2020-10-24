package frc.robot.servo;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ServoAToBwBPs extends CommandBase {
  
  private Servo servo;
  private double p1;
  private double p2;
  private double iT;
  private double runCount;
  private double dbps;
  private double bps;
  private double totalTurn;
  private double fpos;
  private double incs;
  private int count;
  private boolean done;
  private double bT = 500;

  /**
   * Creates a new MoveServo.
   */
  public ServoAToBwBPs(Servo servo, double p1, double p2, int dbps) {
  this.servo = servo;
  this.p1 = p1;
  this.p2 = p2;
  this.dbps = dbps;
  }

  @Override
  public void initialize() {
    System.out.println(servo.getAngle());
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
    totalTurn = p2 - p1;
    bps = dbps + 2;
    if(totalTurn < 0){
      incs = Math.abs(totalTurn) / bps;
      fpos = p1 - incs;
      count = 0;
    } else {
      incs = totalTurn / bps;
      fpos = p1 + incs;
      count = 0;
      }
    }

    if(System.currentTimeMillis() - iT > bT && count!=bps){
      if(totalTurn < 0){
        servo.setAngle(fpos - (count * incs));
        count++;
        iT = System.currentTimeMillis();
      } else {
        servo.setAngle(fpos + (count * incs));
        count++;
        iT = System.currentTimeMillis();
      }
    }
    if(count == bps){
      servo.setAngle(p2);
      iT=System.currentTimeMillis();
      if(System.currentTimeMillis() > bT){
        done = true;
        }
    }
  }

  @Override
  public void end(boolean interrupted) {
    servo.stopMotor();
    runCount = 0;
    done = false;
    System.out.println("done, I'm at: " +p2+ " degrees!");
  }
  
  @Override
  public boolean isFinished() {
    return done;
  }

}
