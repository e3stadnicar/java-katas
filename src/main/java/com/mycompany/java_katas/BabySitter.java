package com.mycompany.java_katas;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * BabySitter Kata class
 * starts no earlier than 5:00PM
 * leaves no later than 4:00AM
 * gets paid $12/hour from start-time to bedtime
 * gets paid $8/hour from bedtime to midnight
 * gets paid $16/hour from midnight to end of job
 * gets paid for full hours (no fractional hours)
 * @author e3stadnicar
 */
public class BabySitter {
	
	int startAllowed;
	int stopAllowed;
	int startTime;
	
	/*
	 * Babysitter constructor
	 */
	public BabySitter() {
		Properties props = new Properties();
		InputStream input = null;
		
		// Read in hours of operation
		try {
			input = getClass().getResourceAsStream("config.properties"); //TODO: What is the best practice way to allow external customization
			props.load(input);
			
			// Initialize start time allowed
			this.startAllowed = Integer.parseInt(props.getProperty("START_ALLOWED"));
			this.stopAllowed = Integer.parseInt(props.getProperty("STOP_ALLOWED"));
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 * Given a start, stop, and bed time calculates expected babysitter pay
	 * @param start The babysitter start time (Using integer for this exercise)
	 */
	public void calculate(int start, int stop) throws BabySitterException {
		setStartTime(start);
		setStopTime(stop);
	}
	
	/*
	 * Sets Babysitter start time
	 * @param start Babysitter start time
	 */
	private void setStartTime(int start) throws BabySitterException {
		if (start < this.startAllowed) {
			throw new BabySitterException("Babysitter start time cannot be before 5 PM.");
		}
		this.startTime = start;
	}
	
	/*
	 * Sets Babysitter stop time
	 * @param stop Babysitter stop time
	 */
	private void setStopTime(int stop) throws BabySitterException {
		if (stop > this.stopAllowed) {
			throw new BabySitterException("Babysitter stop time cannot be after 4 AM.");
		}
	}

	/**
	 * Custom exception class for BabySitter exercise
	 * @author e3stadnicar
	 */
	public class BabySitterException extends Exception {
		
		/**
		 * Generated serial version ID
		 */
		private static final long serialVersionUID = 3122619580563549593L;

		public BabySitterException(String message) {
			super(message);
		}
	}
}
