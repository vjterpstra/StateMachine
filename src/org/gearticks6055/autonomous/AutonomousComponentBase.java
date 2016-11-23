package org.gearticks6055.autonomous;

import java.util.logging.Logger;

/**
 * Adds:
 * * Timer (TODO)
 * * getLogger()
 *
 */
public class AutonomousComponentBase extends AutonomousComponentAbstractImpl {

	public AutonomousComponentBase() {
		super();
	}

	public AutonomousComponentBase(String id) {
		super(id);
	}
	
	public Logger getLogger(){
		return Logger.getLogger(this.getClass().getSimpleName());
	}
	
}
