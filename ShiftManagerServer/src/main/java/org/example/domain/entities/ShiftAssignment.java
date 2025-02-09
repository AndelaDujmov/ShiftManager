package org.example.domain.entities;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.enums.ShiftStatus;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Getter
@Setter
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
