
package registrationScheduler.threadMgmt;

import registrationScheduler.Algorithm.Algorithm;
import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

/**
 * 
 * @author Smurfette
 *
 */
public class WorkerThread implements Runnable  {

	FileProcessor fp;
	FileDisplayInterface result;
	Algorithm algo;
	String WThreadName;
	
	/**
	 * WorkerThread constructor
	 * @param fileproIn
	 * @param resultIn
	 * @param opIn
	 * @param algoIn
	 * @param threadNum
	 */
    public WorkerThread(FileProcessor fileproIn, FileDisplayInterface resultIn, Algorithm algoIn, int threadNum) {
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("WorkerThread constructor called.",db);
    	
		fp = fileproIn;
		result=resultIn;
		algo =algoIn;
		WThreadName =new String("Thread_no_"+threadNum);
	}
  
    /**
     * method to overwrite run for threads
     */
	public void run() {

		String line;		
		try{
			DebugLevel db = DebugLevel.RUN;
			Logger.getUniqueInstance();
			Logger.writeMessage("run method called.",db);

			line=fp.readNextLine();
			
			while(line!=null){
				algo.lineProcess(line);
				line=fp.readNextLine();
			}
		}catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}
    }
}