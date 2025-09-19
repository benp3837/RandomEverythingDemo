package com.revature.controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public ResponseEntity<String> getGreeted(){
        return ResponseEntity.status(200).body("Hello");
        //Then show the shorter way
    }

    @PostMapping
    public ResponseEntity<String> sendGreeting(@RequestBody String greeting){
        return ResponseEntity.status(200).body("You said: " + greeting);
    }

    @GetMapping("/byOption/{option}")
    public ResponseEntity<?> greetByLanguage(@PathVariable("option") int option){

        switch(option){
            case 1: {
                return ResponseEntity.ok().body("Hola");
            }
            case 2: {
                return ResponseEntity.ok().body(110110100);
            }
            case 3: {
                return ResponseEntity.ok().body("Hej");
            }
            default: {
                return ResponseEntity.badRequest().body("no");
            }
        }

    }

}
