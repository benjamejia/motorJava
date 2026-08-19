package util;

public class Time {
    private static final double  TIME_STARTED = System.nanoTime();
    public static double getTime(){
        return (System.nanoTime() - TIME_STARTED) * 1E-9; 
    }
}
