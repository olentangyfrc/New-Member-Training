// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.spinnywheel;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class SpinnyWheel extends SubsystemBase {
  public static final double MAX_WHEEL_SPEED = 1;

  private WPI_TalonFX wheel;

  private double targetWheelSpeed = 0;

  /** Creates a new SpinnyWheel. */
  public SpinnyWheel() {}

  /**
   * Initialize the spinny wheel subsystem
   */
  public void init() {
    wheel = new WPI_TalonFX(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    wheel.set(ControlMode.PercentOutput, targetWheelSpeed);
  }

  /**
   * Set the target speed for the spinny wheel
   * 
   * @param speed The speed to set, as a percentage of max speed. This should be in the interval [-1, 1]
   */
  public void setTargetWheelSpeed(double speed) {
    // Restrict the speed to the range of [-MAX_WHEEL_SPEED, MAX_WHEEL_SPEED]
    // Clamping a value is the equivalent of calling Math.max(low, Math.min(value, high))
    speed = MathUtil.clamp(speed, -MAX_WHEEL_SPEED, MAX_WHEEL_SPEED);
    targetWheelSpeed = speed;
  }

  /**
   * @return The target speed of the spinny wheel
   */
  public double getTargetWheelSpeed() {
    return targetWheelSpeed;
  }

  /**
   * Stop the spinny wheel
   */
  public void stopWheel() {
    targetWheelSpeed = 0;
  }
}
