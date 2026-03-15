package org.theMungai;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo repo;

    public CustomerService(CustomerRepo repo) {
        this.repo = repo;
    }


    public List<Customer> getAllCustomers(){
        return repo.findAll();
    }
}
