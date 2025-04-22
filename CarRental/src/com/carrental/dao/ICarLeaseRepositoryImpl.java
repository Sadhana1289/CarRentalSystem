package com.carrental.dao;

import com.carrental.entity.*;
import com.carrental.exception.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ICarLeaseRepositoryImpl implements ICarLeaseRepository {

    // Car Management
    @Override
    public void addCar(Vehicle car) {
        // TODO: Add DB logic
    }

    @Override
    public void removeCar(int carID) throws CarNotFoundException {
        // TODO: Implement DB removal logic
    }

    @Override
    public List<Vehicle> listAvailableCars() {
        return new ArrayList<>(); // Placeholder
    }

    @Override
    public List<Vehicle> listRentedCars() {
        return new ArrayList<>();
    }

    @Override
    public Vehicle findCarById(int carID) throws CarNotFoundException {
        return null; // Placeholder
    }

    @Override
    public void updateVehicleStatus(int carID, String status) throws CarNotFoundException {
        // TODO
    }

    // Customer Management
    @Override
    public void addCustomer(Customer customer) {
        // TODO
    }

    @Override
    public void removeCustomer(int customerID) throws CustomerNotFoundException {
        // TODO
    }

    @Override
    public List<Customer> listCustomers() {
        return new ArrayList<>();
    }

    @Override
    public Customer findCustomerById(int customerID) throws CustomerNotFoundException {
        return null;
    }

    // Lease Management
    @Override
    public Lease createLease(int customerID, int carID, Date startDate, Date endDate, String type)
            throws CarNotFoundException, CustomerNotFoundException {
        return null;
    }

    @Override
    public void returnCar(int leaseID) throws LeaseNotFoundException {
        // TODO
    }

    @Override
    public List<Lease> listActiveLeases() {
        return new ArrayList<>();
    }

    @Override
    public List<Lease> listLeaseHistory() {
        return new ArrayList<>();
    }

    // Payment Handling
    @Override
    public void recordPayment(Lease lease, double amount) throws LeaseNotFoundException {
        // TODO
    }

    @Override
    public List<Payment> listPayments() {
        return new ArrayList<>();
    }
}
