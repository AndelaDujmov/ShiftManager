package org.example.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import org.example.domain.enums.ShiftType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shift extends BaseEntity{

    @NotNull(message = "Type cannot be null")
    @Enumerated(EnumType.STRING)
    private ShiftType type;
    @NotNull(message = "Start date cannot be null")
    @DateTimeFormat(pattern = "YYYY/MM/DD")
    private Date startDate;
    @NotNull(message = "End date cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    private Date endDate;
}
