package org.example.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import org.example.domain.enums.ShiftStatus;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class ShiftAssignment extends BaseEntity{

    @ManyToOne
    @JoinColumn(
            name = "employeeId",
            referencedColumnName = "id"
    )
    @NotEmpty(message = "User cannot be null or empty")
    private User employee;
    @ManyToOne
    @JoinColumn(
            name = "shiftId",
            referencedColumnName = "id"
    )
    @NotEmpty(message = "Shift cannot be null of empty")
    private Shift shift;
    @NotNull(message = "Shift date cannot be null or empty")
    private Date shiftDate;
    @NotNull(message = "Shift status cannot be null")
    @Enumerated(EnumType.STRING)
    private ShiftStatus status;

}
