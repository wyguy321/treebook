///////////////////////////////////////////////
//Wyatt Melin 10/18/12    Lab 5 
//
//This class is the corn class that has a market value of 25 and a cost of 5 dollars.
//
//
//
//////////////////////////////////////////////
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;




public class Corn extends Crops {
	static Timer cornTimer; 
	
	public Corn (){
		MarketValue = 25;
		Cost = 5;
		Counter = 0;
		CropName = "Corn";
		
	}
	public void setTimer()
	{
		cornTimer = new Timer();
		cornTimer.scheduleAtFixedRate(new RemindTask(),  120 * 1000, 120 * 1000);
		
	}
	public void stopTimer(){
		cornTimer.cancel();
	}
	private static class RemindTask extends TimerTask{
		
		public void run()
		{
			JOptionPane.showMessageDialog(null, "Your corn is done growing.",
							"Corn Done Growing", JOptionPane.PLAIN_MESSAGE);
		}
	}
}
