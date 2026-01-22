package com.parking.util;
import com.parking.model.ParkingSlot;
import com.parking.model.Vehicle;
import com.parking.enums.VehicleType;
import com.parking.enums.SlotType;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    private static final String PARKING_DATA_FILE = "data/parking_data.txt";

    // Save parking slots data to file
    public static void saveParkingData(List<ParkingSlot> parkingSlots) {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(PARKING_DATA_FILE))) {

            for (ParkingSlot slot : parkingSlots) {

                if (slot.isOccupied()) {
                    Vehicle v = slot.getVehicle();

                    writer.write(slot.getSlotId() + "," +
                            slot.getSlotType() + "," +
                            "OCCUPIED," +
                            v.getVehicleNumber() + "," +
                            v.getVehicleType() + "," +
                            v.getEntryTime());
                } else {
                    writer.write(slot.getSlotId() + "," +
                            slot.getSlotType() + "," +
                            "EMPTY");
                }
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving parking data: " + e.getMessage());
        }
    }

    // Load parking slots data from file
    public static List<ParkingSlot> loadParkingData() {

        List<ParkingSlot> slots = new ArrayList<>();
        File file = new File(PARKING_DATA_FILE);

        if (!file.exists()) {
            return slots; // first run, no data
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader(PARKING_DATA_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");
                int slotId = Integer.parseInt(data[0]);
                SlotType slotType = SlotType.valueOf(data[1]);
                String status = data[2];

                ParkingSlot slot = new ParkingSlot(slotId, slotType);

                if ("OCCUPIED".equals(status)) {
                    String vehicleNo = data[3];
                    VehicleType vehicleType = VehicleType.valueOf(data[4]);
                    LocalTime entryTime = LocalTime.parse(data[5]);

                    Vehicle vehicle = new Vehicle(vehicleNo, vehicleType);
                    vehicle.setEntryTime(entryTime);

                    slot.parkVehicle(vehicle);
                }
                slots.add(slot);
            }

        } catch (Exception e) {
            System.out.println("Error loading parking data: " + e.getMessage());
        }
        return slots;
    }
}