///////////////////////////////////////////////
//Wyatt Melin 	10/18/12   Lab 5 
//
//This is the goat class of that is a parent of the animal class. It will have methods that implement a timer class for when it needs to be feed  
//
//
//
//////////////////////////////////////////////
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class Goats extends Animals {
	static Timer GoatTimer;



public Goats(){
	MarketValue = 25; 
	Costs = 10;
	Counter = 0;
	AnimalName = "Goats";
}
public void setTimer()
{
	GoatTimer = new Timer();
	GoatTimer.scheduleAtFixedRate(new RemindTask(), 30 *1000, 30 *1000);
}
public void stopTimer(){
	GoatTimer.cancel();
}
private static class RemindTask extends TimerTask{
	
	public void run()
	{
		
		JOptionPane.showMessageDialog(null, "Your goat is starting to get hungry and needs feeding.","Feed the goat please!", JOptionPane.PLAIN_MESSAGE);
		//timer.cancel();
	}
}

}