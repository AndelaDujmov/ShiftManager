package org.example.services;

import org.example.domain.entities.ShiftAssignment;

import java.util.UUID;

// TODO: change return types like shift assignment to shift assignment request/response

public interface ShiftAssignmentService extends BaseService<ShiftAssignment> {

    public ShiftAssignment assignTo(UUID user);
}
