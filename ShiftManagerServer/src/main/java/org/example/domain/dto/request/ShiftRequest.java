package org.example.domain.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.example.domain.enums.ShiftType;

public class ShiftRequest {

    @Enumerated(EnumType.STRING)
    private ShiftType type;
}
