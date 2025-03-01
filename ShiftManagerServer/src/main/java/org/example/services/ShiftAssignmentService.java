package org.example.services;

import org.example.domain.entities.ShiftAssignment;

import java.util.UUID;

public interface ShiftAssignmentService extends BaseService<ShiftAssignment> {

    public ShiftAssignment assignTo(UUID user);
}
