// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveCommand extends CommandBase {

  public DriveTrain driveTrain;
  public DoubleSupplier speed;
  public DoubleSupplier rotation;
  public DoubleSupplier modifier;
  /** Creates a new DriveCommand. */
  public DriveCommand(DriveTrain subsystem, DoubleSupplier speed, DoubleSupplier rotation, DoubleSupplier modifier) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = subsystem;
    this.speed = speed;
    this.rotation = rotation;
    this.modifier = modifier;
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.arcadeDrive(0.0, 0.0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.arcadeDrive(speed.getAsDouble() * modifier.getAsDouble(), rotation.getAsDouble() * modifier.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
