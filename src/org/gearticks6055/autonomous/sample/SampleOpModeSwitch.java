package org.gearticks6055.autonomous.sample;

import org.gearticks6055.autonomous.component.AutonomousComponent;
import org.gearticks6055.autonomous.sample.components.GiroDrive;
import org.gearticks6055.autonomous.sample.components.Wait;

/**
 * This is a sample of a 'traditional' switch-based staging when using AutonomousComponents for some stages
 *
 */
public class SampleOpModeSwitch extends OpModeTest {
	
	private enum Stage{
		WAIT1 (new Wait(2000, "Wait for 2 sec")),
		DRIVE1 (new GiroDrive(2000, 100, "Drive for 2 sec heading 100")),
		DRIVE2 (null),
		WAIT2 (new Wait(2000, "Wait for 2 sec"));
		
		private AutonomousComponent component;

		private Stage(AutonomousComponent ac) {
			this.component = ac;
		}
		public AutonomousComponent getComponent(){
			return this.component;
		}
	}
	
	private Stage stage;


	@Override
	public void initialize(){
		for (Stage stage : Stage.values()){
			stage.getComponent().initialize();
		}
	}
	
	public void setup(){
		this.stage = Stage.WAIT1;
		this.stage.getComponent().setup(1);
	}
	
	public void loop(){
		
		switch (this.stage) {
		case WAIT1:
			if (this.stage.getComponent().run() > 0){
				this.nextStage();
			}
			break;
		case DRIVE1:
			if (this.stage.getComponent().run() > 0){
				this.nextStage();
			}
			break;
		case DRIVE2:
			/*
			 * Not necessary to always use an AutonomousComponent
			 */
			if (true){
				this.nextStage();
			}
			break;
		case WAIT2:
			if (this.stage.getComponent().run() > 0){
				//stop?
			}
			break;
		default:
			break;
		}
		
	}
	
	private void nextStage() {
		//tearDown current stage
		if (this.stage.getComponent() !=  null){
			this.stage.getComponent().tearDown();
		}
		//move to next stage
		this.stage = Stage.values()[this.stage.ordinal() + 1];
		//setup next stage
		if (this.stage.getComponent() != null){
			this.stage.getComponent().setup(1);
		}
	}
	
	public static void main(String[] args) {
		SampleOpModeSwitch opMode = new SampleOpModeSwitch();
		
		runOpMode(opMode, 10);
	}

}
