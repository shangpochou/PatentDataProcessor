/**
 * 
 */

/**
 * @author ShangpoChou
 *
 */
public class DumpMyPtable extends Procedure{

	public void Task(){
		for(String key : this.myDB.myPtable.keySet()){
			System.out.println(this.myDB.myPtable.get(key).ID + " " + this.myDB.myPtable.get(key).nOfCite);
		}
	}
}
