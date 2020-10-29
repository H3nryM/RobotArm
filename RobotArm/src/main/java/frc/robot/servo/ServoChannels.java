package frc.robot.servo;

public enum ServoChannels {

    HingeServoChannel(1),
    SpinServoChannel(6),
    LeftBaseServoChannel(2),
    RightBaseServoChannel(3),
    ExtenderServoChannel(4),
    TipUpDownServoChannel(5),
    
    ;

    public final int val; 
    ServoChannels(int val){
        this.val = val;
    }
}

