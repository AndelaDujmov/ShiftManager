package org.example.controllers;

import org.example.domain.entities.Shift;
import org.example.services.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "shift")
public class ShiftController {

    @Autowired
    private ShiftService shiftService;

    @GetMapping
    public List<Shift> index() {

        return shiftService.findAll();
    }

    @PostMapping("/add")
    public Shift createShift(@RequestBody Shift shift) {

        return shiftService.add(shift);
    }
}
