package org.gearticks6055.autonomous;

public class StateMachineConnection {
	private final AutonomousComponent originComponent;
	private final int originPortNumber;
	private final AutonomousComponent destinationComponent;
	private final int destinationPortNumber;
	
	public StateMachineConnection(AutonomousComponent originComponent,
			int originPortNumber, AutonomousComponent destinationComponent,
			int destinationPortNumber) {
		super();
		this.originComponent = originComponent;
		this.originPortNumber = originPortNumber;
		this.destinationComponent = destinationComponent;
		this.destinationPortNumber = destinationPortNumber;
	}

	public AutonomousComponent getOriginComponent() {
		return originComponent;
	}

	public int getOriginPortNumber() {
		return originPortNumber;
	}

	public AutonomousComponent getDestinationComponent() {
		return destinationComponent;
	}

	public int getDestinationPortNumber() {
		return destinationPortNumber;
	}
	
	

}
