package org.example.domain.dto.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.domain.enums.RoleName;

import java.util.Date;

@Data
public class UserDataResponse {

    @NotNull(message = "Username cannot be null")
    @Size(min = 3, max = 20)
    @Pattern(regexp = "[A-Za-z0-9]+", message = "Your username should not contain any special characters!")
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
    private String contactInfo;
    @NotNull(message = "Role cannot be null")
    private String role;
    @NotNull
    @PastOrPresent
    private Date creationTime;
    @NotNull
    @PastOrPresent
    private Date updateTime;
}
