package registrationScheduler.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import registrationScheduler.util.Logger.DebugLevel;

/**
 * 
 * @author Smurfette
 *
 */
public class FileProcessor {
	private BufferedReader br;
	String inputFileName;
	
	/**
	 * method to make string of object value
	 */
	public String toString(){
		String str = "FileProcessor class toString Method: Input_filename: " + inputFileName + "\n";
		return str;
	}
	
	/**
	 * FileProcessor constructor
	 * @param iFile
	 */
	public FileProcessor(String inputfileIn){
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("FileProcessor constructor called.",db);
		
		inputFileName =inputfileIn;
		try{
			br = new BufferedReader(new FileReader(inputFileName));
		}
		catch(IOException e){
			e.printStackTrace();
			System.exit(0);
		}
		finally{}
	}
	
	/**
	 * method to read one line
	 * @return line
	 */
	public synchronized String readNextLine(){
		String line=null;
		try{
			line=br.readLine();
		}
		catch(IOException e){
			e.printStackTrace();
			System.exit(0);
		}
		finally{}
		return line;
	}
	
	/**
	 * method to close bufferedReader object
	 * @override Object class finalize method
	 */
	protected void finalize(){
		try{
			if(br!=null)
				br.close();
		}catch(IOException e){
			e.printStackTrace();
			System.exit(0);
		}
		try {
			super.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}
