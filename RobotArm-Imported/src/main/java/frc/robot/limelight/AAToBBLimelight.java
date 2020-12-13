package frc.robot.limelight;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.limelight.LimelightSub;
import frc.robot.servo.MyServo;

public class AAToBBLimelight extends CommandBase {
  
  private MyServo myServo1;
  private MyServo myServo2;
  private LimelightSub limelight;
  private double p1s1;
  private double p1s2;
  private double runCount;
  private boolean done;
  private double iT;
  private double totalTurn;
  private double delay;
  private boolean d1;

  /**
   * Creates a new MovemyServo. SERVO 1 MUST BE A HORIZONTAL MOVEMENT. SERVO 2 MUST BE VERTICAL
   * @param myServo1 HORIZONTAL
   * @param myServo2 VERTICAL
   */
  public AAToBBLimelight(LimelightSub limelight, MyServo myServo1, double p1s1, MyServo myServo2, double p1s2) {
  addRequirements(limelight);
  this.limelight = limelight;
  this.myServo1 = myServo1;
  this.myServo2 = myServo2;
  this.p1s1 = p1s1;
  this.p1s2 = p1s2;
  }

  @Override
  public void initialize() {
    System.out.println(myServo1.getAngle() + " and " + myServo2.getAngle());
    System.out.println(p1s1 + " " + p1s2);
    runCount = 0;
    d1=false;
    done = false;
  }

  @Override
  public void execute() {
    System.out.println(myServo1.getAngle() + " and " + myServo2.getAngle());
    runCount++;
    if(runCount == 1){
    iT = System.currentTimeMillis();
    if(limelight.getTx()-p1s1>limelight.getTy()-p1s2){totalTurn=limelight.getTx()-p1s1;}
    else{totalTurn=limelight.getTy()-p1s2;}
    delay=Math.abs(totalTurn)*5;
    d1=false;
    myServo1.setAngle(p1s1);
    myServo1.setAngle(p1s2);
    }
    if(System.currentTimeMillis() - iT > delay){
    myServo1.setAngle(p1s1+limelight.getTx());
    if(limelight.getTx()<1){
      d1=true;
        }
      }
    if(d1){
    if(System.currentTimeMillis() - iT > delay){
    myServo2.setAngle(p1s2+limelight.getTy());
    if(limelight.getTy()<1){
      done=true;
      }
    }
  }

  }

  @Override
  public void end(boolean interrupted) {
    // myServo1.stopMotor();
    // myServo2.stopMotor();
    runCount = 0;
    done = false;
    d1=false;
    System.out.println("done");
  }
  
  @Override
  public boolean isFinished() {
    return done;
  }

}
