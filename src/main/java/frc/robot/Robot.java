// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
 
WPI_VictorSPX motord1 = new WPI_VictorSPX(1);
  WPI_VictorSPX motord2 = new WPI_VictorSPX(2);
  WPI_VictorSPX motori1 = new WPI_VictorSPX(3);
 WPI_VictorSPX motori2 = new WPI_VictorSPX(4);
 
 MotorControllerGroup motoresd = new MotorControllerGroup(motord1, motord2);
 MotorControllerGroup motoresi = new MotorControllerGroup(motori1, motori2);

 DifferentialDrive chasis = new DifferentialDrive(motoresd, motoresi);
 
  CANSparkMax motor1 = new CANSparkMax(16, CANSparkMaxLowLevel.MotorType.kBrushless);
 CANSparkMax motor2 = new CANSparkMax(22, CANSparkMaxLowLevel.MotorType.kBrushless);
 CANSparkMax motorsg = new CANSparkMax(18, CANSparkMaxLowLevel.MotorType.kBrushless);
 
 

 Joystick control = new Joystick(0);
 
 WPI_TalonSRX garra1 = new WPI_TalonSRX(5);
 
 DifferentialDrive brazo = new DifferentialDrive(motor2, motor1);
 
 

  
 

  @Override
  public void robotInit() {
 
motor2.setInverted(true);
 

  }

  @Override
  public void robotPeriodic() {
    

  }

  @Override
  public void autonomousInit() {
    
    
    
  }
  
  @Override
  public void autonomousPeriodic() {
   
      
      
  
  
  
  
    }

  

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {

chasis.arcadeDrive(control.getRawAxis(0)*.8, control.getRawAxis(1)*.8);




  if(control.getRawButton(5)){
  motorsg.set(  .2);

} else if (control.getRawButton(6)){
  motorsg.set(-.2);
  
} else{
  motorsg.stopMotor();
} 
 
if(control.getRawButton(1)){



  garra1.set(.65);
}else if(control.getRawButton(2)){
  garra1.set(-.65);
}else{
  garra1.stopMotor();
}


brazo.arcadeDrive(control.getRawAxis(5)*.8, kDefaultPeriod);


  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
