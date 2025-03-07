package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;

public class NovoSistemaClimber {
    // Criação das variáveia utilizadas
    // Instanciação dos objetos dos motores
    // Intanciação dos objetos de configuração dos motores
    // Criação do método construtor
    // Criação de outros métodos

    SparkMax motorClimber = new SparkMax(Constants.ConstanteSistemaClimber.ClimberMotorsID, MotorType.kBrushless);
    SparkMaxConfig configuracaoMotor = new SparkMaxConfig();
    
    double valorY;
    double velocidade = 0;

    public NovoSistemaClimber(){
        configuracaoMotor
        .idleMode(IdleMode.kBrake)
        .smartCurrentLimit(60)
        .inverted(false);

        motorClimber.configure(configuracaoMotor, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    //Metodos
    //Método que envia o valor atual do meu encoder
    public double valorEncoder(){
        return motorClimber.getEncoder().getPosition();
    }

    // Criar um método que peça dois valores double:
    // Assim se torna possível passar como parametro os valores dos analogicos
    public void analogControl(double valorY){

        double velocidadeMotor = valorY * 0.2;
        this.velocidade = velocidadeMotor;
        motorClimber.set(velocidade);
        
        //DeadbandConfig
        if(velocidade < 0.05){
            this.velocidade = 0;
        }else{
            this.velocidade = velocidadeMotor;
        }
    }
}