
package registrationScheduler.store;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import registrationScheduler.studentData.Student_data;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

/**
 * 
 * @author Smurfette
 *
 */
public class Results implements StdoutDisplayInterface,FileDisplayInterface {
 
	private ConcurrentHashMap<String,Student_data> studentInfo;
	private double avgPreferenceScore;
	private String outputFile;
	private int totalPreferenceScore;

	/**
	 * Results constructor
	 * @param filenameIn
	 */
	public Results(String filenameIn){
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("Results constructor called.",db);
		

		 studentInfo= new ConcurrentHashMap<String,Student_data>();
		 outputFile= filenameIn;
		 totalPreferenceScore=0;
		 avgPreferenceScore=0;
	}
	
	/**
	 * method to set key Value pair
	 * @param key
	 * @param v
	 */
	public synchronized void setKeyValue(String key,Student_data Value){
		DebugLevel db = DebugLevel.RESULTS;
		Logger.getUniqueInstance();
		Logger.writeMessage(("Data being added in Result."+Value.toString()),db);

		
		try{
		studentInfo.put(key, Value);
		}catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}finally{}
	}
	
	/**
	 * method to get student_data object
	 * @param key
	 * @return Student_data object
	 */
	public synchronized Student_data getValue(String key){
		Student_data sd=null;
		try{
			sd= studentInfo.get(key);
		}catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}finally{}
		
		return sd;
	}
	
	/**
	 *  method to set replace student_data object
	 * @param key
	 * @param value
	 */
	public synchronized void setValue(String key,Student_data value){
		try{
			studentInfo.replace(key, value);
		}catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}finally{}
	}
	
	/**
	 * method to calculate average preference score
	 * @return avgPreferenceScore
	 */
	public double calcAvgPreferenceScore(){
		totalPreferenceScore=0;
		for(String key: studentInfo.keySet()){
			totalPreferenceScore+= studentInfo.get(key).getPreferenceScore();
		}
		avgPreferenceScore=(double)(totalPreferenceScore/80);
		return avgPreferenceScore;
	}
	
	/**
	 * method to implement StdoutDisplayInterface method writeScheduleToScreen: writes student data in stdout
	 */
	
	public void writeScheduleToScreen(){
		DebugLevel db = DebugLevel.STORE;
		Logger.getUniqueInstance();
		Logger.writeMessage(("Data in store:\n"+resultString()),db);

	}
	
	/**
	 * method to put result data in a String
	 * @return solution 
	 */
    public String resultString() {

		int ac;
		String solution = new String();
		calcAvgPreferenceScore();
    	for(String key: studentInfo.keySet()){
    		solution=solution+key+"  ";
    		for(int i=0;i<7;i++){
    			ac=studentInfo.get(key).getAssignedCourses(i);
    			if(ac!=0){
    				if(i==0)
    					solution=solution+" A";
    				if(i==1)
    					solution=solution+" B";
    				if(i==2)
    					solution=solution+" C";
    				if(i==3)
    					solution=solution+" D";
    				if(i==4)
    					solution=solution+" E";
    				if(i==5)
    					solution=solution+" F";
    				if(i==6)
    					solution=solution+" G";
     			}
    		}
    		solution=solution+"  "+studentInfo.get(key).getPreferenceScore()+"\n";
    	}
    	solution=solution+"Avarage Preference_score is: "+ avgPreferenceScore;
    	
    	return solution;
    }

    
	/**
	 * method to implement FileDisplayInterface method writeSchedulesToFile: writes student data in file
	 * @Override
	 */
	public void writeSchedulesToFile() {
		calcAvgPreferenceScore();

		try{
			
			FileWriter fw = new FileWriter(outputFile);
			BufferedWriter bw= new BufferedWriter(fw);
			bw.write(resultString());
			bw.close();

		
		}catch(IOException e){
			e.printStackTrace();
      System.exit(0);
		}finally{}
	}
} 


