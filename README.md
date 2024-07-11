Parking Management System:-

This is a simple Parking Management System implemented in Java. The system allows users to handle parking arrivals, departures, view parking status, view customer records, search for records by license plate, calculate total revenue, and update the base payment for parking.

Features
Arrival: Register the arrival of a vehicle.
Departure: Handle the departure of a vehicle and calculate the amount payable.
View Parking Status: View the total, available, and occupied parking spots.
View Customer Records: Display all customer records.
Search by License Plate: Search for a customer record by license plate number.
Calculate Total Revenue: Calculate the total revenue generated from parking fees.
Update Base Payment: Update the base payment amount for parking.
Getting Started
Prerequisites
Java Development Kit (JDK) 8 or higher
An IDE or text editor to view and run the code.

Upon running the application, you will be greeted with a welcome message and a menu with various options. Enter the number corresponding to your choice to perform an action.

Menu Options
Arrival:

Enter the license plate number.
Choose whether to include the base payment.
Departure:

Enter the customer ID for departure.
The system will calculate the total amount payable and vacate the parking spot.
View Parking Status:

Displays the total parking spots, available spots, and occupied spots.
View Customer Records:

Displays all customer records with customer ID, license plate, and total amount payable.
Search by License Plate:

Enter the license plate number to search for a specific customer record.
Calculate Total Revenue:

Calculates and displays the total revenue generated from parking fees.
Update Base Payment:

Enter a new base payment amount to update the system.
Exit:

Exit the application.
Code Structure
The main components of the application are:

ParkingSystem: The main class containing the menu and handling user input.
CustomerRecord: A nested static class representing a customer record with customer ID, license plate, and total amount payable.
Example
Here is an example of how the system works:

Arrival:

Enter License Plate Number: ABC123
Include Base Payment? yes
Proceed to Parking
Departure:

Enter Customer ID for Departure: 1
Total Amount Payable: Rs. 60
Parking Spot Vacated
Contributing
Contributions are welcome! Please fork the repository and submit a pull request with your changes.


