package com.ubs.opsit.interviews;

import java.util.Arrays;
import java.util.Collections;

/**
 * Presentation for Berlin Clock in String format.
 * 
 * @author samir201805
 *
 */
public class BerlinClock {
	
	     /**
	     * 
	     * Create a new Clock instance with a string representing time.
	     * @param time - The 24 hour time in the format of HH:MM:SS
	     */
	    public BerlinClock(String time) {

	        if(time == null) throw new IllegalArgumentException(NO_TIME_ERROR);

	        String[] times = time.split(":", 3);

	        if(times.length != 3) throw new IllegalArgumentException(INVALID_TIME_ERROR);

	        int hours, minutes, seconds = 0;
	        
	        try {
	            hours = Integer.parseInt(times[0]);
	            minutes = Integer.parseInt(times[1]);
	            seconds = Integer.parseInt(times[2]);
	        } catch (NumberFormatException e) {
	            throw new IllegalArgumentException(NUMERIC_TIME_ERROR);
	        }

	        if (hours < 0 || hours > 24) throw new IllegalArgumentException("Hours out of bounds.");
	        if (minutes < 0 || minutes > 59) throw new IllegalArgumentException("Minutes out of bounds.");
	        if (seconds < 0 || seconds > 59) throw new IllegalArgumentException("Seconds out of bounds.");

	        this.berlinClockTime = convertTimeToBerlinClockFormat(hours, minutes, seconds);
	    }

	    /**
	     * Convert hours, minutes and seconds into a BerlinTime Clock object.
	     *
	     * @param hours - integer representing Hours
	     * @param minutes - integer representing Minutes
	     * @param seconds - integer representing Seconds
	     *
	     * @return BerlinTime Clock object created using the parameters.
	     */
	    private String convertTimeToBerlinClockFormat(int hours, int minutes, int seconds) {

	        String line1 = (seconds % 2 == 0) ? "Y" : "0";
	      	        
	        String line2 = createRowString(hours / 5,  "R",4);
	        String line3 = createRowString(hours % 5,"R", 4 );
	        String line4 = createRowString(minutes / 5, "Y",11).replaceAll("YYY", "YYR");
	        String line5 = createRowString(minutes % 5,"Y", 4);
	        
	        return String.join(NEW_LINE, Arrays.asList(line1, line2, line3, line4, line5));
	      
	    }

	    /**
	     * Creates a string for each row of the berlin clock.
	     * @param litLights
	     * @param lightsInRow
	     * @param lampType
	     * @returnn A string representing a single row of the clock.
	     */
	    private String createRowString(int lightsOn,  String lightType, int lightsInaRow) {

	        int lightsOff = lightsInaRow - lightsOn;
	        String onlites = String.join("", Collections.nCopies(lightsOn, lightType));
	        String offlites = String.join("", Collections.nCopies(lightsOff, "0"));
	        return onlites + offlites;
	    }
	   

	    @Override
	    public String toString() {
	        return this.berlinClockTime;
	    }


	    
	    private String berlinClockTime;
	    private static final String NEW_LINE = System.getProperty("line.separator");
	    private static final String NO_TIME_ERROR = "No time provided";
	    private static final String INVALID_TIME_ERROR = "Invalid time provided.";
	    private static final String NUMERIC_TIME_ERROR = "Time values must be in Number Format.";
	}