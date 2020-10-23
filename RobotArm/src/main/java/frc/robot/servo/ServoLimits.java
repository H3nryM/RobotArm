package frc.robot.servo;

/**
 * Sets my own limits for Servo rotation.
 */
public enum ServoLimits {

    // HingeServoMax(ServoStartingPositions.HingeServoWall.val),
    // HingeServoMin(ServoStartingPositions.HingeServoCar.val),
    HingeServoMax(90),
    HingeServoMin(65),

    SpinServoMax(ServoStartingPositions.SpinServoWall.val + 5),
    SpinServoMin(ServoStartingPositions.SpinServoCar.val - 5),

    LeftBaseServoMax(/*ServoStartingPositions.LeftBaseServo*/ 90),
    RightBaseServoMax(/*ServoStartingPositions.RightBaseServo*/ 90),
    LeftBaseServoMin(/*ServoStartingPositions.LeftBaseServo*/ 90),
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
