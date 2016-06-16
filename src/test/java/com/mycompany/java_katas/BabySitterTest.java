package com.mycompany.java_katas;


import static org.junit.Assert.assertEquals;

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
		babysitter.calculate(16, 4, 4);
		babysitter.calculate(0, 4, 4);
	}
	
	/*
	 * Test Babysitter stop time cannot be after 4am
	 */
	@Test(expected=BabySitterException.class)
	public void testCannotStopAfterFourAM() throws BabySitterException {
		babysitter.calculate(17, 5, 4);
		babysitter.calculate(17, 23, 4);
	}
	
	//Recommended: Test babysitter start cannot be after stop
	//Recommended: Test babysitter stop cannot be same as babysitter start
	
	/*
	 * Test calculate babysitter payment of $12/hour form start-time to bedtime
	 */
	@Test
	public void testCalculatePaymentFromStartToBedTime() throws BabySitterException {
		assertEquals(48, babysitter.calculate(17, 21, 21));
		assertEquals(84, babysitter.calculate(17, 0, 0));
		assertEquals(132, babysitter.calculate(17, 4, 4));
	}
	
	/*
	 * Test calculate babysitter payment of $8/hour from bedtime to midnight
	 */
	@Test
	public void testCalculatePaymentFromBedTimeToMidnight() throws BabySitterException {
		assertEquals(32, babysitter.calculate(0, 4, 0));
		assertEquals(16, babysitter.calculate(21, 23, 21));
		assertEquals(40, babysitter.calculate(23, 4, 23));
		
		assertEquals(116, babysitter.calculate(17, 4, 0));
		assertEquals(52, babysitter.calculate(18, 23, 21));
		assertEquals(88, babysitter.calculate(19, 4, 23));
	}
	
	/*
	 * Test calculate babysitter payment of $16/hour from midnight to end of job
	 */
	@Test 
	public void testCalculatePaymentFromMidnightToStop() throws BabySitterException {
		assertEquals(64, babysitter.calculate(0, 4, 0));
	}
	
	
	// gets paid for full hours (no fractional hours)

}
