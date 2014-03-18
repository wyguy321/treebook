///////////////////////////////////////////////
//Wyatt Melin 10/18/12    Lab 5 
//
//This class implements the GUI interface of the the farm animal driver class. 
//
//
//
//////////////////////////////////////////////


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
public class FarmAnimalDriverPanel extends JPanel {

	private JButton[][] buttons;
	private JButton inventoryButton;
	private JLabel Banklabel;
	private JLabel AnimalLabel;
	private JLabel CropLabel; 
	private JLabel Goatlabel;
	private JLabel Alfalfalabel;
	private JLabel Cornlabel;
	private JLabel Wheatlabel;
	private JButton[] SortingButtons;




	private JTextField labelPanel;
	JPanel subpanel = new JPanel();
	Player user = new Player();
	Animals cowCount = new Cows();
	Animals goatCount = new Goats();
	Animals horseCount = new Horses();

	Crops alfalfaCount = new Alfalfa();
	Crops wheatCount = new Wheat();
	Crops cornCount = new Corn();

	public FarmAnimalDriverPanel(){



		ButtonListener buttonListener = new ButtonListener();
		sortAnimalName SortByAnimalName = new sortAnimalName();
		sortAnimalCostListener SortByAnimalCost = new sortAnimalCostListener();
		sortCropName SortByCropName = new sortCropName();
		sortCropCost SortByCropCost = new sortCropCost();
		sortAnimalValue SortByAnimalValue = new sortAnimalValue();
		sortCropValue SortByCropValue = new sortCropValue();
		saveButton SaveButton = new saveButton();
		uploadButton Upload = new uploadButton();
		
		





		subpanel.setPreferredSize(new Dimension (800,900));

		buttons = new JButton [2][6]; 

		buttons [0][0] = new JButton("Buy Cow");
		buttons [0][1] = new JButton("Sell Cow");
		buttons [0][2] = new JButton("Buy Goats");
		buttons [0][3] = new JButton("Sell Goats");
		buttons [0][4] = new JButton("Buy Horses");
		buttons [0][5] = new JButton("Sell Horses");

		buttons [1][0] = new JButton("Buy Alfalfa");
		buttons [1][1] = new JButton("Sell Alfalfa");
		buttons [1][2] = new JButton("Buy Corn");
		buttons [1][3] = new JButton("Sell Corn");
		buttons [1][4] = new JButton("Buy Wheat");
		buttons [1][5] = new JButton("Sell Wheat");
		inventoryButton = new JButton("Inventory");


		SortingButtons = new JButton [8];

		SortingButtons [0] = new JButton("Sort By Animal Name");
		SortingButtons [1] = new JButton("Sort By Animal Cost");
		SortingButtons [2] = new JButton("Sort By Crop Name");
		SortingButtons [3] = new JButton("Sort By Crop Cost");
		SortingButtons [4] = new JButton("Sort By Animal Value");
		SortingButtons [5] = new JButton("Sort By Crop Value");
		SortingButtons [6] = new JButton("Save File");
		SortingButtons [7] = new JButton("Upload File");
		
		
		
		



		SortingButtons [0].addActionListener(SortByAnimalName);

		SortingButtons [1].addActionListener(SortByAnimalCost);

		SortingButtons [2].addActionListener(SortByCropName);

		SortingButtons [3].addActionListener(SortByCropCost);
		
		SortingButtons [4].addActionListener(SortByAnimalValue);
		
		SortingButtons [5].addActionListener(SortByCropValue);
		
		SortingButtons [6].addActionListener(SaveButton);
		
		SortingButtons [7].addActionListener(Upload);
		
		

		Crops myCrops = new Crops();


		for(int y=0; y<buttons.length; y++){
			for(int z =0; z<buttons[0].length; z++){

				buttons[y][z].addActionListener(buttonListener);





			}
		}



		//For loop to add the buttons to the screen 
		for(int i=0; i<buttons.length; i++){
			for(int j=0; j<buttons[0].length; j++){
				subpanel.add(buttons[i][j]);




			}

		}
		subpanel.add(inventoryButton);
		subpanel.add(SortingButtons[0]);
		subpanel.add(SortingButtons[1]);
		subpanel.add(SortingButtons[2]);
		subpanel.add(SortingButtons[3]);
		subpanel.add(SortingButtons[4]);
		subpanel.add(SortingButtons[5]);
		subpanel.add(SortingButtons[6]);
		subpanel.add(SortingButtons[7]);
		
		Banklabel = new JLabel("Bank Account: $"+ user.PlayerBank);
		AnimalLabel = new JLabel("Number of Animals: "+ user.AnimalCounter);
		CropLabel = new JLabel("Number of Crops: "+ user.CropCounter); 


		add (Banklabel);
		add (AnimalLabel);
		add (CropLabel);
		add (subpanel);




	}

	private class ButtonListener implements ActionListener 
	{
		public void actionPerformed (ActionEvent event)

