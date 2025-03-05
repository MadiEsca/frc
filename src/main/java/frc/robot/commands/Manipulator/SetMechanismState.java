package frc.robot.commands.Manipulator;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.RobotContainer;
import frc.robot.Constants.AlgaPosition;
import frc.robot.Constants.ClimberGState;
import frc.robot.Constants.CoralState;
import frc.robot.Constants.DriveTrainConstants;
import frc.robot.Constants.DriveTrainState;
import frc.robot.Constants.DesceAState;
import frc.robot.Constants.DesceAConstants;

public class SetMechanismState extends InstantCommand {
  
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
      private CoralState currentStateCoral = CoralState.STOPPED;
      private DriveTrainState currentStateDriveTrain = DriveTrainState.STOPPED;
      private ClimberGState currentStateClimberG = ClimberGState.STOPPED;
      private DesceAState currentStateDesceA = DesceAState.STOPPED;
      private AlgaPosition currentAlgaPosition = AlgaPosition.REPOUSO;

    boolean currentStateCoralOnly = false;
    boolean currentStateDriveTrainOnly = false;
    boolean currentStateClimberGOnly = false;
    boolean currentStateDesceAOnly = false;
    boolean currentPosition = false;

    public SetMechanismState(AlgaPosition altura) {
      this.currentAlgaPosition = altura;
      addRequirements(RobotContainer.DesceASystem);
      currentPosition = true;
    }

    public SetMechanismState(CoralState state) {
      this.currentStateCoral = state;
      addRequirements(RobotContainer.coralScoreSystem);
      currentStateCoralOnly = true;
    }

    public SetMechanismState(DriveTrainState state) {
      this.currentStateDriveTrain = state;
      addRequirements(RobotContainer.driveTrainSystem);
      currentStateDriveTrainOnly = true;
    }

    public SetMechanismState(ClimberGState state) {
      this.currentStateClimberG = state;
      addRequirements(RobotContainer.ClimberGSystem);
      currentStateClimberGOnly = true;
    }
    
    public SetMechanismState(DesceAState state) {
      this.currentStateDesceA = state;
      addRequirements(RobotContainer.DesceASystem);
      currentStateDesceAOnly = true;
    }

    @Override
  public void initialize() {
    if(currentStateCoralOnly) {
      RobotContainer.coralScoreSystem.SetCurrentState(this.currentStateCoral);
    } else if(currentStateDriveTrainOnly){
      RobotContainer.driveTrainSystem.SetCurrentState(this.currentStateDriveTrain);
    }else if(currentStateClimberGOnly){
      RobotContainer.ClimberGSystem.SetCurrentState(this.currentStateClimberG);
    }else if(currentStateDesceAOnly){
      RobotContainer.DesceASystem.SetCurrentState(this.currentStateDesceA);
    }else if(currentPosition){
      RobotContainer.DesceASystem.SetCurrentPosition(this.currentAlgaPosition);
    }
  }
}