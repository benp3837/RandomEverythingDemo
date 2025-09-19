package com.revature.DAOs;

import com.revature.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {

    //This is a "property expression" -
    //This is how we define custom CRUD operations that JpaRepo didn't make for us
    Customer findByCustomerNameAndCustomerPassword(String customerUsername, String customerPassword);

    //not only findBy--- there are a ton of options for property expressions you can look into
}
