package frc.robot.servo;

public enum ServoStartingPositions{

    // for the servo that actuates the hinge, 2 default positions - 
    // first is flat against wall, other is 90 degrees pointing at car
    HingeServoWall(ServoLimits.HingeServoMax.val),
    HingeServoCar(ServoLimits.HingeServoMin.val),

    //for the servo that spins the robot arm
    SpinServoWall(39),
    SpinServoCar(39),

    // for the (i think) 2 servos that move the arm forward nearest the base
    LeftBaseServoWall(180),
    RightBaseServoWall(180-LeftBaseServoWall.val),
    LeftBaseServoCar(55),
    RightBaseServoCar(180-LeftBaseServoCar.val),
    
    // for the (i think) servo that moves the arm forward (above the base servos)
    ExtenderServoWall(ServoLimits.ExtenderServoMax.val),
    ExtenderServoCar(ServoLimits.ExtenderServoMin.val),

    // for the small servo at the end of the arm that tilts the L up and down
    TipUpDownServoWall(150),
    TipUpDownServoCar(30),

    ;

    public final double val; 
    ServoStartingPositions(double val){
        this.val = val;
    }
}
