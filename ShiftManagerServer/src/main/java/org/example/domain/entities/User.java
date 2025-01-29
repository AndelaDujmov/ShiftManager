package org.example.domain.entities;

import lombok.Getter;
import lombok.Setter;
import org.example.domain.enums.RoleName;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class User extends BaseEntity {

    @NotNull
    @Size(min = 3, max = 20)
    @Pattern(regexp = "[A-Za-z0-9]+", message = "Your username should not contain any special characters!")
    private String username;
    @NotNull
    @Size(min = 8, max = 20)
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\",./<>?]).+$",
            message = "Your password should contain at least one uppercase letter, one lowercase, number and a special character!"
    )
    private String password;
    @NotNull
    @Size(min = 8, max = 20)
    private String contactInfo;
    @NotNull
    private RoleName role;
}
