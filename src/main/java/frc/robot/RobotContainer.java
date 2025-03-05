package frc.robot;

import frc.robot.Constants.ClimberGState;
import frc.robot.Constants.CoralState;
import frc.robot.Constants.DriveTrainState;
//import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.DriveWithJoystick;

import frc.robot.commands.Manipulator.SetMechanismState;
import frc.robot.subsystems.DriveTrainSystem;
import frc.robot.subsystems.CoralScoreSystem;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ClimberGSystem;
import frc.robot.subsystems.DesceASystem;
import frc.robot.Constants.DesceAState;

public class RobotContainer {
  public static final DriveTrainSystem driveTrainSystem = new DriveTrainSystem();
  public static final CoralScoreSystem coralScoreSystem = new CoralScoreSystem();
  public static final ClimberGSystem ClimberGSystem = new ClimberGSystem();
  public static final DesceASystem DesceASystem = new DesceASystem();


  CommandXboxController joystick1 = new CommandXboxController(0);
  CommandXboxController joystick2 = new CommandXboxController(1);
  
  public RobotContainer() {
    configureBindings();
    defaultcommands();
  }

  private void configureBindings() {

    joystick1.button(1).whileTrue(new SetMechanismState(DriveTrainState.STOPPED));
    joystick1.button(5).whileTrue(new SetMechanismState(DriveTrainState.MID));
    joystick1.button(6).whileTrue(new SetMechanismState(DriveTrainState.FULL));

    joystick1.rightTrigger().whileTrue(new SetMechanismState(CoralState.SHOOTING)).onFalse(new SetMechanismState(CoralState.STOPPED));
    
    joystick1.button(3).whileTrue(new SetMechanismState(ClimberGState.CLIMBING)).onFalse(new SetMechanismState(ClimberGState.STOPPED));
    joystick1.button(2).whileTrue(new SetMechanismState(ClimberGState.RECLIMBING)).onFalse(new SetMechanismState(ClimberGState.STOPPED));
    joystick2.button(3).whileTrue(new SetMechanismState(DesceAState.DESCE)).onFalse(new SetMechanismState(DesceAState.STOPPED));
    joystick2.button(2).whileTrue(new SetMechanismState(DesceAState.REDESCE)).onFalse(new SetMechanismState(DesceAState.STOPPED));

  }

  private void defaultcommands(){
    driveTrainSystem.setDefaultCommand(new DriveWithJoystick(driveTrainSystem, joystick1));
  }
}