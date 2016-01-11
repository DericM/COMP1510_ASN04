package q3;

import java.text.DecimalFormat;

/**
 * Represents a clock object with minutes,
 * seconds and miliseconds.
 * 
 * @author Deric
 * @version 1.0
 */
public class Clock {
    
    /** Minutes elapsed. */
    private int minutes;
    /** Seconds elapsed. */
    private int seconds;
    /** Milliseconds elapsed. */
    private int miliseconds;

    /**
     * Default constructor.
     */
    Clock() {
        minutes = 0;
        seconds = 0;
        miliseconds = 0;
    }

    /** Adds a number of miliseconds.
     * @param mili miliseconds to be added.
     */
    public void increment(int mili) {
        miliseconds += mili;
        checkOverflow();
    }

    /**
     * Resets the clock to 0.
     */
    public void reset() {
        minutes = 0;
        seconds = 0;
        miliseconds = 0;
    }

    /** Returns a string representing the time.
     *  MM.SS.m.
     * @return String representing the time.
     */
    public String getTime() {
        final int miliPerTenth = 100;
        DecimalFormat df = new DecimalFormat("00");
        return df.format(minutes) + ":" + df.format(seconds) 
            + ":" + (miliseconds / miliPerTenth);
    }

    /**
     * Checks if the miliseconds have gone over 1000. If yes, it adds
     * them to the seconds.
     * Checks if the seconds have gone of 60. if Yes it adds
     * them to the minutes.
     */
    private void checkOverflow() {
        final int secMax = 60;
        final int miliMax = 1000;
        if (miliseconds >= miliMax) {
            seconds++;
            miliseconds -= miliMax;
        }
        if (seconds >= secMax) {
            minutes++;
            seconds -= secMax;
        }
    }

}
