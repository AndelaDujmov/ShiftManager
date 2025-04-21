package org.example.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.domain.dto.request.UserDataRequest;
import org.example.domain.dto.response.UserDataResponse;
import org.example.services.UserManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "user")
@AllArgsConstructor
public class UserController {

    private UserManagementService userService;

    @GetMapping
    public ResponseEntity<List<UserDataResponse>> getUsers() {

        List<UserDataResponse> users = userService.findAll();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserDataResponse> createUser(@Valid @RequestBody UserDataRequest user) {

        UserDataResponse createdUser = userService.add(user);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDataResponse> updateUser(@PathVariable UUID id, @Valid @RequestBody UserDataRequest user) {

        UserDataResponse updatedUser = userService.update(user, id);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserDataResponse> deleteUser(@PathVariable UUID id) {

        UserDataResponse deletedUser = userService.deleteById(id);

        return new ResponseEntity<>(deletedUser, HttpStatus.OK);
    }
}
