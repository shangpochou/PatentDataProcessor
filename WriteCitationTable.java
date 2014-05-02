import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Write citation table to a .CSV file.
 */

/**
 * @author ShangpoChou
 *
 */
public class WriteCitationTable extends Procedure{
	public void Task(){
		try {
			Output();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void Output() throws IOException{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(myDB.CitationNumberTablePath)); 

		for(String key : myDB.myPtable.keySet()){
			String temp = new String();
			temp = temp + '"' + myDB.myPtable.get(key).ID + '"' + "," + '"' + myDB.myPtable.get(key).nOfCite + '"';
			bw.write(temp);
		    bw.newLine();
		}
		bw.close();
	}

}
