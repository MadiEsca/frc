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
import frc.robot.Constants.CoralState;

public class CoralScoreSystem extends SubsystemBase {
  public SparkMax coralMotor = new SparkMax(Constants.ScoreCoralConstants.coralMotorID, MotorType.kBrushed);
 
  SparkMaxConfig configSparkMotor = new SparkMaxConfig();

  public CoralState currentState = CoralState.STOPPED;

  public CoralScoreSystem() {
    configSparkMotor
      .inverted(true)
      .idleMode(IdleMode.kBrake);
  
    coralMotor.configure(configSparkMotor, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

  }

  @Override
  public void periodic() {
    if(currentState == CoralState.SHOOTING){
      coralMotor.set(currentState.speed);
    } else{
      coralMotor.set(-0.05);
    }
  }

  public void SetCurrentState(CoralState state){
    this.currentState = state;
  }
}
