package com.mycompany.java_katas;

import org.junit.Before;
import org.junit.Test;

import com.mycompany.java_katas.BabySitter.BabySitterException;

public class BabySitterTest {

	BabySitter babysitter;
	
	@Before
	public void setup() {
		babysitter = new BabySitter();
	}
	
	/*
	 * Test BabySitter start time cannot be before 5pm
	 */
	@Test(expected=BabySitterException.class)
	public void testCannotStartBeforeFivePM() throws BabySitterException {
		babysitter.calculate(16, 4);
	}
	
	/*
	 * Test Babysitter stop time cannot be after 4am
	 */
	@Test(expected=BabySitterException.class)
	public void testCannotStopAfterFourAM() throws BabySitterException {
		babysitter.calculate(17, 5);
	}
	
	// gets paid $12/hour from start-time to bedtime
	
	
	// gets paid $8/hour from bedtime to midnight
	
	
	// gets paid $16/hour from midnight to end of job
	
	
	// gets paid for full hours (no fractional hours)

}
