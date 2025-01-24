package org.example.domain.entities;

import lombok.Getter;
import lombok.Setter;
import org.example.domain.enums.ShiftType;

import java.util.Date;

@Getter
@Setter
public class Shift extends BaseEntity{

    private ShiftType type;
    private Date startDate;
    private Date endDate;
}
