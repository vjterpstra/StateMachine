package org.gearticks6055.autonomous.components;

import org.gearticks6055.autonomous.AutonomousComponentAbstractImpl;

public class GiroDrive extends AutonomousComponentAbstractImpl {
	private final int driveTime;//msec
	private final double heading;
	private long endTime;
	
	public GiroDrive(int driveTime, double heading, String id) {
		super(id);
		this.driveTime = driveTime;
		this.heading = heading;
	}

	/**
	 * @param driveTime - in milliseconds
	 */
	public GiroDrive(int driveTime, double heading) {
		super();
		this.driveTime = driveTime;
		this.heading = heading;
	}

	@Override
	public void setup(int inputPort) {
		super.setup(inputPort);
		//reset startTime
		this.endTime = System.currentTimeMillis() + this.driveTime;
	}

	@Override
	public int run() {
		int transition = 0;
		super.run();
		
		//control giro drive
		
		if (System.currentTimeMillis() > this.endTime){
			transition = 1;
		}
		return transition;
	}

	@Override
	public void tearDown() {
		super.tearDown();
		this.endTime = 0;
		//stop motors
	}
	
	
	

}
