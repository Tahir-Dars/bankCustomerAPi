package com.bank.service;

import com.bank.model.Customer;
import com.bank.respository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceLogic {
    //@ service added
    //made an instance of repo interface
    //gave it a constructor based injection
    //created given methods


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
        Optional<Customer> customerOptional = Customertrepo.findById(id);
        return customerOptional.orElse(null);
        //note in copy
    }

    public Customer updateCustomer(long id, Customer updatedCustomer) {
        return Customertrepo.findById(id).map(existing -> {
                    existing.setFirstName(updatedCustomer.getFirstName());
                    existing.setLastName(updatedCustomer.getLastName());
                    existing.setEmail(updatedCustomer.getEmail());
                    existing.setPhoneNumber(updatedCustomer.getPhoneNumber());
                    return Customertrepo.save(existing);
                }
        ).orElseThrow(() -> new RuntimeException("Customer with ID: " + id + "Not Found"));

    }

    public boolean deleteCustomer(long id) {
        if (Customertrepo.existsById(id)) {
            Customertrepo.deleteById(id);
            return true;
        }
        throw new RuntimeException("Customer wit ID:" + id + " Not found");
    }

}
