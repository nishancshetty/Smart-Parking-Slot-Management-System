package com.parking.main;

import com.parking.enums.VehicleType;
import com.parking.service.ParkingService;

import java.util.Scanner;

public class ParkingApp {

    public static void main(String[] args) {

        ParkingService parkingService = new ParkingService();
        Scanner scanner = new Scanner(System.in);

        int choice;

        System.out.println("================================");
        System.out.println("   SMARt PARKING MANAGEMENT");
        System.out.println("================================");

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. View Parking Status");
            System.out.println("4. Search Vehicle");
            System.out.println("5. Exit Application");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter Vehicle Number: ");
                    String vehicleNumber = scanner.nextLine();

                    System.out.println("Select Vehicle Type:");
                    System.out.println("1. BIKE");
                    System.out.println("2. CAR");
                    System.out.println("3. SUV");
                    System.out.println("4. EV");
                    System.out.print("Enter choice: ");
                    int typeChoice = scanner.nextInt();

                    VehicleType vehicleType = null;

                    switch (typeChoice) {
                        case 1:
                            vehicleType = VehicleType.BIKE;
                            break;
                        case 2:
                            vehicleType = VehicleType.CAR;
                            break;
                        case 3:
                            vehicleType = VehicleType.SUV;
                            break;
                        case 4:
                            vehicleType = VehicleType.EV;
                            break;
                        default:
                            System.out.println("Invalid vehicle type!");
                            break;
                    }

                    if (vehicleType != null) {
                        parkingService.parkVehicle(vehicleNumber, vehicleType);
                    }
                    break;

                case 2:
                    System.out.print("Enter Vehicle Number to Exit: ");
                    String exitVehicleNo = scanner.nextLine();
                    parkingService.exitVehicle(exitVehicleNo);
                    break;

                case 3:
                    parkingService.displayParkingStatus();
                    break;

                case 4:
                    System.out.print("Enter Vehicle Number to Search: ");
                    String searchVehicleNo = scanner.nextLine();
                    parkingService.searchVehicle(searchVehicleNo);
                    break;

                case 5:
                    System.out.println("Thank you for using Smart Parking System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}