package frc.robot;

//Classes onde armazenamos os valores constantes que serão utilizados ao longo do código.

//Superclasse:
//Final é utilizado tornar os valores abaixo inalteráveis por outras partes do código
public final class Constants {
  //Subclasses:
  //Static é utilizado para mostrar que esses valores são estáticos
  public static class DriveTrainConstants {
    public static int rightFrontMotorID = 13;
    public static int rightBackMotorID = 3;
    public static int leftFrontMotorID = 12;
    public static int leftBackMotorID = 11;
  }

  public static class ControlsJoystick {
    public static int leftMotors = 1;
    public static int rightMotors = 5;
  }
  
  public static class ScoreCoralConstants {
    public static int coralMotorID = 2;
  }

  public static enum CoralState { 
    STOPPED(0), SHOOTING(-0.29);
    public final double speed;
    
    private CoralState(double shooty){
      this.speed = shooty;
    }
  }

  public static class ClimberGConstants {

      public static int ClimberMotorsID = 6;  

    } 
    public static enum ClimberGState {
      STOPPED(0), CLIMBING(0.20), RECLIMBING(-0.20);
      public final double speed;
      
      private ClimberGState(double speed){
        this.speed = speed;
      }
    }

    public static class DesceAConstants {

      public static final String MotorType = null;
      public static int DesceAMotorsIDMotorsID = 9;  

    } 
    public static enum DesceAState {
      STOPPED(0), DESCE(0.20), REDESCE(-0.20);
      public final double speed;
      
      private DesceAState(double speed){
        this.speed = speed;
      }
    }

  public static enum DriveTrainState {
    STOPPED(0), MID(0.7), FULL(1);
    public final double velocity;
    
    private DriveTrainState(double velocity){
      this.velocity = velocity;
    }
  }

}