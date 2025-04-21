package org.example.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.domain.enums.ShiftType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

// TODO check if i can instead of start and end date write start and end hours
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shift extends BaseEntity {

    @NotNull(message = "Type cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private ShiftType type;

    @NotNull(message = "Start time cannot be null")
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm")
    private Date startTime;

    @NotNull(message = "End time cannot be null")
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm")
    private Date endTime;
}
