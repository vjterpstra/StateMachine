package org.gearticks6055.autonomous.statemachine;

import org.gearticks6055.autonomous.component.AutonomousComponentAbstractImpl;

/**
 * Represents a in- or output port for use in a StateMachine
 *
 */
public class AutonomousComponentPort extends AutonomousComponentAbstractImpl {
	private final int portNumber;
	private final boolean isInput;
	
	public AutonomousComponentPort(int portNumber, boolean isInput) {
		super();
		this.portNumber = portNumber;
		this.isInput = isInput;
	}

	
	@Override
	public int run() {
		int transition = 0;
		super.run();
		
		if (this.isInput){
			transition  = 1;
		}
		else {
			transition = 0;
		}
		return transition;
	}


	public int getPortNumber() {
		return portNumber;
	}
	
	
	

}
