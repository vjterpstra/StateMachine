package org.gearticks6055.autonomous.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.gearticks6055.autonomous.AutonomousComponent;
import org.gearticks6055.autonomous.components.GiroDrive;
import org.gearticks6055.autonomous.components.Wait;
import org.gearticks6055.autonomous.statemachine.InputPort;
import org.gearticks6055.autonomous.statemachine.LinearStateMachine;
import org.gearticks6055.autonomous.statemachine.OutputPort;
import org.gearticks6055.autonomous.statemachine.StateMachine;

/**
 * This is a sample of a state-machine with branching.
 * Need to use StateMachine with connections
 *
 */
public class SampleOpModeBranch extends OpModeTest {
	
	private StateMachine sm;


	@Override
	public void initialize(){
		this.sm = this.createSampleStateMachine();
	}
	
	/**
	 * Creates a StateMachine with a branch.
	 * Step 1: drive forward and stop
	 * Step 2: observe color, if red then Step 3-red, else Step3-blue
	 * Step 3-red: turn and drive to red
	 * Step3-blue: turn and drive to blue
	 * @return
	 */
	public StateMachine createSampleStateMachine(){
		StateMachine sm = new StateMachine(1,1);

		AutonomousComponent drive1 = new GiroDrive(2000, 100, "Drive for 2 sec heading 100");
		AutonomousComponent driveRed = new GiroDrive(3000, 0, "Drive for 3 sec left to red");
		AutonomousComponent driveBlue = new GiroDrive(3000, 180, "Drive for 3 sec right to blue");
		AutonomousComponent observeColor = new Wait(2000, "Wait for 2 sec");

		sm.addComponent(drive1);
		sm.addComponent(observeColor);
		sm.addComponent(driveRed);
		sm.addComponent(driveBlue);

		InputPort inputPort = sm.getInputPort(1);
		OutputPort outputPort1 = sm.getOutputPort(1);
		OutputPort outputPort2 = sm.getOutputPort(2);
		sm.addConnection(inputPort, 1, observeColor, 1);
		sm.addConnection(drive1, 1, drive1, 1);
		sm.addConnection(drive1, 1, observeColor, 1);
		sm.addConnection(observeColor, 1, driveRed, 1); //1 == red
		sm.addConnection(observeColor, 2, driveBlue, 1); //2 == blue
		sm.addConnection(driveRed, 1, outputPort1, 1);
		sm.addConnection(driveBlue, 1, outputPort2, 1);

		return sm;
	}
	
	public void setup(){
		this.sm.setup(1);
	}
	
	public void loop(){
		
		this.sm.run();
		
	}
	
	
	public static void main(String[] args) {
		SampleOpModeBranch opMode = new SampleOpModeBranch();
		
		runOpMode(opMode, 10);
	}

}
