package frc.robot.servo;

/**
 * Sets my own limits for Servo rotation.
 */
public enum ServoLimits {

    HingeServoMax(ServoStartingPositions.HingeServoWall.val),
    HingeServoMin(ServoStartingPositions.HingeServoCar.val),

    SpinServoMax(75),
    SpinServoMin(0),

    LeftBaseServoMax(/*ServoStartingPositions.LeftBaseServo*/ 135),
    RightBaseServoMax(/*ServoStartingPositions.RightBaseServo*/ 90),
    LeftBaseServoMin(/*ServoStartingPositions.LeftBaseServo*/ 45),
    RightBaseServoMin(/*ServoStartingPositions.RightBaseServo*/ 90),

    ExtenderServoMax(/*ServoStartingPositions.ExtenderServoWall.val*/ 90),
    ExtenderServoMin(/**/ 90),

    TipUpDownServoMax(/**/ 90),
    TipUpDownServoMin(/**/ 90),

    TipSpinServoMax(/**/ 90),
    TipSpinServoMin(/**/ 90),

    ;

    public final double val; 
    ServoLimits(double val){
        this.val = val;
    }
}
