package frc.robot;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveServo;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

  private final PaddedXbox joystick = new PaddedXbox();
  private final Servo testServo = new Servo(1);


  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    joystick.getA()
    .whenPressed(new MoveServo(testServo, 0.5));
  }

}
