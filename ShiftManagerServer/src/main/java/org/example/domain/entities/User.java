package org.example.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.domain.enums.RoleName;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

    @NotNull(message = "Username cannot be null")
    @Size(min = 3, max = 20)
    @Pattern(regexp = "[A-Za-z0-9]+", message = "Your username should not contain any special characters!")
    @Column(unique = true)
    private String username;
    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 20)
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\",./<>?]).+$",
            message = "Your password should contain at least one uppercase letter, one lowercase, number and a special character!"
    )
    private String password;
    @NotNull(message = "Contact info cannot be null")
    @Size(min = 8, max = 20)
    @Pattern(
            regexp = "^\\d+$",
            message = "Your contact info should contain only numbers!"
    )
    @Column(unique = true)
    private String contactInfo;
    @NotNull(message = "Role cannot be null")
    @Enumerated(EnumType.STRING)
    private RoleName role;
}
