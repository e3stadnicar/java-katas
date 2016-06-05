package com.mycompany.java_katas;

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

	int startTime;
	
	/*
	 * Given a start, stop, and bed time calculates expected babysitter pay
	 * @param start The babysitter start time (Using integer for this exercise)
	 */
	public void calculate(int start) throws BabySitterException {
		setStartTime(start);
	}
	
	/*
	 * Sets Babysitter start time
	 * @param start Babysitter start time
	 */
	private void setStartTime(int start) throws BabySitterException {
		if (start < 17) {
			throw new BabySitterException("Babysitter start time cannot be before 5 PM.");
		}
		this.startTime = start;
	}

	/**
	 * Custom exception class for BabySitter exercise
	 * @author e3stadnicar
	 *
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
