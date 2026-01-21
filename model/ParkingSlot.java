package com.parking.model;

import com.parking.enums.SlotType;

public class ParkingSlot {

    private int slotId;
    private SlotType slotType;
    private boolean occupied;
    private Vehicle vehicle;

    // Constructor
    public ParkingSlot(int slotId, SlotType slotType) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.occupied = false;
        this.vehicle = null;
    }

    // Getters and Setters
    public int getSlotId() {
        return slotId;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    // Park vehicle in this slot
    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.occupied = true;
    }

    // Remove vehicle from this slot
    public void removeVehicle() {
        this.vehicle = null;
        this.occupied = false;
    }

    @Override
    public String toString() {
        if (occupied) {
            return "Slot ID: " + slotId +
                   " | Slot Type: " + slotType +
                   " | Occupied by: " + vehicle.getVehicleNumber();
        } else {
            return "Slot ID: " + slotId +
                   " | Slot Type: " + slotType +
                   " | Available";
        }
    }
}