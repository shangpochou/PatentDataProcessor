import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class WriteDates extends Procedure{
	public void Task(){
		try {
			Output();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void Output() throws IOException{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(myDB.outputDatePath)); 

		String tmpTitle = new String();
		tmpTitle = tmpTitle + '"'+"PatentID"+'"'+","+'"'+"grantedYear"+'"'+","+'"'+"grantedMonth"+'"';
		tmpTitle = tmpTitle + "," + '"' + "grantedDate"+'"';
		bw.write(tmpTitle);
	    bw.newLine();
		
		for(String key : myDB.myBPtable.keySet()){
			String temp = new String();
			Patent tmpPatent = myDB.myBPtable.get(key);
			if(tmpPatent != null)
				temp = temp + tmpPatent.ID;
			if(tmpPatent.grantedDateObj != null)
				temp = temp + "," + '"' + tmpPatent.grantedDateObj.year + '"' + "," + '"' + tmpPatent.grantedDateObj.month + '"' + "," + '"' + tmpPatent.grantedDateObj.date + '"';
//			if(myDB.myBPtable.get(key).inventors != null)
//				temp = temp + "," + '"' + myDB.myBPtable.get(key).inventors.size() + '"';
			
			bw.write(temp);
		    bw.newLine();
		}
		bw.close();
	
	}
}