		// Determines what text is on the button and either buys the animal/crop or sells it. Furthermore it then goes onto another selling if statement to sell the Animals and Crops 
		{

			JButton buttonListen = new JButton();
			buttonListen=(JButton) event.getSource();

			String[] ButtonText = buttonListen.getText().split(" ");
			if(ButtonText[0].equalsIgnoreCase("Buy")){
				if(ButtonText[1].equalsIgnoreCase("Cow")){

					user.addAnimal(new Cows());
					cowCount.Counter++;

				}else if(ButtonText[1].equalsIgnoreCase("Goats")){
					user.addAnimal(new Goats());
					goatCount.Counter++;

				}else if(ButtonText[1].equalsIgnoreCase("Horses")){
					user.addAnimal(new Horses());
					horseCount.Counter++;

				}else if(ButtonText[1].equalsIgnoreCase("Alfalfa")){
					user.addCrops(new Alfalfa());
					alfalfaCount.Counter++;
				}else if(ButtonText[1].equalsIgnoreCase("Wheat")){
					user.addCrops(new Wheat());
					wheatCount.Counter++;
				}else if(ButtonText[1].equalsIgnoreCase("Corn")){
					user.addCrops(new Corn());
					cornCount.Counter++;
				}



			}
			else if(ButtonText[0].equalsIgnoreCase("Sell")){
				if(ButtonText[1].equalsIgnoreCase("Cow")){
					user.sellAnimal(new Cows());

					cowCount.Counter--;
				}else if (ButtonText[1].equalsIgnoreCase("Goats")){
					user.sellAnimal(new Goats());
					goatCount.Counter--;
				}else if(ButtonText[1].equalsIgnoreCase("Horses")){
					user.sellAnimal(new Horses());
					horseCount.Counter--;
				}else if(ButtonText[1].equalsIgnoreCase("Alfalfa")){
					user.sellCrops(new Alfalfa());
					alfalfaCount.Counter--;
				}else if(ButtonText[1].equalsIgnoreCase("Wheat")){
					user.sellCrops(new Wheat());
					wheatCount.Counter--;
				}else if(ButtonText[1].equalsIgnoreCase("Corn")){
					user.sellCrops(new Corn());
					cornCount.Counter--;	
				}


			
				int y = 0 ; 
				int x = 0;
				
				
				y = buttons [0][0] .getY();
				
				x = buttons [0][0] .getX();
				
			
				
				y += 10; 
				
				buttons [0][0] .setLocation(x, y);
				
				repaint();
				 


			}
			Banklabel.setText("Bank Account: $" +user.PlayerBank);
			AnimalLabel.setText("Number of Animals: "+user.AnimalCounter);
			CropLabel.setText("Number of Crops: "+user.CropCounter);
			//user.setTimer(60);		 
		}

	}

	private class sortAnimalName implements ActionListener 
	{
		public void actionPerformed (ActionEvent event)


		{
			try{
				
			
				
			
			ArrayList<Animals> AnimalList = new ArrayList <Animals>();

			AnimalList = user.getLiveStock();

			Animals temp;

			int min;
			
			for (int index = 0; index < AnimalList.size(); index++){
				min = index;

				for(int scan = index+1; scan < AnimalList.size(); scan++){
					if(AnimalList.get(scan) != null){
					if(AnimalList.get(scan).compareName(AnimalList.get(min)) < 0)
						min = scan;
					temp = AnimalList.get(min);
					AnimalList.set(min, AnimalList.get(index));
					AnimalList.set(min, temp);
					}
				
				}
			}
			String printOut ="";
			for (int i =0; i <AnimalList.size(); i++){
				 printOut += AnimalList.get(i).AnimalName + "\n";
			}
				JOptionPane.showMessageDialog(null,printOut ,"Sort By Animal Name",
						JOptionPane.PLAIN_MESSAGE);
			
			
			}
		
			catch (NullPointerException exception )
		{
				JOptionPane.showMessageDialog(null,"Buy animals before you can sort them!" ,"You have no animals to sort!",
						JOptionPane.PLAIN_MESSAGE);
		}
			
			finally 
			{
				System.out.println("Animal sorted");
			}
		}
	}
	private class sortAnimalCostListener implements ActionListener 
	{
		public void actionPerformed (ActionEvent event)

		

