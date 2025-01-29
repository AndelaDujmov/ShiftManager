package org.example.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class BaseEntity {

    @NotEmpty
    private UUID id;
    @NotNull
    @PastOrPresent
    private Date creationTime;
    @NotNull
    @PastOrPresent
    private Date updateTime;
    @NotNull
    @AssertFalse(message = "isDeleted should be false")
    private boolean isDeleted;
}
