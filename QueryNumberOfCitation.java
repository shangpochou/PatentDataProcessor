/**
 *Query number of citations for blocking patent samples
 * 
 */

/**
 * @author ShangpoChou
 *
 */
public class QueryNumberOfCitation extends Procedure{
	
	public void Task(){
		for(String key : this.myDB.myBPtable.keySet()){
			Patent myTmpPatent = this.myDB.myBPtable.get(key);

			if(this.myDB.myPtable.get(key) != null)
				myTmpPatent.nOfCite = this.myDB.myPtable.get(key).nOfCite;
		
			this.myDB.myBPtable.put(key, myTmpPatent);
		}
	}

}
