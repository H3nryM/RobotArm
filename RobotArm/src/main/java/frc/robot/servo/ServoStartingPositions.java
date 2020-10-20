package frc.robot.servo;

public enum ServoStartingPositions{

    // for the servo that actuates the hinge, 2 default positions - 
    // first is flat against wall, other is 90 degrees pointing at car
    HingeServoWall(150),
    HingeServoCar(0),


    ;

    public final double val; 
    ServoStartingPositions(double val){
        this.val = val;
    }

}
