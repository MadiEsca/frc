package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import javax.lang.model.util.ElementScanner14;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkClosedLoopController;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.EstadoClimber;

public class SistemaClimber extends SubsystemBase {
  public SparkMax MotorClimber = new SparkMax(Constants.ConstanteSistemaClimber.ClimberMotorsID, MotorType.kBrushless);
 
  SparkMaxConfig configuracaoMotorClimber = new SparkMaxConfig();

  public EstadoClimber currentState = EstadoClimber.PARADO;

  public SistemaClimber() {
    configuracaoMotorClimber.inverted(true).idleMode(IdleMode.kBrake);
  
    MotorClimber.configure(configuracaoMotorClimber, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    MotorClimber.getEncoder().setPosition(0); //Reiniciando o valor do climber
  }

  @Override
  public void periodic() {

    if(currentState == EstadoClimber.CLIMBING){
      MotorClimber.set(currentState.velocidade);
    }else if(currentState == EstadoClimber.RECLIMBING) {
      MotorClimber.set(currentState.velocidade);
    }else{
      MotorClimber.set(EstadoClimber.PARADO.velocidade);
    }

    //if(currentState == ClimberGState.CLIMBING && EncoderClimber() < 30.0 ){
    //  ClimberGMotor.set(currentState.speed);
    //} else if(currentState == ClimberGState.RECLIMBING && EncoderClimber() >= 0) {
    //  ClimberGMotor.set(currentState.speed);
    //} else{
    //  ClimberGMotor.set(ClimberGState.STOPPED.speed);
    //} 
  }
  
  public void SetCurrentState(EstadoClimber state){
    this.currentState = state;
  }

  public double ValorEncoderClimber(){
    return MotorClimber.getEncoder().getPosition();
  }
}