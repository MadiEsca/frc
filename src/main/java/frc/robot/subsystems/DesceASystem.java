package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkClosedLoopController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.AlgaPosition;
import frc.robot.Constants.DesceAState;

public class DesceASystem extends SubsystemBase {
  public SparkMax DesceAMotor = new SparkMax(Constants.DesceAConstants.DesceAMotorsIDMotorsID, MotorType.kBrushless);
 
  SparkMaxConfig configSparkMotor = new SparkMaxConfig();

  public DesceAState currentState = DesceAState.STOPPED;
  public AlgaPosition currentPosition = AlgaPosition.REPOUSO;

  public DesceASystem() {
    configSparkMotor
      .inverted(true)
      .idleMode(IdleMode.kBrake);
  
      DesceAMotor.configure(configSparkMotor, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  } 

  @Override
  public void periodic() {
    if(currentState == DesceAState.DESCE ||/*operador "OU" ||*/ currentState == DesceAState.REDESCE ){
        DesceAMotor.set(currentState.speed);
    } else{
        DesceAMotor.set(0);
    }
  }

  public void SetCurrentState(DesceAState state){
    this.currentState = state;
  }

  public void SetCurrentPosition(AlgaPosition altura){
    this.currentPosition = altura;
  }
}