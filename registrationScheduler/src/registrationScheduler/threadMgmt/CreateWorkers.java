
package registrationScheduler.threadMgmt;

import registrationScheduler.Algorithm.Algorithm;
import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;;

/**
 * 
 * @author Smurfette
 *
 */
public class CreateWorkers  {
	FileProcessor fp;
	FileDisplayInterface result;
	Algorithm algo;
	
	Thread [] threads;
	WorkerThread [] wt;
	int NUM_THREADS;
	
	/**
	 * CreateWorkers constructor
	 * @param fileproIn
	 * @param resultIn
	 * @param opIn
	 * @param algoIn
	 */
	public CreateWorkers(FileProcessor fileproIn, FileDisplayInterface resultIn, Algorithm algoIn){
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("CreateWorker constructor called.",db);
		
		fp = fileproIn;
		result=resultIn;
		algo =algoIn;
	}
	
	/**
	 * method to create threads
	 * @param nthreadsIn
	 */
	public void startWorkers(int nthreadsIn){
		NUM_THREADS= nthreadsIn;
		
		threads = new Thread[NUM_THREADS];
		wt = new WorkerThread[NUM_THREADS];

		for(int i=0;i<NUM_THREADS;i++){
			
			wt[i]= new WorkerThread(fp,result,algo,i);
			threads[i]=new Thread(wt[i]);
			
			threads[i].start();
		}
		for(int i=0;i<NUM_THREADS;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(0);
			}finally{}
		}
	}
}