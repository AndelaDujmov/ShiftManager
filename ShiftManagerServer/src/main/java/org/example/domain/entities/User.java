package org.example.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.domain.enums.RoleName;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users")
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
    @Pattern(
            regexp = "^\\d+$",
            message = "Your contact info should contain only numbers!"
    )
    private String contactInfo;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleName role;
}
