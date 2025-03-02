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
import frc.robot.Constants.ClimberGState;

public class ClimberGSystem extends SubsystemBase {
  public SparkMax ClimberGMotor = new SparkMax(Constants.ClimberGConstants.ClimberMotorsID, MotorType.kBrushless);
 
  SparkMaxConfig configSparkMotor = new SparkMaxConfig();

  public ClimberGState currentState = ClimberGState.STOPPED;

  public ClimberGSystem() {
    configSparkMotor
      .inverted(true)
      .idleMode(IdleMode.kBrake);
  
    ClimberGMotor.configure(configSparkMotor, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

  }

  @Override
  public void periodic() {
    if(currentState == ClimberGState.CLIMBING || currentState == ClimberGState.RECLIMBING ){
      ClimberGMotor.set(currentState.speed);
    } else{
      ClimberGMotor.set(0);
    }
  }

  public void SetCurrentState(ClimberGState state){
    this.currentState = state;
  }
}