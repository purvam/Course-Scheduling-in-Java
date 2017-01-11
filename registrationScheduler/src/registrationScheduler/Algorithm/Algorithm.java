package registrationScheduler.Algorithm;

import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.store.ObjectPool;
import registrationScheduler.store.Results;
import registrationScheduler.studentData.Student_data;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

/*
 * @author Smurfette
 */
public class Algorithm {
	
	FileDisplayInterface result;
	ObjectPool objPool;
	
	/**
	 * Algorithm constructor
	 * @param resultIn
	 * @param objPoolIn
	 */
	public Algorithm(FileDisplayInterface resultIn){
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("Algorithm constructor called.",db);
		
		result=resultIn;
	}
	
	/**
	 * method to split line and assign courses 
	 * @param lineIn
	 */
    public synchronized void lineProcess(String lineIn){
		String [] lineParts=lineIn.split("\\s+");
		int [] pref = new int [7];
		int [] ac = new int [7];
		int seatsAlloted=0, chosenCourse=0;
		
		objPool= ObjectPool.getUniqueInstance();

		String n= new String(lineParts[0]);
		try{
			for(int i=0;i<7;i++){
				pref[i]=Integer.parseInt(lineParts[i+1]);
				ac[i]=0;
			}
			
			for(int i=0;i<7 && seatsAlloted<5;i++){		//to assign course
				chosenCourse=0;
				for(int j=0;j<7;j++){
					if(ac[j]==0 && !objPool.checkSeatsNotAvailable(j)){
						chosenCourse=Math.max(chosenCourse, objPool.getSeatsAvailableCount(j));
					}
				}
				for(int j=0;j<7 && seatsAlloted<5;j++){
					if(ac[j]==0 && chosenCourse==objPool.getSeatsAvailableCount(j)){
						ac[j]=pref[j];
						objPool.borrowSeat(j);
						seatsAlloted++;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}finally{}
		
		//set data
		Student_data s= new Student_data(n,pref,ac);
		((Results) result).setKeyValue(n,s);
    }
}
