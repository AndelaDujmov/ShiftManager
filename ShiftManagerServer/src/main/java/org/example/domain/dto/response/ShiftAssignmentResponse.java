package org.example.domain.dto.response;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftAssignmentResponse {

    @NotEmpty(message = "User cannot be null or empty")
    private UUID employee;
    @NotEmpty(message = "Shift cannot be null of empty")
    private UUID shift;
    @NotNull(message = "Shift date cannot be null or empty")
    private Date shiftDate;
    @NotNull(message = "Shift status cannot be null")
    private String status;
    @NotNull
    @PastOrPresent
    private Date creationTime;
    @NotNull
    @PastOrPresent
    private Date updateTime;
}
