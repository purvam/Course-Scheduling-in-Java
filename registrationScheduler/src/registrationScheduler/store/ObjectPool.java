
package registrationScheduler.store;

import java.util.ArrayList;
import java.util.List;

import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

/**
 * 
 * @author Smurfette
 *
 */
public class ObjectPool {
	private List<Integer> seatsAvailable;
	static ObjectPool uniqueInstance;

	/**
	 * ObjectPool Constructor
	 */
	private ObjectPool(){
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("ObjectPool constructor called.",db);
		
		seatsAvailable= new ArrayList<Integer>();

		for(int i=0;i<7;i++){
			seatsAvailable.add(60);
		}
	}
	
	/**
	 * method to pass uniqueIstance of objectPool each time Singleton implemented
	 * @return objectPool object
	 */
	static public ObjectPool getUniqueInstance(){
		if(uniqueInstance == null){
			synchronized(ObjectPool.class){
				if(uniqueInstance == null)
					uniqueInstance = new ObjectPool();
			}
		}
		return uniqueInstance;
	}
	
	/**
	 * method get number of seats available in each course
	 * @param index
	 * @return #seats
	 */
	public synchronized int getSeatsAvailableCount(int index){
		DebugLevel db = DebugLevel.STORE;
		Logger.getUniqueInstance();
		Logger.writeMessage(("In ObjectPool Seat available for course["+index+"]: "+seatsAvailable.get(index)),db);

		return seatsAvailable.get(index);
	}
	
	/**
	 * method to return seat of index course
	 * @param index
	 * @return #seats
	 */
	public synchronized int returnSeat(int index){
		DebugLevel db = DebugLevel.STORE;
		Logger.getUniqueInstance();
		Logger.writeMessage(("In ObjectPool Seat returned to course: "+index),db);

		return seatsAvailable.set(index,(seatsAvailable.get(index)+1));
	}
	
	/**
	 * method to borrow seats from course
	 * @param index
	 * @return #seats
	 */
	public synchronized int borrowSeat(int index){
		DebugLevel db = DebugLevel.STORE;
		Logger.getUniqueInstance();
		Logger.writeMessage(("In ObjectPool Seat borrowed from course: "+index),db);

		return seatsAvailable.set(index,(seatsAvailable.get(index)-1));
	}
	
	/**
	 * method to check if course has seats
	 * @param index
	 * @return true if seats not available
	 */
	public synchronized boolean checkSeatsNotAvailable(int index){
		return (seatsAvailable.get(index)<=0);
	}
	
	/**
	 * method to give next max seats' course less than or equal to seats in ignore course
	 * @param ignore
	 * @return	index of next max seats course
	 */
	public synchronized int maxSeats(int ignore){
		int temp=0,index=0;
		for(int i=0;i<7;i++){
			if(ignore>=0 && getSeatsAvailableCount(i)<=getSeatsAvailableCount(ignore)){
				temp= Math.max(temp, getSeatsAvailableCount(i));
				index=i;
			}
			else{
				temp= Math.max(temp, getSeatsAvailableCount(i));
				index=i;
			}
		}
		
		return index;
	}
}
