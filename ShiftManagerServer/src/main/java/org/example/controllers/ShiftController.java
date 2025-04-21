package org.example.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.domain.dto.request.ShiftRequest;
import org.example.domain.dto.response.ShiftResponse;
import org.example.domain.entities.Shift;
import org.example.services.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(path = "shift")
@AllArgsConstructor
public class ShiftController {

    private ShiftService shiftService;

    @GetMapping
    public ResponseEntity<List<ShiftResponse>> index() {

        List<ShiftResponse> shifts = shiftService.findAll();

        return new ResponseEntity<>(shifts, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ShiftResponse> createShift(@Valid @RequestBody ShiftRequest shift) {

       ShiftResponse shiftResponse = shiftService.add(shift);

       return new ResponseEntity<>(shiftResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ShiftResponse> updateShift(@PathVariable UUID id, @Valid @RequestBody ShiftRequest shift) {

        ShiftResponse updated = shiftService.update(shift, id);

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ShiftResponse> deleteShift(@PathVariable UUID id){

        ShiftResponse deleted = shiftService.deleteById(id);

        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
