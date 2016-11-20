package org.gearticks6055.autonomous.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.gearticks6055.autonomous.AutonomousComponent;
import org.gearticks6055.autonomous.LinearStateMachine;
import org.gearticks6055.autonomous.components.GiroDrive;
import org.gearticks6055.autonomous.components.Wait;

public class Sample1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<AutonomousComponent> components = new ArrayList<>();
		components.add(new Wait(2000, "Wait for 2 sec"));
		components.add(new GiroDrive(2000, 100, "Drive for 2 sec heading 100"));
		components.add(new Wait(2000, "Wait for 2 sec"));
		LinearStateMachine sm1 = new LinearStateMachine(components);
		
		System.out.println("Start");
		sm1.initialize();
		sm1.setup(1);
		long maxRunTime = 10000;// in milliseconds
		long endTime = System.currentTimeMillis() + maxRunTime;
		while (sm1.run() == 0){
			if (System.currentTimeMillis() > endTime){
				break;
			}
			try {
			    TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
			    //Handle exception
			}
		}
		sm1.tearDown();
		System.out.println("Done");
	}

}
