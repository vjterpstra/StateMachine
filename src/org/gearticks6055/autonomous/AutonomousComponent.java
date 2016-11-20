package org.gearticks6055.autonomous;

import java.util.logging.Logger;

/**
 * Autonomous component has input and output 'ports', with numbers starting at 1
 * 
 * @author vterpstra
 *
 */
public interface AutonomousComponent {
	/**
	 * To be called once at start of autonomous program, e.g. to initialize some sensors
	 */
	public void initialize();
	
	
	/**
	 * Called each time the component state starts, can be multiple times in same autonomous program
	 * @param inputPort - The port through which this component/state is entered
	 */
	public void setup(int inputPort);
	
	/**
	 * To be called in each loop cycle
	 * @return 'outputPort', 0 means not ready
	 */
	public int run();
	
	/**
	 * Called each time the component state ends
	 */
	public void tearDown();
	
	public Logger getLogger();

}
