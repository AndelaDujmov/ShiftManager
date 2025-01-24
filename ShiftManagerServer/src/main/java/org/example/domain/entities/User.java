package org.example.domain.entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.example.domain.enums.RoleName;

@Getter
@Setter
public class User extends BaseEntity {

    @NonNull
    private String username;
    @NonNull
    private String password;
    private String contactInfo;
    @NonNull
    private RoleName role;
}
