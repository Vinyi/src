import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import PDDL.ObjectMap;

public class PDDLCompiler {
	public static void main (String []args) throws IOException { 
		generateProblem();	
	}
	private static void generateProblem() throws IOException{
		BufferedReader in = null;	
		String filepath = "src/sokoban_easy.txt";
		in = new BufferedReader (new FileReader(filepath));
		String line = null;
		line = in.readLine();
		int size = line.length();
		ArrayList<ObjectMap> objectList = new ArrayList<ObjectMap>();
		int j = 0;
		while (line != null) {
			initObjects(line, objectList, j);
			++j;
			line = in.readLine();
		}
		in.close();
		System.out.println(defineProblem() + domainProblem() + objectProblem(size)
		+ initProblem(objectList));
		
	}
		
	private static String defineProblem() {
		String define;
		String nameProblem = "problem0";
		define = "(define (problem ";
		define += nameProblem;
		define += ")";
		return define;
	}

	private static String domainProblem() {
		String domain;
		String nameDomain = "domain0";
		domain = "\n\t(:domain ";
		domain += nameDomain;
		domain += ")";
		return domain;
	}

	private static String objectProblem(int size) {
		String objects;
		objects = "\n\t(: objects\n";
		objects += "\t\t";
		for (int i = 0; i < size; ++i) {
			objects += "x" + i + " ";
		}
		objects += "- xpos\n";
		objects += "\t\t";
		for (int i = 0; i < size; ++i) {
			objects += "y" + i + " ";
		}
		objects += "- ypos\n\t)";
		return objects;
	}
	
	private static String initProblem(ArrayList<ObjectMap> objList) {	
		String init;
		init = "\n\t(: init\n";
		int sizeList = objList.size();
		for (int i = 0; i < sizeList; ++i) {
			init += "\t\t(";
			init += objList.get(i).name;
			int x = objList.get(i).xpos;
			int y = objList.get(i).ypos;
			init += " x" + Integer.toString(x) + " y" + Integer.toString(y) + ")\n";
		}		
		init += "\t)";
		return init;
	}
	
	private static void initObjects(String lineRead, ArrayList<ObjectMap> objList, int y) {
		String nameObj = "";
		for (int x = 0; x < lineRead.length(); ++x) {
			if (lineRead.charAt(x) == 'w') nameObj = "wall";
			else if (lineRead.charAt(x) == 'A') nameObj = "avatar";
			else if (lineRead.charAt(x) == ' ') nameObj = "clear";
			ObjectMap obj = new ObjectMap (nameObj,x,y);
			objList.add(obj);
		//It leaves "(suc x0 x1)" it's important!! generate it!
		}	
	}
}
