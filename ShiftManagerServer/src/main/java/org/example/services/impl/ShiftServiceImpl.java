package org.example.services.impl;

import lombok.AllArgsConstructor;
import org.example.domain.dto.request.ShiftRequest;
import org.example.domain.dto.response.ShiftResponse;
import org.example.domain.entities.Shift;
import org.example.domain.entities.ShiftAssignment;
import org.example.domain.exceptions.ShiftNotFoundException;
import org.example.repositories.ShiftRepository;
import org.example.services.ShiftService;
import org.example.utils.ExceptionMessages;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ShiftServiceImpl implements ShiftService {

    private ShiftRepository shiftRepository;
    private ModelMapper modelMapper;

    @Override
    public ShiftResponse add(ShiftRequest object) {
        if (object == null)
            throw new ShiftNotFoundException(ExceptionMessages.SHIFT_CANNOT_BE_NULL);

        return modelMapper.map(object, ShiftResponse.class);
    }

    @Override
    public Shift add(Shift object) {
        return null;
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
