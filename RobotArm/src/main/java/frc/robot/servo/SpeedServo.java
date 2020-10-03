package frc.robot.servo;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SpeedServo extends CommandBase {

  private Servo servo;
  private double position;
  private int breakpoints;
  private double ipos;
  private double totalTurn;
  private double fpos;
  private int count;
  private double iTime;

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
    iTime = System.currentTimeMillis();
    count = 0;
    ipos = servo.getAngle();
    totalTurn = position - ipos;
    if(totalTurn < 0){
      
    } else {
      fpos = totalTurn / breakpoints;
    }
  }

  @Override
  public void execute() {
    if(System.currentTimeMillis() - iTime > 1000){
    servo.setAngle(fpos + (count * fpos));
    count++;
    iTime = System.currentTimeMillis();
    }
  }

  @Override
  public void end(boolean interrupted) {
  }
  
  @Override
  public boolean isFinished() {
    if (servo.getAngle() == position){return true;}
    else{return false;}
  }

}
