package ru.innopolis.university.fomin;

/**
 * Timing class
 */
public class ExecuteTimer {
    /**
     * Start time of milliseconds
     */
    private static long startTimer;

    /**
     * End time of milliseconds
     */
    private static long endTimer;

    /**
     * Start timer
     */
    public static void startTimer() {
        startTimer = System.currentTimeMillis();
    }

    /**
     * End timer
     */
    public static void endTimer() {
        endTimer = System.currentTimeMillis();
    }

    /**
     * @return Execute time
     */
    public static String getTime() {
        return endTimer - startTimer + "ms";
    }
}
