package org.example.services;

import org.example.domain.dto.request.ShiftAssignmentRequest;
import org.example.domain.dto.response.ShiftAssignmentResponse;
import org.example.domain.entities.ShiftAssignment;

import java.util.UUID;

// TODO: change return types like shift assignment to shift assignment request/response

public interface ShiftAssignmentService extends BaseService<ShiftAssignmentResponse, ShiftAssignmentRequest> {

    public ShiftAssignmentResponse assignTo(UUID user);

}
