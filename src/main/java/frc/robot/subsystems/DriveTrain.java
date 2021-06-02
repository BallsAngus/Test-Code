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
    private final CANSparkMax rearLeft = new CANSparkMax(1, MotorType.kBrushed);
    private final CANSparkMax frontLeft = new CANSparkMax(2, MotorType.kBrushed);
    private final CANSparkMax rearRight = new CANSparkMax(3, MotorType.kBrushed);
    private final CANSparkMax frontRight = new CANSparkMax(4, MotorType.kBrushed);
    private final SpeedControllerGroup left = new SpeedControllerGroup(rearLeft, frontLeft);
    private final SpeedControllerGroup right = new SpeedControllerGroup(rearRight, frontRight);
    private final DifferentialDrive drive = new DifferentialDrive(left, right);

    public DriveTrain() {

    }

    public void arcadeDrive(double speed, double rotation) {
        drive.arcadeDrive(speed, rotation);
    }
}
