// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** Add your docs here. */
public class DriveTrain extends SubsystemBase {
    private final CANSparkMax rearLeft;
    private final CANSparkMax frontLeft;
    private final CANSparkMax rearRight;
    private final CANSparkMax frontRight;
    private final SpeedControllerGroup left;
    private final SpeedControllerGroup right;
    private final DifferentialDrive drive;

    // Constructor, initialize motor controllers and groups.
    public DriveTrain() {
        rearLeft = new CANSparkMax(1, MotorType.kBrushed); rearLeft.setInverted(false);
        frontLeft = new CANSparkMax(2, MotorType.kBrushed); frontLeft.setInverted(false);
        rearRight = new CANSparkMax(3, MotorType.kBrushed); rearRight.setInverted(false);
        frontRight = new CANSparkMax(4, MotorType.kBrushed); frontRight.setInverted(false);
        left = new SpeedControllerGroup(rearLeft, rearLeft);
        right = new SpeedControllerGroup(rearRight, rearRight);
        drive = new DifferentialDrive(left, right);
    }

    // Basic single joystick drive configuration
    public void arcadeDrive(double speed, double rotation) {
        drive.arcadeDrive(speed, rotation);
    }

    // Drive forwards
    public void driveForward(double speed) {
        drive.arcadeDrive(speed, 0.0);
    }

    public void stopMotors() {
        left.set(0.0);
        right.set(0.0);
    }
}
