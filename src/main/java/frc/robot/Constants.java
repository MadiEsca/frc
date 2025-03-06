package frc.robot;

import java.security.PublicKey;

public final class Constants {
  public static class ConstantesTracao {
    public static int IDmotorDireitaFrente = 13;
    public static int IDmotorDiretaTras = 3;
    public static int IDmotorEsquerdaFrente = 12;
    public static int IDmotorEsquerdaTras = 11;
  } 

  public static class JoysticsDeControle {
    //ID dos axes
    //Semelhante ao LabVIEW
    public static int controlarEsquerda = 1;//Analógico Esquerdo(X)
    public static int motoresDireita = 5;//Analógigo direito(Y)
  }
  
  public static class ConstanteSistemaCoral {
    public static int MotorCoralID = 2;
  }

  public static class ConstanteSistemaClimber {
    public static int ClimberMotorsID = 6;
  }
  
  public static class ConstantesSistemaDescerAlga {
    public static int DesceAMotorsIDMotorsID = 9;  
    }
  
  public static class ConstanteSistemaPuxarAlga {
    public static int SistemaPuxarAlgaID = 99;
  }
    
  //Métodos enums -> Estados dos mecanismos
  public static enum EstadoClimber {
    PARADO(0), CLIMBING(0.20), RECLIMBING(-0.20);
    public final double velocidade;
    
    private EstadoClimber(double velocidade){
      this.velocidade = velocidade;
    }
  }

  public static enum EstadoCoral {
    PARADO(0), ATIVADO(-0.29);
    public final double velocidade;
    
    private EstadoCoral(double velocidade){
      this.velocidade = velocidade;
    }
  }

  public static enum DescerAlgaEstado {
    PARADO(0), DESCE(0.20), SOBE(-0.20);
    public final double velocidade;
    
    private DescerAlgaEstado(double velocidade){
      this.velocidade = velocidade;
    }
  }

  public static enum PuxarAlgaEstado{
    //Positivo Puxa
    //Negativo Solta
    PUXA(0.5), SOLTA(-0.5);
    public final double velocidade;

    private PuxarAlgaEstado(double velocidade){
      this.velocidade = velocidade;
    }
  }

  public static enum EstadoTracao {
    PARADO(0), MID(0.7), FULL(1);
    public final double velocidade;
    
    private EstadoTracao(double velocidade){
      this.velocidade = velocidade;
    }
  }
}