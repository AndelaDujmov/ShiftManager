package org.example.services.impl;

import lombok.AllArgsConstructor;
import org.example.domain.entities.ShiftAssignment;
import org.example.domain.entities.User;
import org.example.domain.exceptions.UserNotFoundException;
import org.example.repositories.ShiftAssignmentRepository;
import org.example.repositories.UserRepository;
import org.example.services.ShiftAssignmentService;
import org.example.utils.ExceptionMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ShiftAssignmentServiceImpl implements ShiftAssignmentService {

    private ShiftAssignmentRepository shiftAssignmentRepository;
    private UserRepository userRepository;

    @Override
    public ShiftAssignment assignTo(UUID user) {

        Optional<User> foundUser = userRepository.findById(user);

        if (foundUser.isPresent()){
            return null;
        }
        else
            throw new UserNotFoundException(ExceptionMessages.USER_NOT_FOUND);
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
