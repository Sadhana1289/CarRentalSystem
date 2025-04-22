package com.carrental.dao;

import com.carrental.entity.*;
import com.carrental.exception.*;

import java.util.Date;
import java.util.List;

public interface ICarLeaseRepository {

    // Car Management
    void addCar(Vehicle car);
    void removeCar(int carID) throws CarNotFoundException;
    List<Vehicle> listAvailableCars();
    List<Vehicle> listRentedCars();
    Vehicle findCarById(int carID) throws CarNotFoundException;
    void updateVehicleStatus(int carID, String status) throws CarNotFoundException;

    // Customer Management
    void addCustomer(Customer customer);
    void removeCustomer(int customerID) throws CustomerNotFoundException;
    List<Customer> listCustomers();
    Customer findCustomerById(int customerID) throws CustomerNotFoundException;

    // Lease Management
    Lease createLease(int customerID, int carID, Date startDate, Date endDate, String type)
            throws CarNotFoundException, CustomerNotFoundException;

    void returnCar(int leaseID) throws LeaseNotFoundException;
    List<Lease> listActiveLeases();
    List<Lease> listLeaseHistory();

    // Payment Handling
    void recordPayment(Lease lease, double amount) throws LeaseNotFoundException;
    List<Payment> listPayments();
}
