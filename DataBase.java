import java.util.*;

public class DataBase {

	//Using patent ID as index
	public HashMap<String, Patent> myPtable;
	//blocking patents table
	public HashMap<String, Patent> myBPtable;
	
	public String blockingDataPath;
	
	public String outputBlockingDataPath;
	
	public String CitationTablePath;
	
	public String CitationNumberTablePath;
	
	public String DateInventorTablePath;
	
	public String outputDatePath;
	
	//singulaton 
	private static DataBase myDataBase;
	
	private DataBase(){
		this.CitationTablePath = new String("citationsSample.csv");
		this.CitationNumberTablePath = new String("citationNumber.csv");
		this.blockingDataPath = new String("NumberOfBlockingSample.csv");
		this.outputBlockingDataPath = new String("BlockingCitation.csv");
		this.DateInventorTablePath = new String("DateSample.csv");
		this.outputDatePath = new String("dates.csv");
		
		this.myPtable = new HashMap<String, Patent>();
		this.myBPtable = new HashMap<String, Patent>();
	}
	
	public static DataBase GetDataBase(){
		if(myDataBase == null){
			myDataBase = new DataBase();
		}
		return myDataBase;
	}
}
