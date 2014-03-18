///////////////////////////////////////////////
//Wyatt Melin 10/18/12    Lab 5 
//
//This class implements the Horses of the animal class that will have a method to implement the timer class to determine when it needs to be feed. 
//
//
//
//////////////////////////////////////////////

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;



public class Horses extends Animals{
static Timer HorsesTimer;




public Horses(){
	MarketValue = 1000;
	Costs = 100;
	Counter = 0; 
	AnimalName = "Horses"; 
	
	
}
public void setTimer()
{
	HorsesTimer = new Timer();
	HorsesTimer.scheduleAtFixedRate(new RemindTask(), 90 *1000, 90*1000);
}
public void stopTimer(){
	HorsesTimer.cancel();
}
private static class RemindTask extends TimerTask{
	
	public void run()
	{
		
		JOptionPane.showMessageDialog(null, "Your Horse is starting to get hungry and needs feeding.","Feed the Horse please!", JOptionPane.PLAIN_MESSAGE);
		//timer.cancel();
	}
}
}
