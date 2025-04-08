package org.example.services;

import org.example.domain.dto.request.ShiftRequest;
import org.example.domain.dto.response.ShiftResponse;
import org.example.domain.entities.Shift;

public interface ShiftService extends BaseService<Shift>{
    public ShiftResponse add(ShiftRequest object);
}
