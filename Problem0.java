import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Problem0 {
	
	public static void main (String []args) throws IOException { 
		BufferedReader in = null;
		String filepath = "src/sokoban_lvl0.txt";
		in = new BufferedReader (new FileReader(filepath));
		String line = null;
		int row = 0;
		
		ArrayList<LevelMapping> LMList = new ArrayList<LevelMapping>();
		ReadLevelMapping(LMList);
		
		while ((line = in.readLine()) != null) {
			for (int col = 0; col < line.length(); ++col) {
				if (line.charAt(col) == 'w') System.out.println("(wall l" + row + " l" + col + ")");
				else if (line.charAt(col) == 'A') System.out.println("(agent l" + row + " l" + col + ")");
				else if (line.charAt(col) != ' '){
					for (int i = 0; i < LMList.size(); ++i){
						//char c = (char) LMList.get(i).value;
						//System.out.println(c);
						if (line.charAt(col) == LMList.get(i).value) {
							System.out.println("(" +LMList.get(i).name +  " l" + row + " l" + col + ")");
						}
					}
				}
			}
			++row;
		}
		in.close();
	}

	private static void ReadLevelMapping(ArrayList<LevelMapping> LevelMappingList) throws NumberFormatException, IOException {
		BufferedReader in = null;
		String filepath = "src/sokoban.txt";
		in = new BufferedReader (new FileReader(filepath));
		String line = null;
		while ((line = in.readLine()) != null){
			if (line.contains("LevelMapping")){
				while (!(line = in.readLine()).contains("InteractionSet")){
					String[] s = line.split("\\s+");
					LevelMapping LM = new LevelMapping((s[1]).charAt(0),s[3]);
					LevelMappingList.add(LM);
				}
			}
		}
		in.close();
	}	
		
}
