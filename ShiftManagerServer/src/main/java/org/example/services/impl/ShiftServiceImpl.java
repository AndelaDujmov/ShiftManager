package org.example.services.impl;

import org.example.domain.dto.request.ShiftRequest;
import org.example.domain.dto.response.ShiftResponse;
import org.example.domain.entities.Shift;
import org.example.domain.entities.ShiftAssignment;
import org.example.repositories.ShiftRepository;
import org.example.services.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShiftServiceImpl implements ShiftService {

    @Autowired
    private ShiftRepository shiftRepository;

    @Override
    public ShiftResponse add(ShiftRequest object) {

        return shiftRepository.save(object);
    }

    @Override
    public Shift findById(UUID id) {
        return null;
    }

    @Override
    public List<Shift> findAll() {

        List<Shift> shifts = new ArrayList<>();

        shiftRepository.findAll().forEach(shifts::add);

        return shifts;
    }

    @Override
    public UUID deleteById(UUID id) {
        return null;
    }
}
