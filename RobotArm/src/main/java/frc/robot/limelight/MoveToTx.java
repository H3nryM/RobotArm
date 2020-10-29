package frc.robot.limelight;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class MoveToTx extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    private Servo servo;
    private LimelightSub limelight;
    
    private double tx;
    private double ty;

    public MoveToTx(LimelightSub limelight, Servo servo) {
    addRequirements(limelight);
    this.limelight = limelight;
    this.servo = servo;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    SmartDashboard.putString("command status", "pid");

    tx = limelight.getTx();
    ty = limelight.getTy();
    servo.setAngle(tx);

    // distanceToTarget =  (Constants.kTargetHeight - RobotConstants.kCameraHeight) / Math.tan(Math.toRadians(ty));
    // distanceToTarget = 1.426*distanceToTarget - 52.372; // based on linear regression, hopefully accurate
    // SmartDashboard.putNumber("distance", distanceToTarget);
  }

  @Override
  public void end(boolean interrupted) {
      servo.stopMotor();
  }

  @Override
  public boolean isFinished() {
      return false;
    // return servo.getAngle() == tx+-1;
  }
}
