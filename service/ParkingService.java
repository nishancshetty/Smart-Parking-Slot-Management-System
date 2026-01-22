package com.parking.service;

import com.parking.enums.SlotType;
import com.parking.enums.VehicleType;
import com.parking.model.ParkingSlot;
import com.parking.model.Ticket;
import com.parking.model.Vehicle;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingService {

    private List<ParkingSlot> parkingSlots;

    // Constructor
    public ParkingService() {
        parkingSlots = new ArrayList<>();
        initializeSlots();
    }

    // Initialize parking slots
    private void initializeSlots() {
        int slotId = 1;

        // Bike slots
        for (int i = 0; i < 5; i++) {
            parkingSlots.add(new ParkingSlot(slotId++, SlotType.SMALL));
        }

        // Car slots
        for (int i = 0; i < 10; i++) {
            parkingSlots.add(new ParkingSlot(slotId++, SlotType.MEDIUM));
        }

        // SUV slots
        for (int i = 0; i < 5; i++) {
            parkingSlots.add(new ParkingSlot(slotId++, SlotType.LARGE));
        }

        // EV slots
        for (int i = 0; i < 5; i++) {
            parkingSlots.add(new ParkingSlot(slotId++, SlotType.EV));
        }
    }

    // Park a vehicle
    public void parkVehicle(String vehicleNumber, VehicleType vehicleType) {

        ParkingSlot availableSlot = findAvailableSlot(vehicleType);

        if (availableSlot == null) {
            System.out.println("Sorry! No available slot for " + vehicleType);
            return;
        }

        Vehicle vehicle = new Vehicle(vehicleNumber, vehicleType);
        availableSlot.parkVehicle(vehicle);

        System.out.println("Vehicle parked successfully!");
        System.out.println("Slot ID: " + availableSlot.getSlotId());
        System.out.println("Entry Time: " + vehicle.getEntryTime());
    }

    // Find suitable slot
    private ParkingSlot findAvailableSlot(VehicleType vehicleType) {
        SlotType requiredSlotType = getSlotTypeForVehicle(vehicleType);

        for (ParkingSlot slot : parkingSlots) {
            if (!slot.isOccupied() && slot.getSlotType() == requiredSlotType) {
                return slot;
            }
        }
        return null;
    }

    // Map vehicle type to slot type
    private SlotType getSlotTypeForVehicle(VehicleType vehicleType) {
        switch (vehicleType) {
            case BIKE:
                return SlotType.SMALL;
            case CAR:
                return SlotType.MEDIUM;
            case SUV:
                return SlotType.LARGE;
            case EV:
                return SlotType.EV;
            default:
                return SlotType.MEDIUM;
        }
    }

    // Exit vehicle
    public void exitVehicle(String vehicleNumber) {

        for (ParkingSlot slot : parkingSlots) {
            if (slot.isOccupied() &&
                slot.getVehicle().getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {

                Vehicle vehicle = slot.getVehicle();
                LocalTime exitTime = LocalTime.now();

                Duration duration = Duration.between(vehicle.getEntryTime(), exitTime);
                double amount = calculateCharges(vehicle.getVehicleType(), duration);

                Ticket ticket = new Ticket(vehicle, slot, exitTime, duration, amount);
                ticket.printTicket();

                slot.removeVehicle();
                System.out.println("Vehicle exited successfully!");
                return;
            }
        }
        System.out.println("Vehicle not found!");
    }

    // Calculate parking charges
    private double calculateCharges(VehicleType vehicleType, Duration duration) {

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

        double hours = Math.ceil(duration.toMinutes() / 60.0);
        return hours * ratePerHour;
    }

    // Display parking status
    public void displayParkingStatus() {

        int occupied = 0;

        System.out.println("\n----- PARKING STATUS -----");
        for (ParkingSlot slot : parkingSlots) {
            System.out.println(slot);
            if (slot.isOccupied()) {
                occupied++;
            }
        }
        System.out.println("--------------------------");
        System.out.println("Total Slots    : " + parkingSlots.size());
        System.out.println("Occupied Slots : " + occupied);
        System.out.println("Available Slots: " + (parkingSlots.size() - occupied));
    }

    // Search vehicle
    public void searchVehicle(String vehicleNumber) {

        for (ParkingSlot slot : parkingSlots) {
            if (slot.isOccupied() &&
                slot.getVehicle().getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {

                System.out.println("Vehicle Found!");
                System.out.println("Slot id    : " + slot.getSlotId());
                System.out.println("Vehicle Type: " + slot.getVehicle().getVehicleType());
                System.out.println("Entry Time : " + slot.getVehicle().getEntryTime());
                return;
            }
        }
        System.out.println("Vehicle not found!");
    }
}