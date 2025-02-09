package org.example.domain.entities;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.enums.ShiftType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Getter
@Setter
public class Shift extends BaseEntity{

    @NotNull
    @Enumerated(EnumType.STRING)
    private ShiftType type;
    @NotNull
    @PastOrPresent
    private Date startDate;
    @NotNull
    @PastOrPresent
    private Date endDate;
}
