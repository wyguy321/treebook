///////////////////////////////////////////////
//Wyatt Melin 10/18/12    Lab 5 
//
//This class is a Alfalfa plant that is part  
//
//
//
//////////////////////////////////////////////

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;




public class Alfalfa extends Crops {
	
	private static Timer Alfalfatimer; 

public Alfalfa(){
	MarketValue = 5;
	Cost = 2;
	Counter = 0;
	CropName = "Alfalfa";
	
}
public static void setTimer(int seconds)
{
	Alfalfatimer = new Timer();
	Alfalfatimer.scheduleAtFixedRate(new RemindTask(), 30 * 1000, 30 * 1000);
}
public void stopTimer(){
	Alfalfatimer.cancel();
}
private static class RemindTask extends TimerTask{
	
	public void run()
	{
		JOptionPane.showMessageDialog(null, "Your Alfalfa is done growing.",
						"Alfalfa Done Growing", JOptionPane.PLAIN_MESSAGE);
	}
}
}