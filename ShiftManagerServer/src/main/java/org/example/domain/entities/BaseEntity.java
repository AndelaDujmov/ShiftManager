package org.example.domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class BaseEntity {

    private UUID id;
    private Date creationTime;
    private Date updateTime;
    private boolean isDeleted;
}
