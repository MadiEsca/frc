package frc.robot;

import frc.robot.Constants.EstadoClimber;
import frc.robot.Constants.EstadoCoral;
import frc.robot.Constants.EstadoTracao;
//import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.TracaoControlada;

import frc.robot.commands.Manipulator.DefinirEstadoMecanismo;
import frc.robot.subsystems.SistemaTracao;
import frc.robot.subsystems.SistemaCoral;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.NovoSistemaClimber;
import frc.robot.subsystems.SistemaClimber;
import frc.robot.subsystems.SistemaDescerAlga;
import frc.robot.subsystems.SistemaPuxarAlga;
import frc.robot.Constants.EstadoDescerAlga; 

public class RobotContainer {
  public static final SistemaTracao sistemaTracao = new SistemaTracao();
  public static final SistemaCoral sistemaCoral = new SistemaCoral();
  public static final SistemaClimber SistemaClimber = new SistemaClimber();
  public static final SistemaPuxarAlga SistemaPuxarAlga = new SistemaPuxarAlga();
  public static final SistemaDescerAlga SistemaDescerAlga = new SistemaDescerAlga();
  public  NovoSistemaClimber novoSistema = new NovoSistemaClimber();

  CommandXboxController joystick1 = new CommandXboxController(0);
  CommandXboxController joystick2 = new CommandXboxController(1);
  
  public RobotContainer() {
    configureBindings();
    defaultcommands();
  }

  private void configureBindings() {

    //Controle do driver da tração
    joystick1.button(1).whileTrue(new DefinirEstadoMecanismo(EstadoTracao.PARADO));
    joystick1.button(5).whileTrue(new DefinirEstadoMecanismo(EstadoTracao.MID));
    joystick1.button(6).whileTrue(new DefinirEstadoMecanismo(EstadoTracao.FULL));

    joystick1.rightTrigger().whileTrue(new DefinirEstadoMecanismo(EstadoCoral.ATIVADO)).onFalse(new DefinirEstadoMecanismo(EstadoCoral.PARADO));
    
    

    //Controle do driver copiloto
    joystick2.button(3).whileTrue(new DefinirEstadoMecanismo(EstadoClimber.CLIMBING)).onFalse(new DefinirEstadoMecanismo(EstadoClimber.PARADO));
    joystick2.button(2).whileTrue(new DefinirEstadoMecanismo(EstadoClimber.RECLIMBING)).onFalse(new DefinirEstadoMecanismo(EstadoClimber.PARADO));
    joystick2.button(3).whileTrue(new DefinirEstadoMecanismo(EstadoDescerAlga.DESCE)).onFalse(new DefinirEstadoMecanismo(EstadoDescerAlga.PARADO));
    joystick2.button(2).whileTrue(new DefinirEstadoMecanismo(EstadoDescerAlga.SOBE)).onFalse(new DefinirEstadoMecanismo(EstadoDescerAlga.PARADO));

  }

  private void defaultcommands(){
    sistemaTracao.setDefaultCommand(new TracaoControlada(sistemaTracao, joystick1));
  }
}