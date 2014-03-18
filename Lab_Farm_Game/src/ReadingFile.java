import java.io.File;
//------------------------------//
//Wyatt Melin   11/15/12
//
//CSI 136
//
//
//This class reads in all the files from the source and prints them out in all the classes when they are called 
//
//------------------------------//
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadingFile {
	
	Scanner myScanner = null;
	
	public Scanner GetFile(String FileName){
	File JobFile = new File("./src/"+FileName);
	
	try {
		myScanner = new Scanner(JobFile);
	} catch (FileNotFoundException e){
		e.printStackTrace();
	}
	
	
	
	return myScanner;
	
	
	
	
	
	
	}
	
}