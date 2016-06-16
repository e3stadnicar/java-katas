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
	
	private int startAllowed;
	private int stopAllowed;
	private int startTime;
	private int stopTime;
	private int bedTime;
	private int beforeBedPay;
	
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
			this.beforeBedPay = Integer.parseInt(props.getProperty("BEFORE_BED_PAY"));
			
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
	public int calculate(int start, int stop, int bedTime) throws BabySitterException {
		//TODO: Do not allow start before stop
		// Do not allow start time before 5p
		if ((startTime > this.stopAllowed && startTime < this.startAllowed) || (stop < this.startAllowed && stop > this.stopAllowed)) {
			throw new BabySitterException("Start time must be between babysitting hours of " + startAllowed + " and " + stopAllowed);
		}
		
		setStartTime(start);
		setStopTime(stop);
		setBedTime(bedTime);
		
		int payment = this.beforeBedPay * (this.bedTime - this.startTime);
		
		return payment;
	}
	
	/*
	 * Sets Babysitter start time
	 * @param start Babysitter start time
	 */
	private void setStartTime(int start) {
		this.startTime = start;
	}
	
	/*
	 * Sets Babysitter stop time
	 * @param stop Babysitter stop time
	 */
	private void setStopTime(int stop) {
		this.stopTime = stop;
	}
	
	/*
	 * Sets Babysitter bed time
	 * @param Baby or child's bed time
	 */
	private void setBedTime(int toBed) {
		this.bedTime = toBed;
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
