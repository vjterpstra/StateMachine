package org.gearticks6055.autonomous.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.gearticks6055.autonomous.component.AutonomousComponent;
import org.gearticks6055.autonomous.sample.components.GiroDrive;
import org.gearticks6055.autonomous.sample.components.Wait;
import org.gearticks6055.autonomous.statemachine.LinearStateMachine;

/**
 * This is a sample of a 'traditional' switch-based staging when using AutonomousComponents for some stages
 *
 */
public class SampleOpModeLinear extends OpModeTest {
	
	private LinearStateMachine sm;


	@Override
	public void initialize(){
		List<AutonomousComponent> components = new ArrayList<>();
		components.add(new Wait(2000, "Wait for 2 sec"));
		components.add(new GiroDrive(2000, 100, "Drive for 2 sec heading 100"));
		components.add(new Wait(2000, "Wait for 2 sec"));
		sm = new LinearStateMachine(components);
	}
	
	public void setup(){
		this.sm.setup(1);
	}
	
	public void loop(){
		
		this.sm.run();
		
	}
	
	
	public static void main(String[] args) {
		SampleOpModeLinear opMode = new SampleOpModeLinear();
		
		runOpMode(opMode, 10);
	}

}
