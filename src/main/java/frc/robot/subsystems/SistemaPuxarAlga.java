package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import frc.robot.Constants;

public class SistemaPuxarAlga {
    //Instaciar os motores

    //Instanciar os objetos de configuração dos motores

    //Instanciar os estados dos motores -> objetos enum
    //Criar uma lógica para definir os estados com base nos valores recebidos dos

    

    SparkMax motorPuxarAlga = new SparkMax(Constants.ConstanteSistemaPuxarAlga.SistemaPuxarAlgaID, MotorType.kBrushed);

    SparkMaxConfig configuracaoMotorPuxarAlga = new SparkMaxConfig();

    public SistemaPuxarAlga(){
        configuracaoMotorPuxarAlga.smartCurrentLimit(60).idleMode(IdleMode.kBrake);
    }

    public void setMecanismState(double estado){

    }
    
}