package org.example.services.impl;

import org.example.domain.dto.request.ShiftAssignmentRequest;
import org.example.domain.dto.response.ShiftAssignmentResponse;
import org.example.domain.entities.ShiftAssignment;
import org.example.domain.entities.User;
import org.example.domain.exceptions.UserNotFoundException;
import org.example.repositories.ShiftAssignmentRepository;
import org.example.repositories.UserRepository;
import org.example.services.ShiftAssignmentService;
import org.example.utils.ExceptionMessages;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShiftAssignmentServiceImpl implements ShiftAssignmentService {

    private ShiftAssignmentRepository shiftAssignmentRepository;
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public ShiftAssignmentServiceImpl(ShiftAssignmentRepository shiftAssignmentRepository, UserRepository userRepository) {
        this.shiftAssignmentRepository = shiftAssignmentRepository;
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();

        this.modelMapper.addMappings(new PropertyMap<ShiftAssignmentRequest, ShiftAssignment>() {

            @Override
            protected void configure() {
                skip(destination.getId());
                map().getEmployee().setId(source.getEmployee());
                map().getShift().setId(source.getShift());
            }
        });
    }

    @Override
    public ShiftAssignmentResponse assignTo(UUID user) {

        Optional<User> foundUser = userRepository.findById(user);

        if (foundUser.isEmpty()){
            throw new UserNotFoundException(ExceptionMessages.USER_NOT_FOUND);
        }

        return null;

    }

    @Override
    public ShiftAssignmentResponse add(ShiftAssignmentRequest object) {

        ShiftAssignment saved = shiftAssignmentRepository.save(modelMapper.map(object, ShiftAssignment.class));
        return null;
    }

    @Override
    public ShiftAssignmentResponse findById(UUID id) {
        return null;
    }

    @Override
    public List<ShiftAssignmentResponse> findAll() {

        List<ShiftAssignment> assignments = new ArrayList<>();

        shiftAssignmentRepository.findAll().forEach(assignments::add);

        return null;
    }

    @Override
    public ShiftAssignmentResponse deleteById(UUID id) {
        return null;
    }

    @Override
    public ShiftAssignmentResponse update(ShiftAssignmentRequest object, UUID id) {
        return null;
    }
}
