package util;

public class Time {
    private static final double  TIME_STARTED = System.nanoTime(); // 1.000,000,000 ns -> 1s 1*10^9

    public static double  getTime(){
        return (System.nanoTime() - TIME_STARTED) * 1E-9; // 1ns -> 1*10-9
    }
}
