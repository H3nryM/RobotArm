package frc.robot.command_groups;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class MyWait extends CommandBase {

  private double iT;
  private double runCount;
  private boolean done;
  private double time;

  /**
   * Creates a new MyWait.
   */
  public MyWait(double time) {
    this.time = time;
  }

  @Override
  public void initialize() {
    runCount = 0;
    done = false;
  }

  @Override
  public void execute() {
    runCount++;
    if(runCount==1){iT=System.currentTimeMillis();}
    if(System.currentTimeMillis()-iT > time){done = true;}
  }

  @Override
  public void end(boolean interrupted) {
    runCount = 0;
    done = false;
  }

  @Override
  public boolean isFinished() {
    return done;
  }
}
