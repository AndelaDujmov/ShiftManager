package org.example.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftResponse {

    @NotEmpty(message = "The name field cant be empty or null")
    private String type;
    @NotNull(message = "Start time cannot be null")
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm")
    private Date startTime;
    @NotNull(message = "End time cannot be null")
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm")
    private Date endTime;
    @NotNull
    @PastOrPresent
    private Date creationTime;
    @NotNull
    @PastOrPresent
    private Date updateTime;
}
