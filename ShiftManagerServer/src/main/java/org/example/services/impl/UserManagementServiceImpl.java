package org.example.services.impl;

import lombok.AllArgsConstructor;
import org.example.domain.dto.request.UserDataRequest;
import org.example.domain.dto.response.UserDataResponse;
import org.example.domain.entities.User;
import org.example.domain.enums.RoleName;
import org.example.domain.exceptions.ContactNameAlreadyInUseException;
import org.example.domain.exceptions.UserNotFoundException;
import org.example.domain.exceptions.UsernameAlreadyExistsException;
import org.example.repositories.UserRepository;
import org.example.services.UserManagementService;
import org.example.utils.ExceptionMessages;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class UserManagementServiceImpl implements UserManagementService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDataResponse add(UserDataRequest object) {

        if (object == null || object.getUsername() == null || object.getPassword() == null || object.getContactInfo() == null)
            throw new UserNotFoundException(ExceptionMessages.USER_CANNOT_BE_NULL);

        if (userRepository.existsByUsername(object.getUsername()))
            throw new UsernameAlreadyExistsException(ExceptionMessages.USERNAME_ALREADY_EXISTS);

        if (userRepository.existsByContactInfo(object.getContactInfo()))
            throw new ContactNameAlreadyInUseException(ExceptionMessages.CONTACT_NAME_ALREADY_IN_USE);

        User user = modelMapper.map(object, User.class);
        user.setRole(RoleName.EMPLOYEE);
        user.setPassword(passwordEncoder.encode(object.getPassword()));

        User savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserDataResponse.class);
    }

    @Override
    public UserDataResponse findById(UUID id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty())
            throw new UserNotFoundException(ExceptionMessages.USER_NOT_FOUND);

        return modelMapper.map(user.get(), UserDataResponse.class);
    }

    @Override
    public List<UserDataResponse> findAll() {

        List<User> users = new ArrayList<>();

        userRepository.findAll().stream().filter(user -> !user.isDeleted()).forEach(users::add);

        return users.stream().map(user -> modelMapper.map(user, UserDataResponse.class)).toList();
    }

    @Override
    public UserDataResponse deleteById(UUID id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty())
            throw new UserNotFoundException(ExceptionMessages.USER_NOT_FOUND);

        User foundUser = user.get();
        foundUser.setDeleted(true);
        User deletion = userRepository.save(foundUser);

        return modelMapper.map(deletion, UserDataResponse.class);
    }

    @Override
    public UserDataResponse update(UserDataRequest object, UUID id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty())
            throw new UserNotFoundException(ExceptionMessages.USER_NOT_FOUND);

        User userToUpdate = user.get();
        userToUpdate.setUsername(object.getUsername() != null ? object.getUsername() : userToUpdate.getUsername());
        userToUpdate.setPassword(object.getPassword() != null ? passwordEncoder.encode(object.getPassword()) : userToUpdate.getPassword());
        userToUpdate.setRole(RoleName.valueOf(object.getRole()) != null ? RoleName.valueOf(object.getRole()) : userToUpdate.getRole() );
        userToUpdate.setContactInfo(object.getContactInfo() != null ? object.getContactInfo() : userToUpdate.getContactInfo());
        userToUpdate.setUpdateTime(new Date());

        return modelMapper.map(userToUpdate, UserDataResponse.class);
    }
}
