package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BerlinClockTDDTest {
	 private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	    @Before
	    public void setUpStreams() {
	        System.setOut(new PrintStream(outContent));
	        System.setErr(new PrintStream(errContent));
	    }

	    @Test
	    public void testMinValidBerlinClock() {
	        new BerlinClock("00:00:00");
	    }

	    @Test
	    public void testMaxValidBerlinClock() {
	        
	        String expected = "0\r\n"+
	                "RRRR\r\n" +
	                "RRR0\r\n" +
	                "YYRYYRYYRYY\r\n" + 
	                "YYYY";
	        assertEquals(expected, new BerlinClock("23:59:59").toString());
	    }

	    @Test
	    public void testPrintClock() {
	    	    	
	        BerlinClock clock = new BerlinClock("12:30:30");
	        //clock.printClock();

	        String expected = "Y\r\n"+
	                "RR00\r\n" +
	                "RR00\r\n" +
	                "YYRYYR00000\r\n" + 
	                "0000";
	             
	        assertEquals(expected, clock.toString());
	    }

	    @Test
	    public void testUpperInvalidHours() {
	        new BerlinClock("24:00:00");
	        String expected = "Y\r\n"+
	                "RRRR\r\n" +
	                "RRRR\r\n" +
	                "00000000000\r\n" + 
	                "0000";
	             
	        assertEquals(expected, new BerlinClock("24:00:00").toString());
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testUpperInvalidMinutes() {
	        new BerlinClock("00:60:00");
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testUpperInvalidSeconds() {
	        new BerlinClock("00:00:60");
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testLowerInvalidHours() {
	        new BerlinClock("-01:00:00");
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testLowerInvalidMinutes() {
	        new BerlinClock("00:-01:00");
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testLowerInvalidSeconds() {
	        new BerlinClock("00:00:-01");
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testInvalidString() {
	        new BerlinClock("00:00");
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testNullString() {
	        new BerlinClock(null);
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testEmptyString() {
	        new BerlinClock("");
	    }

	    @After
	    public void cleanUpStreams() {
	        System.setOut(null);
	        System.setErr(null);
	    }

	}
