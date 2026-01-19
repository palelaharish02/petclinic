package com.petclinic.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    @GetMapping("/dashboard")
    public String ownerDashboard() {
        return "Welcome OWNER";
    }
}
