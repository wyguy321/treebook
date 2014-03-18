///////////////////////////////////////////////
//Wyatt Melin 10/18/12    Lab 5 
//
//This class is the parent class of all the animals. 
//
//
//
//////////////////////////////////////////////


import java.util.Timer;
import java.util.TimerTask;

public class Animals  {
protected double MarketValue;
protected double Costs;
protected int Counter;
protected String AnimalName;
static Timer AnimalTimer;

protected Animals (){
	MarketValue = 0;
	Costs = 0;
	Counter = 0;
	AnimalName = "";
	
}

public void setTimer() {
	// TODO Auto-generated method stub
	
}

public void stopTimer(){
	
}

public int compareCost(Animals a) {
	// TODO Auto-generated method stub
	
	
	return (int) (this.Costs - a.Costs);
}
public int compareName(Animals a){
	
	
	
	return this.AnimalName.compareTo(a.AnimalName);
	
}

public int compareValue(Animals a) {
	// TODO Auto-generated method stub
	
	
	return (int) (this.MarketValue - a.MarketValue);
}

public String toString(){
	String AnimalInformation;
	return AnimalInformation = AnimalName+",";
}




}
