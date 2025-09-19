package com.revature.controllers;

import com.revature.DAOs.CustomerDAO;
import com.revature.DAOs.TacoDAO;
import com.revature.models.Taco;
import jakarta.servlet.http.HttpSession;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taco")
public class TacoController {

    //constructor inject the DAO - yes I'll actually use the Service in demo
    TacoDAO tacoDAO;
    CustomerDAO customerDAO;

    @Autowired
    public TacoController(TacoDAO tacoDAO, CustomerDAO customerDAO) {
        this.tacoDAO = tacoDAO;
        this.customerDAO = customerDAO;
    }

    @PostMapping
    public ResponseEntity<?> orderTaco(@RequestBody Taco taco, HttpSession session){

        Integer userId = (Integer) session.getAttribute("customerId");

        if(userId == null){
            return ResponseEntity.status(401).body("Not logged in");
        }

        taco.setCustomer(customerDAO.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("No user found with id: " + userId)));

        Taco insertedTaco = tacoDAO.save(taco);

        return ResponseEntity.status(201).body(insertedTaco);
    }

    @GetMapping
    public ResponseEntity<List<Taco>> getAllTacos(){
        return ResponseEntity.ok(tacoDAO.findAll());
    }

}
