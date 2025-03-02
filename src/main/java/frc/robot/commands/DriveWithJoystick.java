package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveTrainSystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class DriveWithJoystick extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private final DriveTrainSystem driveTrainSystem;
  double drive;
  double turn;
  private CommandXboxController joystick1;
  
  public DriveWithJoystick(DriveTrainSystem driveTrainSystem, CommandXboxController joy1) {
    this.driveTrainSystem = driveTrainSystem;
    this.joystick1 = joy1;

    addRequirements(driveTrainSystem);
  }

  @Override
  public void initialize()
   {
    drive = 0;
    turn = 0;
  }

  @Override
  public void execute() {
    drive = joystick1.getRawAxis(Constants.ControlsJoystick.leftMotors) * driveTrainSystem.currentState.velocity;
    turn = joystick1.getRawAxis(Constants.ControlsJoystick.rightMotors) * driveTrainSystem.currentState.velocity;

    driveTrainSystem.arcadeMode(drive, turn);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
