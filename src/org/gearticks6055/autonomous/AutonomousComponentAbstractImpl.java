package org.gearticks6055.autonomous;

import java.util.logging.Logger;

public abstract class AutonomousComponentAbstractImpl implements
		AutonomousComponent {
	
	private final String id;
	
	public AutonomousComponentAbstractImpl() {
		super();
		this.id = this.getClass().getSimpleName();
	}

	public AutonomousComponentAbstractImpl(String id) {
		super();
		this.id = id;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setup(int inputPort) {
		// TODO Auto-generated method stub

	}

	@Override
	public int run() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void tearDown() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString(){
		return this.id;
	}
	
	@Override
	public Logger getLogger(){
		return Logger.getLogger(this.getClass().getSimpleName());
	}

}
