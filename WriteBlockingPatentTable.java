import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteBlockingPatentTable extends Procedure{
	public void Task(){
		try {
			Output();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void Output() throws IOException{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(myDB.outputBlockingDataPath)); 

		String tmpTitle = new String();
		tmpTitle = tmpTitle + '"'+"PatentID"+'"'+","+'"'+"nOfCitation"+'"'+","+'"'+"nOfBlocking"+'"';
		tmpTitle = tmpTitle + "," + '"' + "grantedDate"+'"' + "," + '"' + "grantedYear" + '"';
		bw.write(tmpTitle);
	    bw.newLine();
		
		for(String key : myDB.myBPtable.keySet()){
			String temp = new String();
			temp = temp + '"' + myDB.myBPtable.get(key).ID + '"' + "," + '"' + myDB.myBPtable.get(key).nOfCite + '"';
			temp = temp + "," + '"' + myDB.myBPtable.get(key).nOfBlocking + '"';
			temp = temp + "," + '"' + myDB.myBPtable.get(key).grandtedDate + '"';
			if(myDB.myBPtable.get(key).grantedDateObj != null)
				temp = temp + "," + '"' + myDB.myBPtable.get(key).grantedDateObj.year + '"';
//			if(myDB.myBPtable.get(key).inventors != null)
//				temp = temp + "," + '"' + myDB.myBPtable.get(key).inventors.size() + '"';
			
			bw.write(temp);
		    bw.newLine();
		}
		bw.close();
	
	}
}
