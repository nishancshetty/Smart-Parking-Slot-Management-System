package com.parking.model;
import com.parking.enums.VehicleType;
import java.time.LocalTime;

public class Vehicle {

    private String vehicleNumber;
    private VehicleType vehicleType;
    private LocalTime entryTime;

    // Constructor
    public Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.entryTime = LocalTime.now();
    }

    // Getters and Setters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {
        return "Vehicle Number: " + vehicleNumber +
               ", Type: " + vehicleType +
               ", Entry Time: " + entryTime;
    }