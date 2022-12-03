package io.github.cyklon73.cytils.utils;

public class Time {

    /**
     * Causes the currently executing thread to sleep (temporarily cease
     * execution) for the specified number of milliseconds, subject to
     * the precision and accuracy of system timers and schedulers. The thread
     * does not lose ownership of any monitors. this function is much more accurate than Thread.sleep(), especially with higher numbers
     *
     * @param  millis
     *         the length of time to sleep in milliseconds
     */
    public static void sleep(long millis) {
        if (millis < 1) return;
        long endTime = System.currentTimeMillis() + millis;
        while (endTime > System.currentTimeMillis()) {
            try {
                Thread.sleep(0, 200000);
            } catch (InterruptedException ignored) {}
        }
    }

    /**
     * Causes the currently executing thread to sleep (temporarily cease
     * execution) for the specified number of milliseconds, subject to
     * the precision and accuracy of system timers and schedulers. The thread
     * does not lose ownership of any monitors. this function is much more accurate than Thread.sleep(), especially with higher numbers
     *
     * @param  millis
     *         the length of time to sleep in milliseconds
     *  @param  nanos
     *         the length of time to sleep in nanoseconds
     */
    public static void sleep(long millis, long nanos) {
        if (millis > 0) sleep(millis);
        if (nanos < 1) return;
        long endTime = System.nanoTime() + nanos;
        while (endTime > System.nanoTime()) {
            try {
                Thread.sleep(0, 1);
            } catch (InterruptedException ignored) {}
        }
    }


}
