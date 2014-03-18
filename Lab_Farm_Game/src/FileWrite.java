/////////////////////////////////////////
//Wyatt Melin   11/15/12
//
//CSI 136
//
//This class writes the games information to the predator file when pressed by the action listener. 
//
//
////////////////////////////////////////

import java.io.*;
public class FileWrite {

	public FileWrite(String fileName, String infoToWrite){
		try {
			// Create file
			FileWriter myWriter = new FileWriter("./src/" + fileName);
			BufferedWriter myBufferedWriter = new BufferedWriter(myWriter);							
			myBufferedWriter.write(infoToWrite);
			
			
			// Close the output stream
			myBufferedWriter.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	
		
	}
}
