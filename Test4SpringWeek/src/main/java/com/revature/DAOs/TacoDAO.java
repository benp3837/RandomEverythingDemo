package com.revature.DAOs;

import com.revature.models.Taco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoDAO extends JpaRepository<Taco, Integer> {

    //JPA you so cool... all the basic CRUD is inherited already

    //property expressions for more specific CRUD ops that JPA hasn't defined

}
