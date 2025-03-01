package org.example.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.domain.enums.ShiftStatus;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ShiftAssignment extends BaseEntity{

    @ManyToOne
    @JoinColumn(
            name = "employeeId",
            referencedColumnName = "id"
    )
    @NotEmpty
    private User employee;
    @ManyToOne
    @JoinColumn(
            name = "shiftId",
            referencedColumnName = "id"
    )
    @NotEmpty
    private Shift shift;
    @NotNull
    @PastOrPresent
    private Date shiftDate;
    @NotNull
    @Enumerated(EnumType.STRING)
    private ShiftStatus status;
}
