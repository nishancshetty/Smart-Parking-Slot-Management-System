package com.parking.util;
import com.parking.enums.VehicleType;
import java.time.Duration;
public class ChargeCalculator {

    // Private constructor to prevent object creation
    private ChargeCalculator() {
    }

    // Calculate parking charges based on vehicle type and duration
    public static double calculateCharge(VehicleType vehicleType, Duration duration) {

        double ratePerHour;

        switch (vehicleType) {
            case BIKE:
                ratePerHour = 20;
                break;
            case CAR:
                ratePerHour = 50;
                break;
            case SUV:
                ratePerHour = 80;
                break;
            case EV:
                ratePerHour = 40;
                break;
            default:
                ratePerHour = 50;
        }

        // Round up to next hour
        double hours = Math.ceil(duration.toMinutes() / 60.0);

        return hours * ratePerHour;
    }

    // Optional: apply penalty for overstay
    public static double applyOverstayPenalty(double amount, long allowedHours, long parkedHours) {

        if (parkedHours > allowedHours) {
            return amount + 100; // flat penalty
        }
        return amount;
    }
}