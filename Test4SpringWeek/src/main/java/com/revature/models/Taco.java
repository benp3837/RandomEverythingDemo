package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name="tacos")
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taco_id")
    private int tacoId;

    @Column(nullable = false)
    private String tacoShellType;

    //@Column is only necessary if you're adding constraints
    private String tacoFilling;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id") //this links our FK to the PK in User (name names the column!)
    private Customer customer;

    //boilerplate----------------

    //NOTE - Spring REQUIRES a no-args constructor for models.
    //This is for dependency injection I think... Or it's for the JPA I forgor :ded:
    public Taco() {
    }

    public Taco(int tacoId, String tacoShellType, String tacoFilling, Customer customer) {
        this.tacoId = tacoId;
        this.tacoShellType = tacoShellType;
        this.tacoFilling = tacoFilling;
        this.customer = customer;
    }

    //all args minus ID for inserts
    public Taco(String tacoShellType, String tacoFilling) {
        this.tacoShellType = tacoShellType;
        this.tacoFilling = tacoFilling;
    }

    public int getTacoId() {
        return tacoId;
    }

    public void setTacoId(int tacoId) {
        this.tacoId = tacoId;
    }

    public String getTacoShellType() {
        return tacoShellType;
    }

    public void setTacoShellType(String tacoShellType) {
        this.tacoShellType = tacoShellType;
    }

    public String getTacoFilling() {
        return tacoFilling;
    }

    public void setTacoFilling(String tacoFilling) {
        this.tacoFilling = tacoFilling;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Taco{" +
                "tacoId=" + tacoId +
                ", tacoShellType='" + tacoShellType + '\'' +
                ", tacoFilling='" + tacoFilling + '\'' +
                ", customer=" + customer +
                '}';
    }
}
