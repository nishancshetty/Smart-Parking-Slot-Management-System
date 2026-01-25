package com.parking.model;
import java.time.Duration;
import java.time.LocalTime;

public class Ticket {

    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private LocalTime exitTime;
    private Duration duration;
    private double amount;

    // Constructor
    public Ticket(Vehicle vehicle, ParkingSlot parkingSlot, LocalTime exitTime,
                  Duration duration, double amount) {
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.exitTime = exitTime;
        this.duration = duration;
        this.amount = amount;
    }

    // Getters
    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public LocalTime getExitTime() {
        return exitTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public double getAmount() {
        return amount;
    }

    // Display parking receipt
    public void printTicket() {
        System.out.println("\n----- PARKING RECEIPT -----");
        System.out.println("Vehicle Number : " + vehicle.getVehicleNumber());
        System.out.println("Vehicle Type   : " + vehicle.getVehicleType());
        System.out.println("Slot ID        : " + parkingSlot.getSlotId());
        System.out.println("Entry Time     : " + vehicle.getEntryTime());
        System.out.println("Exit Time      : " + exitTime);

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        System.out.println("Duration       : " + hours + " hrs " + minutes + " mins");
        System.out.println("Total Amount   : ₹" + amount);
        System.out.println("---------------------------\n");
    }
}