
package registrationScheduler.driver;

import registrationScheduler.Algorithm.Algorithm;
import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.store.Results;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

/**
 * 
 * @author Smurfette
 *
 */
public class Driver{
	
	static int NUM_THREADS, DEBUG_VALUE;
	static String INPUT_FILE, OUTPUT_FILE;

	/**
	 * method to run project
	 * @param args
	 */
	public static void main(String args[]) {

		if(args.length!=4){
			System.out.println("Wrong number of input arguments.\nTry: <input_filename>.txt <opuput_filename>.txt <NUM_THREADS> <DEBUG_VALUE>");
			System.exit(-1);
		}

		INPUT_FILE =new String(args[0]);
		OUTPUT_FILE =new String(args[1]);
		NUM_THREADS=Integer.parseInt(args[2]);
		DEBUG_VALUE=Integer.parseInt(args[3]);
				
		if(NUM_THREADS>=4 || NUM_THREADS<=0){
			System.out.println("Wrong number of threads. Allowed values are: [1,2,3]");
			System.exit(0);
		}

		if(DEBUG_VALUE>=5 || DEBUG_VALUE<0){
			System.out.println("Wrong DEBUG_VALUE. Allowed values are: [0,1,2,3,4]");
			System.exit(0);
		}

		
		try{		
			Logger.getUniqueInstance();
			Logger.setDebugValue(DEBUG_VALUE);
			
			FileProcessor fp = new FileProcessor(INPUT_FILE);
			FileDisplayInterface result = new Results(OUTPUT_FILE);
			Algorithm algo =new Algorithm(result);
	
			CreateWorkers cw= new CreateWorkers(fp,result,algo);
			cw.startWorkers(NUM_THREADS);	//pass number of threads
			
			DebugLevel db = DebugLevel.NOTHING;
			Logger.writeMessage(("Average Preference value is: "+ ((Results) result).calcAvgPreferenceScore()),db);
	
	
			((Results) result).writeScheduleToScreen();
			result.writeSchedulesToFile();

		}catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}finally{}
		
		/*
		for(int i=0;i<7;i++){
			System.out.println(op.getSeatsAvailableCount(i)+" "+op.checkSeatsNotAvailable(i));
		}*/
		
	} // end main(...)

} // end public class Driver

