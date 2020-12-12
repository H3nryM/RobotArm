package frc.robot.limelight;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimelightSub extends SubsystemBase{

    public LimelightSub(){}

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx"); 
    NetworkTableEntry ty = table.getEntry("ty"); 
    
    String current;

    @Override
    public void periodic(){
        // to test limelight's functionality
        double x = tx.getDouble(0);
        double y = ty.getDouble(0);
        SmartDashboard.putNumber("tx", x);
        SmartDashboard.putNumber("ty", y);
    }

    // public double getTx(){return -ty.getDouble(0);} // negated and tx is ty due to cam rotation
    // public double getTy(){return -tx.getDouble(0);} // negated and ty is tx due to cam rotation
    public double getTx(){return tx.getDouble(0);} // just for testing without payload
    public double getTy(){return ty.getDouble(0);} // just for testing without payload
}
