package frc.robot.servo;

/**
 * Sets my own limits for Servo rotation.
 */
public enum ServoLimits {

    HingeServoMax(135), // aka wall
    HingeServoMin(0), // aka car

    SpinServoMax(75),
    SpinServoMin(0),

    LeftBaseServoMax(180),
    RightBaseServoMax(LeftBaseServoMax.val),
    LeftBaseServoMin(0),
    RightBaseServoMin(LeftBaseServoMin.val),

    ExtenderServoMax(170),
    ExtenderServoMin(40),

    TipUpDownServoMax(180),
    TipUpDownServoMin(0),

    ;

    public final double val; 
    ServoLimits(double val){
        this.val = val;
    }
}
