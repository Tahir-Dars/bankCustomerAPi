package com.bank.service;

import com.bank.model.Customer;
import com.bank.respository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceLogic {
    public final CustomerRepo Customertrepo;

    public CustomerServiceLogic(CustomerRepo streptococcus) {
        Customertrepo = streptococcus;
    }

    public Customer createCustomer(Customer customer) {
        return Customertrepo.save(customer);
    }

    public List<Customer> getAllCustomer() {
        return Customertrepo.findAll();
    }

    public Customer getCustomerByID(long id) {
        try {
            return Customertrepo.findById(id).orElseThrow(() ->
                    new RuntimeException("Customer with ID: " + id + " not found"));
        } catch (RuntimeException e) {
            return null;
        }
    }

    public Customer updateCustomer(long id, Customer updatedCustomer) {
        try {
            return Customertrepo.findById(id).map(existing -> {
                existing.setFirstName(updatedCustomer.getFirstName());
                existing.setLastName(updatedCustomer.getLastName());
                existing.setEmail(updatedCustomer.getEmail());
                existing.setPhoneNumber(updatedCustomer.getPhoneNumber());
                return Customertrepo.save(existing);
            }).orElseThrow(() -> new RuntimeException("Customer with ID: " + id + "Not Found"));
        }
        catch (RuntimeException e ){
            return null;
        }

    }

    public boolean deleteCustomer(long id) {
        if (Customertrepo.existsById(id)) {
            Customertrepo.deleteById(id);
            return true;
        }
        throw new RuntimeException("Customer wit ID:" + id + " Not found");
    }

}
