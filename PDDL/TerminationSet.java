package PDDL;

public class TerminationSet {
	String stype;
	String limit;
	String win; // It may be boolean
	
	public TerminationSet(String st, String l, String w) {
		stype = st;
		limit = l;
		win = w;
	}
}
