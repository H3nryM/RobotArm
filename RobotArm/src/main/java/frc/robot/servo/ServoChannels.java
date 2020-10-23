package frc.robot.servo;

public enum ServoChannels {

    HingeServoChannel(0),
    SpinServoChannel(1),
    LeftBaseServoChannel(2),
    RightBaseServoChannel(3),
    ExtenderServoChannel(4),
    TipUpDownServoChannel(5),
    TipSpinServoChannel(6),
    
    ;

    public final int val; 
    ServoChannels(int val){
        this.val = val;
    }
}

