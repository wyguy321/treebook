///////////////////////////////////////////////
//Wyatt Melin 10/18/12    Lab 5 
//
//This class is the cow class that has a price of 500 dollars to the user and has a cost of 5 dollars. 
//
//
//
//////////////////////////////////////////////
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class Cows extends Animals {
	static Timer CowsTimer;

public Cows(){
	MarketValue = 500;
	Costs = 5;
	Counter = 0; 
	AnimalName = "Cows";
}

public void setTimer()
{
	CowsTimer = new Timer();
	CowsTimer.scheduleAtFixedRate(new RemindTask(), 70 *1000, 70 *1000);
}
public void stopTimer(){
	//CowsTimer.cancel();
	System.out.println("Cow cancled.");
}
private static class RemindTask extends TimerTask{
	
	public void run()
	{
		System.out.println("Feed the cow!");
		JOptionPane.showMessageDialog(null, "Your cow is starting to get hungry and needs feeding.","Feed the cow please!", JOptionPane.PLAIN_MESSAGE);
	}
}

}