package org.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "shift")
public class ShiftController {

    @GetMapping
    public String index() {

        return "Hola";
    }
}
