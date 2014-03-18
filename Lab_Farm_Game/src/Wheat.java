///////////////////////////////////////////////
//Wyatt Melin 10/18/12    Lab 5 
//
//This is the wheat class that is a child of the crop class that has a market value of 10 dollars and a cost of 75 dollars to the user. 
//
//
//
//////////////////////////////////////////////

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class Wheat extends Crops {
	
	static Timer WheatTimer;



public Wheat(){
	MarketValue = 10; 
	Cost = 75; 
	Counter = 0;
	CropName = "Wheat";
}
public void setTimer()
{
	WheatTimer = new Timer();
	WheatTimer.scheduleAtFixedRate(new RemindTask(), 300 * 1000, 300 * 1000);
}
public void stopTimer(){
	WheatTimer.cancel();
}
private static class RemindTask extends TimerTask{
	
	public void run()
	{
		JOptionPane.showMessageDialog(null, "Your wheat is done growing.",
				"Wheat Finshed Growing", JOptionPane.PLAIN_MESSAGE);
	}
}

}