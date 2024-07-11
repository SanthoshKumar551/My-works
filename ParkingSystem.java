import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingSystem {
    static final int TOTAL_PARKING_SPOTS = 200;
    static int availableSpots = TOTAL_PARKING_SPOTS;
    static int customerID = 0;
    static List<CustomerRecord> records = new ArrayList<>();
    static List<CustomerRecord> departedRecords = new ArrayList<>();
    static int basePayment = 60;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Parking Management System");

        while (true) {
            System.out.println("\n1. Arrival\n2. Departure\n3. View Parking Status");
            System.out.println("4. View Customer Records\n5. Search by License Plate");
            System.out.println("6. Calculate Total Revenue\n7. Update Base Payment\n8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleArrival(scanner);
                    break;
                case 2:
                    handleDeparture(scanner);
                    break;
                case 3:
                    viewParkingStatus();
                    break;
                case 4:
                    viewCustomerRecords();
                    break;
                case 5:
                    searchByLicensePlate(scanner);
                    break;
                case 6:
                    calculateTotalRevenue();
                    break;
                case 7:
                    updateBasePayment(scanner);
                    break;
                case 8:
                    System.out.println("Exiting Parking Management System");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void handleArrival(Scanner scanner) {
        if (availableSpots == 0) {
            System.out.println("Parking is full. There is -NO SPACE-.");
            return;
        }

        System.out.print("Enter License Plate Number: ");
        String licensePlate = scanner.nextLine();
        System.out.println("Base Payment: Rs. " + basePayment);
        System.out.print("Include Base Payment? (yes/no): ");
        String includeBasePayment = scanner.nextLine();

        boolean includeBase = includeBasePayment.equalsIgnoreCase("yes");
        int totalAmountPayable = includeBase ? basePayment : 0;

        System.out.println("Proceed to Parking");

        records.add(new CustomerRecord(++customerID, licensePlate, totalAmountPayable));
        availableSpots--;
    }

    public static void handleDeparture(Scanner scanner) {
        if (records.isEmpty()) {
            System.out.println("No customers parked yet.");
            return;
        }

        System.out.print("Enter Customer ID for Departure: ");
        int departureID = scanner.nextInt();
        scanner.nextLine();

        for (CustomerRecord record : records) {
            if (record.getCustomerID() == departureID) {
                int totalAmountPayable = record.getTotalAmountPayable();
                System.out.println("Total Amount Payable: Rs. " + totalAmountPayable);
                availableSpots++;
                records.remove(record);
                departedRecords.add(record);
                System.out.println("Parking Spot Vacated.");
                return;
            }
        }
        System.out.println("Customer ID not found. Please try again.");
    }

    public static void viewParkingStatus() {
        System.out.println("Total Parking Spots: " + TOTAL_PARKING_SPOTS);
        System.out.println("Available Spots: " + availableSpots);
        System.out.println("Occupied Spots: " + (TOTAL_PARKING_SPOTS - availableSpots));
    }

    public static void viewCustomerRecords() {
        if (records.isEmpty() && departedRecords.isEmpty()) {
            System.out.println("No customer records available.");
            return;
        }

        System.out.println("Currently Parked Customer Records:");
        for (CustomerRecord record : records) {
            System.out.println(record.toString());
        }

        System.out.println("Departed Customer Records:");
        for (CustomerRecord record : departedRecords) {
            System.out.println(record.toString());
        }
    }

    public static void searchByLicensePlate(Scanner scanner) {
        System.out.print("Enter License Plate Number to search: ");
        String searchPlate = scanner.nextLine();

        for (CustomerRecord record : records) {
            if (record.getLicensePlate().equalsIgnoreCase(searchPlate)) {
                System.out.println("Matching Customer Record:");
                System.out.println(record.toString());
                return;
            }
        }

        for (CustomerRecord record : departedRecords) {
            if (record.getLicensePlate().equalsIgnoreCase(searchPlate)) {
                System.out.println("Matching Customer Record:");
                System.out.println(record.toString());
                return;
            }
        }

        System.out.println("No matching record found.");
    }

    public static void calculateTotalRevenue() {
        int totalRevenue = 0;
        for (CustomerRecord record : records) {
            totalRevenue += record.getTotalAmountPayable();
        }
        for (CustomerRecord record : departedRecords) {
            totalRevenue += record.getTotalAmountPayable();
        }
        System.out.println("Total Revenue: Rs. " + totalRevenue);
    }

    public static void updateBasePayment(Scanner scanner) {
        System.out.print("Enter new Base Payment amount: Rs. ");
        int newBasePayment = scanner.nextInt();
        scanner.nextLine();
        basePayment = newBasePayment;
        System.out.println("Base Payment updated successfully.");
    }

    static class CustomerRecord {
        int customerID;
        String licensePlate;
        int totalAmountPayable;

        public CustomerRecord(int customerID, String licensePlate, int totalAmountPayable) {
            this.customerID = customerID;
            this.licensePlate = licensePlate;
            this.totalAmountPayable = totalAmountPayable;
        }

        public int getCustomerID() {
            return customerID;
        }

        public String getLicensePlate() {
            return licensePlate;
        }

        public int getTotalAmountPayable() {
            return totalAmountPayable;
        }

        public String toString() {
            return "Customer ID: " + customerID + ", License Plate: " + licensePlate +
                    ", Total Amount Payable: Rs. " + totalAmountPayable;
        }
    }
}
