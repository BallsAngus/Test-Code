// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveTrain;

/** Add your docs here. */
public class RobotContainer {
    // Drivetrain subsystem.
    private final DriveTrain robotDrive = new DriveTrain();
    private final AutoDrive autoDrive;
    private final Joystick stick = new Joystick(0);

    public RobotContainer() {
        robotDrive.setDefaultCommand(
            new DriveCommand(
                robotDrive, 
                () -> stick.getX(), 
                () -> stick.getY(),
                () -> stick.getRawAxis(3)
        ));
        autoDrive = new AutoDrive(robotDrive);
    }

    public Command getAutonomousCommand() {
        return autoDrive;
    }
}
