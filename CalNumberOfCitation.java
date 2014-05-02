import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class CalNumberOfCitation extends Procedure{
	
	public void Task(){
        
        BufferedReader reader;
        
        try {
            
            reader = new BufferedReader(new FileReader(myDB.CitationTablePath));
         
            // Read the first line or not (comment means yes)
            reader.readLine();
      
            String line = null;
            
            while ((line = reader.readLine()) != null) {
                
                ArrayList<String> ticketStr = new ArrayList<String>();
                ArrayList<Integer> myTmpAL = new ArrayList<Integer>();
                
                String item[] = line.split(",");
                
                //clear previous inputdata
                ticketStr.clear();
                myTmpAL.clear();
                
                String myTmpString[] = item[0].split("	");

                if(myTmpString.length > 1){
                	String myTmpString2 = myTmpString[1].replace('"', ' ');
                	myTmpString2 = myTmpString2.replace(" ", "");
 //               	System.out.println(Integer.valueOf(myTmpString2));
                	String tmpPatentID = myTmpString2;
                	/*
                	 * filter of applications, ID length > 7, and 1 digit incorrect values
                	 * */
                	if(tmpPatentID.length() <= 7 && tmpPatentID.length() > 1){
                	
                		Patent tmpPatent = new Patent();
                		if(this.myDB.myPtable.get(tmpPatentID) == null){
                			tmpPatent.ID = tmpPatentID;
                			tmpPatent.nOfCite = 1;
                			this.myDB.myPtable.put(tmpPatentID, tmpPatent);
                		}else{
                			tmpPatent = this.myDB.myPtable.get(tmpPatentID);
                			tmpPatent.nOfCite++;
                			this.myDB.myPtable.put(tmpPatentID, tmpPatent);
                		}
                	}
                }
                
            }
            reader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
	}
	
		
}