		{
			try
		{
			ArrayList<Animals> AnimalCost = new ArrayList <Animals>();

			AnimalCost = user.getLiveStock();

			Animals temp;

			int min;
			boolean AnimalExists = true;
			for (int index = 0; index < AnimalCost.size(); index++){
				min = index;

				for(int scan = index+1; scan < AnimalCost.size(); scan++){
					if(AnimalCost.get(scan).compareCost(AnimalCost.get(min)) < 0)
						AnimalExists = true;
						min = scan;
					temp = AnimalCost.get(min);
					AnimalCost.set(min, AnimalCost.get(index));
					AnimalCost.set(min, temp);
					
				}
			}
			
			if(!AnimalExists){
				System.out.println("No Animal");
			}
			
			String printOut ="";
			for (int i =0; i <AnimalCost.size(); i++){
				 printOut += AnimalCost.get(i).Costs + "\n";
			}
				JOptionPane.showMessageDialog(null,printOut ,"Sort By Animal Cost",
						JOptionPane.PLAIN_MESSAGE);


			
		}
			
			
	
		catch(NullPointerException exception )
		{
			JOptionPane.showMessageDialog(null,"Buy animals before you can sort them!" ,"You have no animals to sort!",
					JOptionPane.PLAIN_MESSAGE);
		}
		finally{
			System.out.println("Animal Sorted");
		}

			}
	}
	private class sortCropName implements ActionListener 
	{
		public void actionPerformed (ActionEvent event)


		{

			
			ArrayList<Crops> CropsList = new ArrayList <Crops>();

			CropsList = user.getliveCrops();

			Crops temp;

			int min;
			
			for (int index = 0; index < CropsList.size(); index++){
				min = index;

				for(int scan = index+1; scan < CropsList.size(); scan++){
					if(CropsList.get(scan).compareName(CropsList.get(min)) < 0)
						min = scan;
					temp = CropsList.get(min);
					CropsList.set(min, CropsList.get(index));
					CropsList.set(min, temp);
					
				}
			}
			String printOut ="";
			for (int i =0; i <CropsList.size(); i++){
				 printOut += CropsList.get(i).CropName + "\n";
			}
				JOptionPane.showMessageDialog(null,printOut ,"Sort By Crops Name",
						JOptionPane.PLAIN_MESSAGE);
			
			


		}
	}
	private class sortCropCost implements ActionListener 
	{
		public void actionPerformed (ActionEvent event)


		{

			ArrayList<Crops> CropsList = new ArrayList <Crops>();

			CropsList = user.getliveCrops();

			Crops temp;

			int min;
			
			for (int index = 0; index < CropsList.size(); index++){
				min = index;

				for(int scan = index+1; scan < CropsList.size(); scan++){
					if(CropsList.get(scan).compareCost(CropsList.get(min)) < 0)
						min = scan;
					temp = CropsList.get(min);
					CropsList.set(min, CropsList.get(index));
					CropsList.set(min, temp);
					
				}
			}
			String printOut ="";
			for (int i =0; i <CropsList.size(); i++){
				 printOut += CropsList.get(i).Cost + "\n";
			}
				JOptionPane.showMessageDialog(null,printOut ,"Sort By Crops Cost",
						JOptionPane.PLAIN_MESSAGE);
			


		}
	}
	private class sortAnimalValue implements ActionListener 
	{
		public void actionPerformed (ActionEvent event)


		{

			ArrayList<Animals> AnimalList = new ArrayList <Animals>();

			AnimalList = user.getLiveStock();

			Animals temp;

			int min;
			
			for (int index = 0; index < AnimalList.size(); index++){
				min = index;

				for(int scan = index+1; scan < AnimalList.size(); scan++){
					if(AnimalList.get(scan).compareValue(AnimalList.get(min)) < 0)
						min = scan;
					temp = AnimalList.get(min);
					AnimalList.set(min, AnimalList.get(index));
					AnimalList.set(min, temp);
					
				}
			}
			String printOut ="";
			for (int i =0; i <AnimalList.size(); i++){
				 printOut += AnimalList.get(i).MarketValue + "\n";
			}
				JOptionPane.showMessageDialog(null,printOut ,"Sort By Crops Cost",
						JOptionPane.PLAIN_MESSAGE);
			


		}
	}
	private class sortCropValue implements ActionListener 
	{
		public void actionPerformed (ActionEvent event)


		{

			ArrayList<Crops> CropsList = new ArrayList <Crops>();

			CropsList = user.getliveCrops();

			Crops temp;

			int min;
			
			for (int index = 0; index < CropsList.size(); index++){
				min = index;

				for(int scan = index+1; scan < CropsList.size(); scan++){
					if(CropsList.get(scan).compareValue(CropsList.get(min)) < 0)
						min = scan;
					temp = CropsList.get(min);
					CropsList.set(min, CropsList.get(index));
					CropsList.set(min, temp);
					
				}
			}
			String printOut ="";
			for (int i =0; i <CropsList.size(); i++){
				 printOut += CropsList.get(i).MarketValue + "\n";
			}
				JOptionPane.showMessageDialog(null,printOut ,"Sort By Crops Cost",
						JOptionPane.PLAIN_MESSAGE);
			


		}
	}
	private class saveButton implements ActionListener 
	{
		public void actionPerformed (ActionEvent event)


		{

			FileWrite file = new FileWrite ("Predators", user.SaveFile());
			


		}
	}
	private class uploadButton implements ActionListener 
	{
		public void actionPerformed (ActionEvent event)


		{

			user.ReadFile();
			
			
			Banklabel.setText("Bank Account: $" +user.PlayerBank);


		}
	}
	
}


