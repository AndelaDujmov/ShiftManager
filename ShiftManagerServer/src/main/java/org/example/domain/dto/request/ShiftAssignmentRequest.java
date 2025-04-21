package org.example.domain.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.entities.Shift;
import org.example.domain.entities.User;
import org.example.domain.enums.ShiftStatus;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShiftAssignmentRequest {

    @NotEmpty(message = "User cannot be null or empty")
    private UUID employee;
    @NotEmpty(message = "Shift cannot be null of empty")
    private UUID shift;
    @NotNull(message = "Shift date cannot be null or empty")
    private Date shiftDate;
    @NotNull(message = "Shift status cannot be null")
    private String status;
}
