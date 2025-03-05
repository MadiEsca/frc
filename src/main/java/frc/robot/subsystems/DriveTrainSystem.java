package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.ctre.phoenix6.hardware.Pigeon2;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkClosedLoopController;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.CoralState;
import frc.robot.Constants.DriveTrainState;

public class DriveTrainSystem extends SubsystemBase {
  public DriveTrainState currentState = DriveTrainState.STOPPED;

  SparkMax rightMotorFront = new SparkMax(Constants.DriveTrainConstants.rightFrontMotorID, MotorType.kBrushed);
  SparkMax rightMotorBack = new SparkMax(Constants.DriveTrainConstants.rightBackMotorID, MotorType.kBrushed);
  SparkMax leftMotorBack = new SparkMax(Constants.DriveTrainConstants.leftBackMotorID, MotorType.kBrushed);
  SparkMax leftMotorFront = new SparkMax(Constants.DriveTrainConstants.leftFrontMotorID, MotorType.kBrushed);

  SparkMaxConfig configSparkRight = new SparkMaxConfig();
  SparkMaxConfig configSparkLeft = new SparkMaxConfig();

  MotorControllerGroup leftMotorControllerGroup = new MotorControllerGroup(leftMotorFront, leftMotorBack);
  MotorControllerGroup rightMotorControllerGroup = new MotorControllerGroup(rightMotorFront, rightMotorBack);

  DifferentialDrive differentialDrive = new DifferentialDrive(leftMotorControllerGroup, rightMotorControllerGroup);

  public DriveTrainSystem() {

    configSparkRight
      .inverted(true)
      .idleMode(IdleMode.kBrake);

    configSparkLeft
      .inverted(false)
      .idleMode(IdleMode.kBrake);

    configSparkRight.smartCurrentLimit(60);
    configSparkLeft.smartCurrentLimit(60);
  
    rightMotorFront.configure(configSparkRight, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    rightMotorBack.configure(configSparkRight, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    leftMotorFront.configure(configSparkLeft, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    leftMotorBack.configure(configSparkLeft, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  @Override
  public void periodic() {
   
  }

  public void arcadeMode(double drive, double turn){
    differentialDrive.arcadeDrive(drive, turn);
  }

  public void tankmode(double left, double right){
    differentialDrive.tankDrive(left, right);
  }
  public void stop(){
    differentialDrive.stopMotor(); 
  }

  public void SetCurrentState(DriveTrainState state){
    this.currentState = state;
  } 
}