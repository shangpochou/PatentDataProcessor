import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class QueryDateInventors extends Procedure{
	
	public void Task(){
        BufferedReader reader;
        
        try {
            
            reader = new BufferedReader(new FileReader(myDB.DateInventorTablePath));
         
            // Read the first line or not (comment means yes)
            reader.readLine();
      
            String line = null;
            
            while ((line = reader.readLine()) != null) {
                
                ArrayList<String> ticketStr = new ArrayList<String>();
                ArrayList<Integer> myTmpAL = new ArrayList<Integer>();
                
                String item[] = line.split("\t", -1);
                
                //clear previous inputdata
                ticketStr.clear();
                myTmpAL.clear();
                

 //               System.out.println("Date:" + item[1] + " Inventors:" + item[2]);

                if(item.length > 1){
                	//remove space
                	String tmpPatentID = item[0].replace(" ", "");
                	/*
                	 * filter of applications, ID length > 7, and 1 digit incorrect values
                	 * */
                	if(tmpPatentID.length() <= 7 && tmpPatentID.length() > 1){
                	
                		Patent tmpPatent = new Patent();
                		if(this.myDB.myBPtable.get(tmpPatentID) != null){
                			tmpPatent = this.myDB.myBPtable.get(tmpPatentID);
                			tmpPatent.grandtedDate = new String(item[1]);
                			/*
                			 * Parse date
                			 * */
                			if(item[1] != null){
                				String DateString[] = item[1].split("-");
                				tmpPatent.grantedDateObj.year = Integer.valueOf(DateString[0]);
                				tmpPatent.grantedDateObj.month = Integer.valueOf(DateString[1]);
                				tmpPatent.grantedDateObj.date = Integer.valueOf(DateString[2]);
                			}
                			tmpPatent.inventors = new ArrayList<String>();
//                			tmpPatent.inventors.add(item[2]);
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
