package frc.robot.commands.Manipulator;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.RobotContainer;
import frc.robot.Constants.EstadoClimber;
import frc.robot.Constants.EstadoCoral;
import frc.robot.Constants.ConstantesTracao;
import frc.robot.Constants.EstadoTracao;
import frc.robot.Constants.DescerAlgaEstado;
import frc.robot.Constants.ConstantesSistemaDescerAlga;

public class DefinirEstadoMecanismo extends InstantCommand {
  
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
      private EstadoCoral currentStateCoral = EstadoCoral.PARADO;
      private EstadoTracao currentStateDriveTrain = EstadoTracao.PARADO;
      private EstadoClimber currentStateClimberG = EstadoClimber.PARADO;
      private DescerAlgaEstado currentStateDesceA = DescerAlgaEstado.PARADO;

    boolean currentStateCoralOnly = false;
    boolean currentStateDriveTrainOnly = false;
    boolean currentStateClimberGOnly = false;
    boolean currentStateDesceAOnly = false;
    boolean currentPosition = false;

    public DefinirEstadoMecanismo(EstadoCoral estado) {
      this.currentStateCoral = estado;
      addRequirements(RobotContainer.sistemaCoral);
      currentStateCoralOnly = true;
    }

    public DefinirEstadoMecanismo(EstadoTracao estado) {
      this.currentStateDriveTrain = estado;
      addRequirements(RobotContainer.sistemaTracao);
      currentStateDriveTrainOnly = true;
    }

    public DefinirEstadoMecanismo(EstadoClimber estado) {
      this.currentStateClimberG = estado;
      addRequirements(RobotContainer.SistemaClimber);
      currentStateClimberGOnly = true;
    }
    
    public DefinirEstadoMecanismo(DescerAlgaEstado estado) {
      this.currentStateDesceA = estado;
      addRequirements(RobotContainer.SistemaDescerAlga);
      currentStateDesceAOnly = true;
    }

    @Override
  public void initialize() {
    if(currentStateCoralOnly) {
      RobotContainer.sistemaCoral.SetCurrentState(this.currentStateCoral);
    } else if(currentStateDriveTrainOnly){
      RobotContainer.sistemaTracao.SetCurrentState(this.currentStateDriveTrain);
    }else if(currentStateClimberGOnly){
      RobotContainer.SistemaClimber.SetCurrentState(this.currentStateClimberG);
    }else if(currentStateDesceAOnly){
      RobotContainer.SistemaDescerAlga.SetCurrentState(this.currentStateDesceA);
    }
  } 
}