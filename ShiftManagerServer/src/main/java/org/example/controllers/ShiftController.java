package org.example.controllers;

import org.example.domain.entities.Shift;
import org.example.services.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// TODO: change return types like shift assignment to corresponding response type

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

    @PutMapping("/update")
    public void updateShift(@RequestBody Shift shift) {

        return; // TODO: create update method in service and repo
    }

    @DeleteMapping("/delete/{id}")
    public UUID deleteShift(@RequestParam UUID id){

        return shiftService.deleteById(id);
    }
}
