import java.util.Timer;
import java.util.TimerTask;

public class Crops {

	protected double MarketValue;
	protected double Cost;
	protected int Counter;
	static Timer CropTimer;
	String CropName;
	
	protected Crops(){
		MarketValue = 0;
		Cost = 0;
		CropName = "";
	}
	
	
	public void setTimer() {
		// TODO Auto-generated method stub
		
	}
	public void stopTimer(){
		
	}
	
	public int compareName(Crops a){
		
		
		return this.CropName.compareTo(a.CropName);
		
	}
	public int compareCost(Crops a) {
		// TODO Auto-generated method stub
		
		
		return (int) (this.Cost - a.Cost);
	}
	public int compareValue(Crops a) {
		// TODO Auto-generated method stub
		
		
		return (int) (this.MarketValue - a.MarketValue);
	}
	
	public String toString(){
		String CropsInformation;
		return CropsInformation = CropName+",";
	}
}
