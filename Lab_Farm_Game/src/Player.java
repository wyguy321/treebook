import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;



///////////////////////////////////////////////
//Wyatt Melin 10/18/12    Lab 5 
//
//This is the Player class. The Player class has a bank account of 40 dollars for the player to start off with just growing food and moving on from there. 
//
//
//
//////////////////////////////////////////////
public class Player {
	double PlayerBank;
	int ObjectCounter;
	int AnimalCounter; 
	int CropCounter;
	static Timer PredatorTimer;
	private ArrayList<Animals> liveStock = new ArrayList <Animals>();
	private ArrayList<Crops> liveCrops = new ArrayList<Crops>();

	Crops crop = new Crops();
	public Player(){
		PlayerBank = 40;
		ObjectCounter = 0;
		AnimalCounter = 0;
		CropCounter = 0;



	}

	public double getPlayerBank(){
		return PlayerBank;
		
	}



	public void setTimer(int seconds)
	{
		PredatorTimer = new Timer();
		PredatorTimer.scheduleAtFixedRate(new RemindTask(), seconds *1000, seconds*1000);
	}

	private class RemindTask extends TimerTask{

		public void run()
		{
			System.out.println("Test");
			killAnimals();
			killCrops();
			//timer.cancel();
		}

	}
	public ArrayList<Animals> getLiveStock(){
		return liveStock;
	}
	public ArrayList<Crops> getliveCrops(){
		return liveCrops;
	}

	public void addAnimal(Animals a){



		if(PlayerBank<=0){
			JOptionPane.showMessageDialog(
					null, "You're broke! Try selling an anmial to get some cash.",
					"C'mon dude!",
					JOptionPane.ERROR_MESSAGE);
		}else{
			liveStock.add(a);
			a.setTimer();

			PlayerBank -= a.Costs;

			System.out.println("Bought: " + PlayerBank);
		}
	}
	public void sellAnimal(Animals b){
		boolean AnimalExist = false;

		int counter = 0;
		//Checks to see if animal exists 
		for(int i=0; i<liveStock.size(); i++){
			if(liveStock.get(i) != null){
				if(liveStock.get(i).getClass() == b.getClass()){
					AnimalExist = true;
					counter = i;
				}
			}
		}

		if (!AnimalExist){

			JOptionPane.showMessageDialog(
					null, "No such crop exsits! You have to buy an crop to sell one first!",
					"No crop has been bought before!",
					JOptionPane.ERROR_MESSAGE);
		}else{
			//liveStock.get(counter).stopTimer();
			liveStock.remove(counter);
			PlayerBank+= b.MarketValue;
			CropCounter--;
			System.out.println("Sold: " + b.MarketValue);
		}


	}
	public void killAnimals(){
		boolean Kill = false;
		int killCounter = 0;

		for (int i = 0; i < liveStock.size(); i++){
			if(liveStock.get(i) != null){
				Kill = true;
				killCounter = i;

			}

		}
		if (!Kill){
			JOptionPane.showMessageDialog(
					null, "You're lucky, the wolf was not hungry for any animals",
					"Wow you were pretty close!",
					JOptionPane.ERROR_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(
					null, "A wolf came over and ate one of your animals!",
					"No!",
					JOptionPane.ERROR_MESSAGE);

			liveStock.remove(killCounter);
			AnimalCounter--;
		}

	}

	public void addCrops(Crops a){

		if(PlayerBank<=0){
			JOptionPane.showMessageDialog(
					null, "You're broke! Try selling an anmial to get some cash.",
					"C'mon dude!",
					JOptionPane.ERROR_MESSAGE);
		}else{
			liveCrops.add(a);
			a.setTimer();

			CropCounter++;
			PlayerBank -= a.Cost;
			System.out.println("Bought: " + a.Cost);
		}

	}
	public void sellCrops(Crops b){
		int counter = 0;
		boolean CropsExists = false;
		for(int i=0; i<liveCrops.size(); i++){
			if(liveCrops.get(i) != null){
				if(liveCrops.get(i).getClass() == b.getClass()){
					CropsExists = true;
					counter = i;
				}
			}
		}

		if (!CropsExists){

			JOptionPane.showMessageDialog(
					null, "No such crop exsits! You have to buy an crop to sell one first!",
					"No crop has been bought before!",
					JOptionPane.ERROR_MESSAGE);
		}else{
			liveCrops.get(counter).stopTimer();
			liveCrops.remove(counter); 
			PlayerBank+= b.MarketValue;
			CropCounter--;
			System.out.println("Sold: " + b.MarketValue);
		}


	}
	public  void killCrops(){
		boolean Kill = false;
		int killCounter = 0;

		for (int i = 0; i < liveCrops.size(); i++){
			if(liveCrops.get(i) != null){
				Kill = true;
				killCounter = i;

			}

		}
		if (!Kill){
			JOptionPane.showMessageDialog(
					null, "You're lucky, the wolf was not in the mood for any crops",
					"Wow you were pretty close!",
					JOptionPane.ERROR_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(
					null, "A wolf came over and ate one of your crops!",
					"No!",
					JOptionPane.ERROR_MESSAGE);

			liveCrops.remove(killCounter);
			CropCounter--;
		}

	}

	public String SaveFile(){
		String saveFile = ""; 

		for(int x =0; x< liveCrops.size(); x++){



			if(liveCrops.get(x)!= null){
				saveFile += liveCrops.get(x).toString();
			}
		}

		for(int x =0; x< liveStock.size(); x++){
			if(liveStock.get(x)!= null){
				saveFile += liveStock.get(x).toString();
			}
		}
		saveFile += "\n" + PlayerBank;


		return  saveFile;

	}

	public void ReadFile(){
		ReadingFile game = new ReadingFile();
		Scanner myScanner = game.GetFile("Predators");

		int i = 0;
		while(myScanner.hasNext())
		{
			String x = myScanner.nextLine();
			//System.out.println(x);
			Scanner myLineScanner = new Scanner (x);
			myLineScanner.useDelimiter(",");
			while(myLineScanner.hasNext()){

				String PurchaseName = myLineScanner.next();
				



				if(PurchaseName.equals("Cows")){
					liveStock.add(new Cows());
					//Cows a = null;
					//a.setTimer();
					System.out.println(liveStock.get(0));
				}else if(PurchaseName.equals("Goats")){
					liveStock.add(new Goats());
				}else if(PurchaseName.equals("Horses")){
					liveStock.add(new Horses());
				}else if(PurchaseName.equals("Corn")){
					liveCrops.add(new Corn());
				}else if(PurchaseName.equals("Alfalfa")){
					liveCrops.add(new Alfalfa());
				}else if(PurchaseName.equals("Wheat")){
					liveCrops.add(new Wheat());
				}

				

			}
double Bank = myScanner.nextDouble();
PlayerBank = Bank;
		}


	}


}
