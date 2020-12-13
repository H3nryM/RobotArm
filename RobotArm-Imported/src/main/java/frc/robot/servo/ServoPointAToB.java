package frc.robot.servo;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ServoPointAToB extends CommandBase {
  
  private MyServo myServo;
  private double p1;
  private double p2;
  private double runCount;
  private boolean done;
  private double iT;
  private double totalTurn;
  private double delay;

  /**
   * Creates a new MovemyServo.
   */
  public ServoPointAToB(MyServo myServo, double p1, double p2) {
  this.myServo = myServo;
  this.p1 = p1;
  this.p2 = p2;
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
    if(System.currentTimeMillis() - iT > delay){
    myServo.setAngle(p2);
    if(System.currentTimeMillis() - iT > delay*2){
      done = true;
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
