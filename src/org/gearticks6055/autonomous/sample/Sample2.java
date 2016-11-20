package org.gearticks6055.autonomous.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.gearticks6055.autonomous.AutonomousComponent;
import org.gearticks6055.autonomous.LinearStateMachine;
import org.gearticks6055.autonomous.components.GiroDrive;
import org.gearticks6055.autonomous.components.Wait;

public class Sample2 {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		OpModeTest opMode = new SampleOpMode2();
		
		opMode.initialize();
		
		opMode.setup();
		
		System.out.println("Start");
		long maxRunTime = 10000;// in milliseconds
		long endTime = System.currentTimeMillis() + maxRunTime;
		while (true){
			opMode.loop();
			
			if (System.currentTimeMillis() > endTime){
				break;
			}
			try {
			    TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
			    //Handle exception
			}
		}
		opMode.tearDown();
		System.out.println("Done");
	}
	
//	private static void nextStage() {
//		this.stage = Stage.values()[this.stage.ordinal() + 1];
//		this.stageTimer.reset();
//	}

}
