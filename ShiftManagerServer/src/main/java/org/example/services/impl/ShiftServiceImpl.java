package org.example.services.impl;

import lombok.AllArgsConstructor;
import org.example.domain.dto.request.ShiftRequest;
import org.example.domain.dto.response.ShiftResponse;
import org.example.domain.entities.Shift;
import org.example.domain.entities.ShiftAssignment;
import org.example.domain.entities.User;
import org.example.domain.exceptions.ShiftCantBeNullException;
import org.example.domain.exceptions.ShiftNotFoundException;
import org.example.repositories.ShiftRepository;
import org.example.services.ShiftService;
import org.example.utils.ExceptionMessages;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ShiftServiceImpl implements ShiftService {

    private ShiftRepository shiftRepository;
    private ModelMapper modelMapper;

    @Override
    public ShiftResponse add(ShiftRequest object) {

        if (object == null || object.getStartTime() == null || object.getEndTime() == null || object.getType() == null)
            throw new ShiftNotFoundException(ExceptionMessages.SHIFT_CANNOT_BE_NULL);

        Shift shift = modelMapper.map(object, Shift.class);

        Shift save = shiftRepository.save(shift);

        return modelMapper.map(save, ShiftResponse.class);
    }

    @Override
    public ShiftResponse findById(UUID id) {
        Optional<Shift> shift = shiftRepository.findById(id);

        if (shift.isEmpty())
            throw new ShiftNotFoundException(ExceptionMessages.SHIFT_NOT_FOUND);

        return modelMapper.map(shift.get(), ShiftResponse.class);
    }

    @Override
    public List<ShiftResponse> findAll() {

        List<Shift> shifts = new ArrayList<>();

        shiftRepository.findAll().stream().filter(el -> !el.isDeleted()).forEach(shifts::add);

        return shifts.stream()
                .map(shift -> modelMapper.map(shift, ShiftResponse.class)).toList();
    }

    @Override
    public ShiftResponse deleteById(UUID id) {

        Optional<Shift> shift = shiftRepository.findById(id);

        if (shift.isEmpty())
            throw new ShiftNotFoundException(ExceptionMessages.SHIFT_NOT_FOUND);

        Shift shiftContent = shift.get();

        shiftContent.setDeleted(true);

        Shift response = shiftRepository.save(shiftContent);

        return modelMapper.map(response, ShiftResponse.class);
    }

    @Override
    public ShiftResponse update(ShiftRequest object, UUID id) {

        Shift shift = modelMapper.map(object, Shift.class);
        Optional<Shift> optionalShift = shiftRepository.findById(id);

        if (optionalShift.isEmpty())
            throw new ShiftCantBeNullException(ExceptionMessages.SHIFT_CANNOT_BE_NULL);

        Shift shiftToUpdate = optionalShift.get();
        shiftToUpdate.setStartTime(shift.getStartTime() != null ? shift.getStartTime() : shiftToUpdate.getStartTime());
        shiftToUpdate.setEndTime(shift.getEndTime() != null ? shift.getEndTime() : shiftToUpdate.getEndTime());
        shiftToUpdate.setUpdateTime(new Date());

        Shift updatedShift = shiftRepository.save(shiftToUpdate);

        return modelMapper.map(updatedShift, ShiftResponse.class);
    }


}
