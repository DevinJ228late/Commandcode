// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  SparkMax r_motor1; //creating motor
  SparkMax r_motor2;
  SparkMax l_motor1;
  SparkMax l_motor2;

  SparkMax pivot_motor;

  SparkMaxConfig follow_config1;
  SparkMaxConfig follow_config2;
  SparkMaxConfig motor_config;

double x;
double y;


  public Drivetrain() {

    r_motor1 = new SparkMax(Constants.r_motor1_id, MotorType.kBrushless); //initializing motor (use CAN ID 1)
    r_motor2 = new SparkMax(Constants.r_motor2_id, MotorType.kBrushless);
    l_motor1 = new SparkMax(Constants.l_motor1_id, MotorType.kBrushless);
    l_motor2 = new SparkMax(Constants.l_motor2_id, MotorType.kBrushless);
    pivot_motor = new SparkMax(Constants.pivot_motor_id, MotorType.kBrushless);

    follow_config1 = new SparkMaxConfig(); //initializing configs
    follow_config2 = new SparkMaxConfig();
    motor_config = new SparkMaxConfig();

    follow_config1
    .inverted(false)
    .follow(1) //setting motor to follow
    .idleMode(IdleMode.kBrake);

    follow_config2
    .inverted(false)
    .follow(3)
    .idleMode(IdleMode.kBrake);

    motor_config
    .inverted(false)
    .idleMode(IdleMode.kBrake);

    this.r_motor1.configure(motor_config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters); //applying config to motor

    this.r_motor2.configure(follow_config1, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    this.l_motor1.configure(motor_config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    this.l_motor2.configure(follow_config2, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

  }

  public void arcade(Joystick r_joystick, Joystick l_joystick) {
    
  x = r_joystick.getX();
  y = l_joystick.getY();

  r_motor1.set(y - x);
  l_motor1.set(y + x);






  }






  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
