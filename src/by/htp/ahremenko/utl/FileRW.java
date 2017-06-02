package by.htp.ahremenko.utl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class FileRW extends Thread {
	
	//private static String logFilePath = "c:\\Temp\\log.csv";
	private String csvDelimiter = ";";
	private int logCounter; 
	private File file;
	//private String filePath; 
	
	public FileRW( String fp ) {
		file = new File(fp);
		//filePath = fp;
		logCounter = 1000;
	}
	
	public void setLogCounter( int i ) {
		logCounter = i;
	}

	public int getNextLogCounter () {
		return (logCounter++);
	}
	
	public void addLine(String text) {
		StringBuilder sb = new StringBuilder();
		String oldFile = readFile();
		sb.append(oldFile);
		sb.append(text);
		writeFile(sb.toString());
		//FileRW.writeLog("String " + text + " was added.");	
	    
	}	
	
	public synchronized void writeLog (String msg) {
			long sysTime = System.currentTimeMillis(); 
			String sysDate = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(sysTime); 
			addLine(getNextLogCounter() + csvDelimiter + sysDate + csvDelimiter + msg);
	}
	
	public void clearLog () {
	    if (file.exists()) {
    		file.delete();
	    }
	    writeFile("");
	}
	
	public String readFile() {
	    StringBuilder sb = new StringBuilder();
	    if (file.exists()) {
	    	try {
	    		BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
    			String s;
    			while ((s = in.readLine()) != null) {
    				sb.append(s);
    				sb.append("\n");
    			}
    			in.close();
			} catch (IOException e) {
				e.getStackTrace();
				//writeLog(e.getMessage());
			}	
	    	return sb.toString();
	    } else {
	    	return "";
	    }
	}
	
	public void writeFile(String text) {
	    try {
	        if(!file.exists()){
	            file.createNewFile();
	        }
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	        try {
	            out.println(text);
	        } finally {
	            out.close();
	        }
	    } catch (IOException e) {
	    	e.getStackTrace();
			//writeLog(e.getMessage());
	    }
	}

}
