import java.awt.Dimension;
import javax.swing.JFrame;


public class FarmAnimalDriver {

	
	public static void main(String arg[]){
		JFrame frame = new JFrame ("Wyatt's Animal Game ");
		
		Crops plants = new Crops();
		Animals animal = new Animals();
		System.out.println(plants.MarketValue);
		
		
		System.out.println(animal.MarketValue);
		
		
		
		 
		
		
		
		
		
		
		
		
		frame.getContentPane().add(new FarmAnimalDriverPanel());
		frame.setPreferredSize(new Dimension (800,1000));
		frame.pack();
		frame.setVisible(true);
		
	}
}
