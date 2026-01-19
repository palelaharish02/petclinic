package com.petclinic.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vet")
public class VetController {

    @GetMapping("/dashboard")
    public String vetDashboard() {
        return "Welcome VET";
    }
}
