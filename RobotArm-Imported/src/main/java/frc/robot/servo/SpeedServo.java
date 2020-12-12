package frc.robot.servo;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SpeedServo extends CommandBase {

  private Servo servo;
  private double position;
  private int breakpoints;
  private double totalTurn;
  private double fpos;
  private int count;
  private double iTime;
  private int runCount;

  /**
   * Creates a new MoveServo.
   */
  public SpeedServo(Servo servo, double position, int breakpoints) {
    this.servo = servo;
    this.position = position;
    this.breakpoints = breakpoints;
  }

  @Override
  public void initialize() {
    runCount = 0;
  }

  @Override
  public void execute() {
    System.out.println(servo.getAngle());
    System.out.println("TT: " + totalTurn);
    runCount++;
    if(runCount==1){
    iTime = System.currentTimeMillis();
    totalTurn = position - servo.getAngle();
    System.out.println("INITTOTALTURN: " + totalTurn);
    if(totalTurn < 0){
      System.out.println("Negative turn!");
      fpos = Math.abs(totalTurn) / breakpoints;
      fpos = servo.getAngle() - fpos;
      count = 0;
    } else {
      fpos = totalTurn / breakpoints;
      fpos = fpos + servo.getAngle();
      count = 0;
    }
  }
    if(totalTurn < 0){
      if(System.currentTimeMillis() - iTime > 250){
        System.out.println("Negative turn!!");
        servo.setAngle(fpos - (count * fpos));
        count++;
        iTime = System.currentTimeMillis();
      }
    } else {
    if(System.currentTimeMillis() - iTime > 250){
    servo.setAngle(fpos + (count * fpos));
    count++;
    iTime = System.currentTimeMillis();
      }
    }

  }

  @Override
  public void end(boolean interrupted) {
    servo.stopMotor();
    runCount=0;
  }
  
  @Override
  public boolean isFinished() {
    if (servo.getAngle() <= position++ && servo.getAngle() >= position--){
      System.out.println("Done!");
      return true;}
    else{return false;}
  }

}
