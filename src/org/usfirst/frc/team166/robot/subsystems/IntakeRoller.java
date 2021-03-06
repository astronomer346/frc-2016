package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team166.robot.RobotMap;

/**
 *
 */
public class IntakeRoller extends Subsystem {
	static final double TicksPerRotation = 1024.0;
	Victor motor;
	AnalogInput intakeSensor;

	public IntakeRoller() {
		motor = new Victor(RobotMap.Pwm.RollerVictor);
		intakeSensor = new AnalogInput(RobotMap.Analog.IntakeSensor);

	}

	public void startRoller() {
		motor.set(Preferences.getInstance().getDouble("RollerForward", .4));
	}

	public void stopRoller() {
		motor.stopMotor();
	}

	public boolean isBallLoaded() {
		return (intakeSensor.getVoltage() >= 1.0);

	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
