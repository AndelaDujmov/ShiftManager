package org.example.services.impl;

import org.example.domain.entities.ShiftAssignment;
import org.example.repositories.ShiftAssignmentRepository;
import org.example.services.ShiftAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShiftAssignmentServiceImpl implements ShiftAssignmentService {

    @Autowired
    private ShiftAssignmentRepository shiftAssignmentRepository;

    @Override
    public ShiftAssignment assignTo(UUID user) {
        return null;
    }

    @Override
    public ShiftAssignment add(ShiftAssignment object) {

        return shiftAssignmentRepository.save(object);
    }

    @Override
    public ShiftAssignment findById(UUID id) {
        return null;
    }

    @Override
    public List<ShiftAssignment> findAll() {

        List<ShiftAssignment> assignments = new ArrayList<>();

        shiftAssignmentRepository.findAll().forEach(assignments::add);

        return assignments;
    }

    @Override
    public UUID deleteById(UUID id) {
        return null;
    }
}
