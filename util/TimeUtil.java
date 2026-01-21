package com.parking.util;
import java.time.Duration;
import java.time.LocalTime;

public class TimeUtil {

    // Private constructor to prevent object creation
    private TimeUtil() {
    }

    // Calculate duration between entry and exit time
    public static Duration calculateDuration(LocalTime entryTime, LocalTime exitTime) {

        if (exitTime.isBefore(entryTime)) {
            // Handles rare case when exit is after midnight
            exitTime = exitTime.plusHours(24);
        }

        return Duration.between(entryTime, exitTime);
    }

    // Convert duration to hours (rounded up)
    public static long calculateHours(Duration duration) {
        return (long) Math.ceil(duration.toMinutes() / 60.0);
    }

    // Format duration as readable string
    public static String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        return hours + " hrs " + minutes + " mins";
    }
}