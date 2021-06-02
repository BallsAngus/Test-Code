// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveTrain;

/** Add your docs here. */
public class RobotContainer {
    // Drivetrain subsystem.
    private final DriveTrain robotDrive = new DriveTrain();
    private final Joystick stick = new Joystick(0);

    public RobotContainer() {
        robotDrive.setDefaultCommand(
            new DriveCommand(
                robotDrive, 
                () -> stick.getX(), 
                () -> stick.getY(),
                () -> stick.getRawAxis(3)
        ));
    }
}
