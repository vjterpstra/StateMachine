package org.gearticks6055.autonomous.components;

import org.gearticks6055.autonomous.AutonomousComponentBase;

public class Wait extends AutonomousComponentBase {
	private final int waitTime;//msec
	private long endTime;
	
	public Wait(int waitTime, String id) {
		super(id);
		this.waitTime = waitTime;
	}

	/**
	 * 
	 * @param waitTime - in milliseconds
	 */
	public Wait(int waitTime) {
		super();
		this.waitTime = waitTime;
	}

	@Override
	public void setup(int inputPort) {
		super.setup(inputPort);
		//reset startTime
		this.endTime = System.currentTimeMillis() + this.waitTime;
	}

	@Override
	public int run() {
		int transition = 0;
		super.run();
		
		if (System.currentTimeMillis() > this.endTime){
			transition = 1;
		}
		return transition;
	}

	@Override
	public void tearDown() {
		super.tearDown();
		this.endTime = 0;
	}
	
	
	

}
