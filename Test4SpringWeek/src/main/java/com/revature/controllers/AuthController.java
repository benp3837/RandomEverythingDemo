package com.revature.controllers;

import com.revature.DAOs.CustomerDAO;
import com.revature.models.Customer;
import com.revature.models.DTOs.LoginDTO;
import jakarta.servlet.http.HttpSession;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    CustomerDAO customerDAO;

    public AuthController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO, HttpSession session){

            //TODO: error handle in LoginDTO data

        System.out.println(loginDTO);

            Customer customer = customerDAO.findByCustomerNameAndCustomerPassword(
                    loginDTO.getUsername(),
                    loginDTO.getPassword()
            );

            if(customer == null){
                return ResponseEntity.badRequest().body("Invalid Login Creds");
            }

            session.setAttribute("customerId", customer.getCustomerId());
            session.setAttribute("customerName", customer.getCustomerName());

            return ResponseEntity.ok(customer);

    }

    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody Customer customer){

        //TODO: error handling on incoming customer

        System.out.println(customer);

        Customer newCustomer = customerDAO.save(customer);

        return ResponseEntity.accepted().body(newCustomer);
    }

}
