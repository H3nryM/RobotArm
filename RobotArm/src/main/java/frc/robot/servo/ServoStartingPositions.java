package frc.robot.servo;

public enum ServoStartingPositions{

    // for the servo that actuates the hinge, 2 default positions - 
    // first is flat against wall, other is 90 degrees pointing at car
    HingeServoWall(135),
    HingeServoCar(0),

    //for the servo that spins the robot arm
    SpinServoWall(39),
    SpinServoCar(39),

    // for the (i think) 2 servos that move the arm forward nearest the base
    LeftBaseServoWall(90),
    RightBaseServoWall(90),
    LeftBaseServoCar(90),
    RightBaseServoCar(90),
    
    // for the (i think) servo that moves the arm forward (above the base servos)
    ExtenderServoWall(90),
    ExtenderServoCar(90),

    // for the small servo at the end of the arm that tilts the L up and down
    TipUpDownServoWall(90),
    TipUpDownServoCar(90),

    // for the small servo at the end of the arm that spins the L
    TipSpinServoWall(90),
    TipSpinServoCar(90),

    ;

    public final double val; 
    ServoStartingPositions(double val){
        this.val = val;
    }
}
