package org.example.domain.entities;

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

    @NotEmpty
    private User employee;
    @NotEmpty
    private Shift shift;
    @NotNull
    @PastOrPresent
    private Date shiftDate;
    @NotNull
    private ShiftStatus status;
}
