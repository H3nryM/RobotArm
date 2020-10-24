package frc.robot.servo;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ServoAToBwBPs extends CommandBase {
  
  private MyServo myServo;
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
  private double delay;

  /**
   * Creates a new MoveMyServo.
   */
  public ServoAToBwBPs(MyServo myServo, double p1, double p2, int dbps) {
  this.myServo = myServo;
  this.p1 = p1;
  this.p2 = p2;
  this.dbps = dbps;
  }

  @Override
  public void initialize() {
    System.out.println(myServo.getAngle());
    runCount = 0;
    done = false;
  }

  @Override
  public void execute() {
    System.out.println(myServo.getAngle());
    runCount++;
    if(runCount == 1){
    iT = System.currentTimeMillis();
    myServo.setAngle(p1);
    totalTurn = p2 - p1;
    bps = dbps;
    delay = Math.abs(totalTurn)*5;
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
    if(System.currentTimeMillis()-iT>delay && count==bps){done=true;}
    
    if(System.currentTimeMillis()-iT > delay){
      if(totalTurn < 0){
        myServo.setAngle(fpos - (count * incs));
        count++;
        iT = System.currentTimeMillis();
      } else {
        myServo.setAngle(fpos + (count * incs));
        count++;
        iT = System.currentTimeMillis();
      }
    }

  }

  @Override
  public void end(boolean interrupted) {
    myServo.stopMotor();
    runCount = 0;
    done = false;
    System.out.println("done, I'm at: " +p2+ " degrees!");
  }
  
  @Override
  public boolean isFinished() {
    return done;
  }

}
