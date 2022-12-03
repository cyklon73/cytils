package io.github.cyklon73.cytils.utils;

public class TimeConversion {

    public static class Nanos {
        public static long toMicros(long nanos) {
            return nanos / 1000;
        }
        public static long toMillis(long nanos) {
            return Micro.toMillis(toMicros(nanos));
        }
        public static int toSeconds(long nanos) {
            return Millis.toSeconds(toMillis(nanos));
        }
        public static int toMinutes(long nanos) {
            return Seconds.toMinutes(toSeconds(nanos));
        }
        public static int toHours(long nanos) {
            return Minutes.toHours(toMinutes(nanos));
        }
        public static int toDays(long nanos) {
            return Hours.toDays(toHours(nanos));
        }
        public static int toWeeks(long nanos) {
            return Days.toWeeks(toDays(nanos));
        }
    }

    public static class Micro {
        public static long toNanos(long micros) {
            return micros * 1000;
        }
        public static long toMillis(long micros) {
            return micros / 1000;
        }
        public static int toSeconds(long micros) {
            return Millis.toSeconds(toMillis(micros));
        }
        public static int toMinutes(long micros) {
            return Seconds.toMinutes(toSeconds(micros));
        }
        public static int toHours(long micros) {
            return Minutes.toHours(toMinutes(micros));
        }
        public static int toDays(long micros) {
            return Hours.toDays(toHours(micros));
        }
        public static int toWeeks(long micros) {
            return Days.toWeeks(toDays(micros));
        }
    }
    public static class Millis {
        public static long toNanos(long millis) {
            return Micro.toNanos(toMicros(millis));
        }
        public static long toMicros(long millis) {
            return millis * 1000;
        }
        public static int toSeconds(long millis) {
            return (int) (millis / 1000);
        }
        public static int toMinutes(long millis) {
            return Seconds.toMinutes(toSeconds(millis));
        }
        public static int toHours(long millis) {
            return Minutes.toHours(toMinutes(millis));
        }
        public static int toDays(long millis) {
            return Hours.toDays(toHours(millis));
        }
        public static int toWeeks(long millis) {
            return Days.toWeeks(toDays(millis));
        }
    }

    public static class Seconds {
        public static long toNanos(int seconds) {
            return Micro.toNanos(toMicros(seconds));
        }
        public static long toMicros(int seconds) {
            return Millis.toMicros(toMillis(seconds));
        }
        public static long toMillis(int seconds) {
            return seconds * 1000L;
        }
        public static int toMinutes(int seconds) {
            return seconds / 60;
        }
        public static int toHours(int seconds) {
            return Minutes.toHours(toMinutes(seconds));
        }
        public static int toDays(int seconds) {
            return Hours.toDays(toHours(seconds));
        }
        public static int toWeeks(int seconds) {
            return Days.toWeeks(toDays(seconds));
        }
    }

    public static class Minutes {
        public static long toNanos(int minutes) {
            return Micro.toNanos(toMicros(minutes));
        }
        public static long toMicros(int minutes) {
            return Millis.toMicros(toMillis(minutes));
        }
        public static long toMillis(int minutes) {
            return Seconds.toMillis(toSeconds(minutes));
        }
        public static int toSeconds(int minutes) {
            return minutes * 60;
        }
        public static int toHours(int minutes) {
            return minutes / 60;
        }
        public static int toDays(int minutes) {
            return Hours.toDays(toHours(minutes));
        }
        public static int toWeeks(int minutes) {
            return Days.toWeeks(toDays(minutes));
        }
    }


    public static class Hours {
        public static long toNanos(int hours) {
            return Micro.toNanos(toMicros(hours));
        }
        public static long toMicros(int hours) {
            return Millis.toMicros(toMillis(hours));
        }
        public static long toMillis(int hours) {
            return Seconds.toMillis(toSeconds(hours));
        }
        public static int toSeconds(int hours) {
            return Minutes.toSeconds(toMinutes(hours));
        }
        public static int toMinutes(int hours) {
            return hours * 60;
        }
        public static int toDays(int hours) {
            return hours / 24;
        }
        public static int toWeeks(int hours) {
            return Days.toWeeks(toDays(hours));
        }
    }

    public static class Days {
        public static long toNanos(int days) {
            return Micro.toNanos(toMicros(days));
        }
        public static long toMicros(int days) {
            return Millis.toMicros(toMillis(days));
        }
        public static long toMillis(int days) {
            return Seconds.toMillis(toSeconds(days));
        }
        public static int toSeconds(int days) {
            return Minutes.toSeconds(toMinutes(days));
        }
        public static int toMinutes(int days) {
            return Hours.toMinutes(toHours(days));
        }
        public static int toHours(int days) {
            return days * 24;
        }
        public static int toWeeks(int days) {
            return days / 7;
        }
    }


    public static class Weeks {
        public static long toNanos(int weeks) {
            return Micro.toNanos(toMicros(weeks));
        }
        public static long toMicros(int weeks) {
            return Millis.toMicros(toMillis(weeks));
        }
        public static long toMillis(int weeks) {
            return Seconds.toMillis(toSeconds(weeks));
        }
        public static int toSeconds(int weeks) {
            return Minutes.toSeconds(toMinutes(weeks));
        }
        public static int toMinutes(int weeks) {
            return Hours.toMinutes(toHours(weeks));
        }
        public static int toHours(int weeks) {
            return Days.toHours(toDays(weeks));
        }
        public static int toDays(int weeks) {
            return weeks * 7;
        }
    }
}
