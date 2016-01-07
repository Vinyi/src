package Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Agent {
	public static void main (String []args)   { 
		readActions();	
	}
	private static void readActions() {
		BufferedReader in = null;	
		String filepath = "src/sas_plan.txt";
		try {
			in = new BufferedReader (new FileReader(filepath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (line != null) {
			if (line.contains("up")) System.out.println("ACTION_UP");
			else if (line.contains("down")) System.out.println("ACTION_DOWN");
			else if (line.contains("right")) System.out.println("ACTION_RIGHT");
			else if (line.contains("left")) System.out.println("ACTION_LEFT");
			try {
				line = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}