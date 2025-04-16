package org.example.controllers;

import org.example.domain.entities.ShiftAssignment;
import org.example.services.ShiftAssignmentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

// TODO: change return types like shift assignment to corresponding response type

@RestController
@RequestMapping("assign")
public class AssignShiftController {

    private ShiftAssignmentService shiftAssignmentService;

    @GetMapping("/add")
    public List<ShiftAssignment> getAssignments() {

        return shiftAssignmentService.findAll();
    }

    @PostMapping("/assign/{id}")
    public ShiftAssignment assignShift(@RequestParam UUID id) {

        return shiftAssignmentService.assignTo(id);
    }

    @PutMapping("/assign/{id}")
    public void updateShiftAssignment(@RequestParam UUID id) {

        return; // TODO: create update method in services and repositories
    }

    @DeleteMapping("/delete/{id}")
    public UUID deleteShift(@RequestParam UUID id) {

        return shiftAssignmentService.deleteById(id);
    }
}
