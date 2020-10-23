package frc.robot;

import edu.wpi.first.hal.FRCNetComm.tResourceType;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SendableRegistry;
import frc.robot.servo.ServoLimits;

/**
 * Standard hobby style servo.
 *
 * <p>The range parameters default to the appropriate values for the Hitec HS-322HD servo provided
 * in the FIRST Kit of Parts in 2008.
 */
public class MyServo extends PWM {
  private double kMaxServoAngle;
  private double kMinServoAngle;

  protected static final double kDefaultMaxServoPWM = 2.4;
  protected static final double kDefaultMinServoPWM = 0.6;

  /**
   * Constructor.<br>
   *
   * <p>By default {@value #kDefaultMaxServoPWM} ms is used as the maxPWM value<br> By default
   * {@value #kDefaultMinServoPWM} ms is used as the minPWM value<br>
   *
   * @param channel The PWM channel to which the servo is attached. 0-9 are on-board, 10-19 are on
   *                the MXP port
   */
  public MyServo(final int channel) {
    super(channel);
    setBounds(kDefaultMaxServoPWM, 0, 0, 0, kDefaultMinServoPWM);
    setPeriodMultiplier(PeriodMultiplier.k4X);

    // sets MY custom min/max values
    setMinMax(channel);

    HAL.report(tResourceType.kResourceType_Servo, getChannel() + 1);
    SendableRegistry.setName(this, "Servo", getChannel());
  }

  /**
   * sets my Max angles and Min Angles.
   * @param kMaxServoAngle
   * @param kMinServoAngle
   */
  public void setMinMax(int channel){
      if(channel == 0){
          kMaxServoAngle = ServoLimits.HingeServoMax.val;
          kMinServoAngle = ServoLimits.HingeServoMin.val;
      } else if (channel == 1){
        kMaxServoAngle = ServoLimits.SpinServoMax.val;
        kMinServoAngle = ServoLimits.SpinServoMin.val;
      } else if (channel == 2){
        kMaxServoAngle = ServoLimits.LeftBaseServoMax.val;
        kMinServoAngle = ServoLimits.LeftBaseServoMin.val;
      } else if (channel == 3){
        kMaxServoAngle = ServoLimits.RightBaseServoMax.val;
        kMinServoAngle = ServoLimits.RightBaseServoMin.val;
      } else if (channel == 4){
        kMaxServoAngle = ServoLimits.ExtenderServoMax.val;
        kMinServoAngle = ServoLimits.ExtenderServoMin.val;
      } else if (channel == 5){
        kMaxServoAngle = ServoLimits.TipUpDownServoMax.val;
        kMinServoAngle = ServoLimits.TipUpDownServoMin.val;
      } else if (channel == 6){
        kMaxServoAngle = ServoLimits.TipSpinServoMax.val;
        kMinServoAngle = ServoLimits.TipSpinServoMin.val;
      }
  }

  /**
   * Set the servo position.
   *
   * <p>Servo values range from 0.0 to 1.0 corresponding to the range of full left to full right.
   *
   * @param value Position from 0.0 to 1.0.
   */
  public void set(double value) {
    setPosition(value);
  }

  /**
   * Get the servo position.
   *
   * <p>Servo values range from 0.0 to 1.0 corresponding to the range of full left to full right.
   *
   * @return Position from 0.0 to 1.0.
   */
  public double get() {
    return getPosition();
  }

  /**
   * Set the servo angle.
   *
   * <p>Assume that the servo angle is linear with respect to the PWM value (big assumption, need to
   * test).
   *
   * <p>Servo angles that are out of the supported range of the servo simply "saturate" in that
   * direction In other words, if the servo has a range of (X degrees to Y degrees) than angles of
   * less than X result in an angle of X being set and angles of more than Y degrees result in an
   * angle of Y being set.
   *
   * @param degrees The angle in degrees to set the servo.
   */
  public void setAngle(double degrees) {
    if (degrees < kMinServoAngle) {
      degrees = kMinServoAngle;
    } else if (degrees > kMaxServoAngle) {
      degrees = kMaxServoAngle;
    }

    setPosition(((degrees - kMinServoAngle)) / getServoAngleRange());
  }

  /**
   * Get the servo angle.
   *
   * <p>Assume that the servo angle is linear with respect to the PWM value (big assumption, need to
   * test).
   *
   * @return The angle in degrees to which the servo is set.
   */
  public double getAngle() {
    return getPosition() * getServoAngleRange() + kMinServoAngle;
  }

  private double getServoAngleRange() {
    return kMaxServoAngle - kMinServoAngle;
  }

  @Override
  public void initSendable(SendableBuilder builder) {
    builder.setSmartDashboardType("Servo");
    builder.addDoubleProperty("Value", this::get, this::set);
  }
}
