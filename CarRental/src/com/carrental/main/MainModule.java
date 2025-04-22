package com.carrental.main;

import com.carrental.dao.ICarLeaseRepository;
import com.carrental.dao.ICarLeaseRepositoryImpl;
import com.carrental.entity.*;
import com.carrental.exception.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainModule {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ICarLeaseRepository repo = new ICarLeaseRepositoryImpl();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Car Rental System Menu =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Car");
            System.out.println("3. Create Lease");
            System.out.println("4. Return Car");
            System.out.println("5. List Available Cars");
            System.out.println("6. Remove Car");
            System.out.println("7. Remove Customer");
            System.out.println("8. List All Customers");
            System.out.println("9. Find Customer By ID");
            System.out.println("10. Find Car By ID");
            System.out.println("11. List Active Leases");
            System.out.println("12. List Lease History");
            System.out.println("13. Record Payment");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter First Name: ");
                        String fname = scanner.next();
                        System.out.print("Enter Last Name: ");
                        String lname = scanner.next();
                        System.out.print("Enter Email: ");
                        String email = scanner.next();
                        System.out.print("Enter Phone Number: ");
                        String phone = scanner.next();
                        Customer customer = new Customer(0, fname, lname, email, phone);
                        repo.addCustomer(customer);
                        System.out.println("Customer added successfully.");
                        break;

                    case 2:
                        System.out.print("Make: ");
                        String make = scanner.next();
                        System.out.print("Model: ");
                        String model = scanner.next();
                        System.out.print("Year: ");
                        int year = scanner.nextInt();
                        System.out.print("Daily Rate: ");
                        double rate = scanner.nextDouble();
                        System.out.print("Passenger Capacity: ");
                        int pc = scanner.nextInt();
                        System.out.print("Engine Capacity: ");
                        int ec = scanner.nextInt();
                        Vehicle vehicle = new Vehicle(0, make, model, year, rate, "available", pc, ec);
                        repo.addCar(vehicle);
                        System.out.println("Car added successfully.");
                        break;

                    case 3:
                        System.out.print("Customer ID: ");
                        int custId = scanner.nextInt();
                        System.out.print("Car ID: ");
                        int carId = scanner.nextInt();
                        System.out.print("Lease Type (Daily/Monthly): ");
                        String type = scanner.next();
                        Date startDate = new Date(); // Today
                        Date endDate = new Date(startDate.getTime() + 86400000L * 7); // +7 days
                        Lease lease = repo.createLease(custId, carId, startDate, endDate, type);
                        System.out.println("Lease created successfully. Lease ID: " + lease.getLeaseID());
                        break;

                    case 4:
                        System.out.print("Lease ID: ");
                        int leaseId = scanner.nextInt();
                        repo.returnCar(leaseId);
                        System.out.println("Car returned successfully.");
                        break;

                    case 5:
                        List<Vehicle> availableCars = repo.listAvailableCars();
                        for (Vehicle v : availableCars) {
                            System.out.println(v.getVehicleID() + ": " + v.getMake() + " " + v.getModel());
                        }
                        break;

                    case 6:
                        System.out.print("Enter Car ID to remove: ");
                        int removeCarId = scanner.nextInt();
                        repo.removeCar(removeCarId);
                        System.out.println("Car removed successfully.");
                        break;

                    case 7:
                        System.out.print("Enter Customer ID to remove: ");
                        int removeCustId = scanner.nextInt();
                        repo.removeCustomer(removeCustId);
                        System.out.println("Customer removed successfully.");
                        break;

                    case 8:
                        List<Customer> customers = repo.listCustomers();
                        for (Customer c : customers) {
                            System.out.println(c.getCustomerID() + ": " + c.getFirstName() + " " + c.getLastName());
                        }
                        break;

                    case 9:
                        System.out.print("Enter Customer ID to find: ");
                        int findCustId = scanner.nextInt();
                        Customer foundCust = repo.findCustomerById(findCustId);
                        System.out.println(foundCust.getCustomerID() + ": " + foundCust.getFirstName() + " " + foundCust.getLastName());
                        break;

                    case 10:
                        System.out.print("Enter Car ID to find: ");
                        int findCarId = scanner.nextInt();
                        Vehicle foundCar = repo.findCarById(findCarId);
                        System.out.println(foundCar.getVehicleID() + ": " + foundCar.getMake() + " " + foundCar.getModel());
                        break;

                    case 11:
                        List<Lease> activeLeases = repo.listActiveLeases();
                        for (Lease l : activeLeases) {
                            System.out.println("Lease ID: " + l.getLeaseID() + ", Car ID: " + l.getVehicleID() + ", Customer ID: " + l.getCustomerID());
                        }
                        break;

                    case 12:
                        List<Lease> leaseHistory = repo.listLeaseHistory();
                        for (Lease l : leaseHistory) {
                            System.out.println("Lease ID: " + l.getLeaseID() + ", Car ID: " + l.getVehicleID() + ", Customer ID: " + l.getCustomerID());
                        }
                        break;

                    case 13:
                        System.out.print("Enter Lease ID for payment: ");
                        int leasePayId = scanner.nextInt();
                        Lease leaseForPayment = repo.listLeaseHistory().stream()
                                .filter(l -> l.getLeaseID() == leasePayId)
                                .findFirst()
                                .orElseThrow(() -> new LeaseNotFoundException("Lease ID not found"));
                        System.out.print("Enter Payment Amount: ");
                        double amount = scanner.nextDouble();
                        repo.recordPayment(leaseForPayment, amount);
                        System.out.println("Payment recorded successfully.");
                        break;

                    case 0:
                        exit = true;
                        System.out.println("Exiting... Goodbye! 👋");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (CarNotFoundException | CustomerNotFoundException | LeaseNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
