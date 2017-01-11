
package registrationScheduler.studentData;

import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

/**
 * 
 * @author Smurfette
 *
 */
public class Student_data {
	String name;
	private int [] preferences;
	private int [] assignedCourses;
	private int preferenceScore;
	
	/**
	 * Student_data Constructor
	 * @param nameIn
	 * @param preferenceIn
	 * @param assignedCoursesIn
	 */
	public Student_data(String nameIn,int preferenceIn[], int assignedCoursesIn[]){
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("Student_data constructor called.",db);
		
		name =new String(nameIn);
		preferences = new int[7];
		assignedCourses = new int[7];
		preferenceScore =0;
		
		for(int i=0;i<7;i++){
			preferences[i]=preferenceIn[i];
			assignedCourses[i]=assignedCoursesIn[i];
			preferenceScore+=assignedCoursesIn[i];
		}
	}
	
	/**
	 * method to make string of object value
	 * @return toReturn String
	 */
	public synchronized String toString(){
		String toReturn= new String(name+ " preferences:");
		for(int i=0;i<7;i++){
			toReturn= toReturn +" "+ preferences[i];
		}
		toReturn= toReturn +" Assigned: ";
		for(int i=0;i<7;i++){
			toReturn =toReturn +" "+ assignedCourses[i];
		}
		toReturn= toReturn +" preferenceScore: "+preferenceScore+"\n";
		return toReturn;
	}
	
	/**
	 * method to get name
	 * @return name of student
	 */
	public synchronized String getName(){
		return name;
	}
	
	/**
	 * method to get preference of a course
	 * @param index
	 * @return	preference[i]
	 */
	public synchronized int getPreferences(int index){
		return preferences[index];
	}
	
	/**
	 * method to check if course is assigned or not
	 * @param index
	 * @return assignedCourses[i]
	 */
	public synchronized int getAssignedCourses(int index){
		return assignedCourses[index];
	}

	/**
	 * method to assign or de-assign course
	 * @param index
	 * @param value
	 * @return this object
	 */
	public synchronized Student_data setAssignedCourses(int index, int value){
		preferenceScore-=assignedCourses[index];
		preferenceScore+=value;
		assignedCourses[index]=value;
		return this;
	}
	
	/**
	 * method to get preferenceScore of student
	 * @return preferenceScore
	 */
	public int getPreferenceScore(){
		return preferenceScore;
	}
}
