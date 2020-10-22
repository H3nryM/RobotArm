package frc.robot.servo;

/**
 * Sets my own limits for Servo rotation.
 */
public enum ServoLimits {

    HingeServoMax(ServoStartingPositions.HingeServoWall.val),
    HingeServoMin(ServoStartingPositions.HingeServoCar.val),

    // SpinServoMax(),
    // SpinServoMin(),


    ;


    public final double val; 
    ServoLimits(double val){
        this.val = val;
    }

}
