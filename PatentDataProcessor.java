/**
 * 
 */

/**
 * @author ShangpoChou
 *
 */
import java.util.*;

public class PatentDataProcessor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DataBase myDB = DataBase.GetDataBase();
		
		ArrayList<Procedure> myProcAL = new ArrayList<Procedure>();
		
//		CalNumberOfCitation myCalNofCite = new CalNumberOfCitation();
//		myProcAL.add(myCalNofCite);
		
//		DumpMyPtable myDMP = new DumpMyPtable();
//		myProcAL.add(myDMP);
		
//		WriteCitationTable myWCT = new WriteCitationTable();
//		myProcAL.add(myWCT);
		
		ReadBlockingData myRBD = new ReadBlockingData();
		myProcAL.add(myRBD);
	
		QueryDateInventors myQDI = new QueryDateInventors();
		myProcAL.add(myQDI);
		
		QueryNumberOfCitation myQNC = new QueryNumberOfCitation();
		myProcAL.add(myQNC);
		
		WriteBlockingPatentTable myWBPT = new WriteBlockingPatentTable();
		myProcAL.add(myWBPT);
		
		
		
		for(int i = 0; i < myProcAL.size(); i++){
			myProcAL.get(i).GetData(myDB);
			myProcAL.get(i).Task();
		}
	}

}
