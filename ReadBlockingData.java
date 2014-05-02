import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.*;

/**
 *Read blocking data from .CSV file. 
 *Contain patentID and number of blocking
 * 
 */

/**
 * @author ShangpoChou
 *
 */
public class ReadBlockingData extends Procedure{
	
	public void Task(){
        BufferedReader reader;
        
        try {
            
            reader = new BufferedReader(new FileReader(myDB.blockingDataPath));
         
            // Read the first line or not (comment means yes)
            reader.readLine();
      
            String line = null;
            
            while ((line = reader.readLine()) != null) {               
                String item[] = line.split(",");              
                //clear previous inputdata
               
                Patent myTmpPt = new Patent();
                myTmpPt.ID = item[0];
                myTmpPt.nOfBlocking = Integer.parseInt(item[1]);
                
                this.myDB.myBPtable.put(myTmpPt.ID, myTmpPt);     
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
