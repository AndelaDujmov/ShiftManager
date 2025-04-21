package org.example.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
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

    public BaseEntity() {

        this.creationTime = new Date();
        this.updateTime = new Date();
        this.isDeleted = false;
    }
}
