package com.accolite.au.java.design.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger implements ILogger{
	private static volatile Logger obj;
	private Logger() {}
	public static Logger getInstance() {
		if(obj == null) {
			synchronized(Logger.class) {
				obj = new Logger();
			}
		}
		return obj;
	}
	@Override 
	public void log() throws IOException {
		
		Date obj = new Date();
		@SuppressWarnings("deprecation")
		int hours = obj.getHours();
		int mins = obj.getMinutes();
		int secs = obj.getSeconds();
		FileWriter fw = new FileWriter("app.log",true);
		fw.append("Application accessed at time:"+ hours + ":" +mins+":"+secs+"\r\n");
		fw.flush();
		fw.close();
	}
}
