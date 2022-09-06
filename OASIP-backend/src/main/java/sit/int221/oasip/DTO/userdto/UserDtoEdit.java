package sit.int221.oasip.dto.userdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.int221.oasip.entities.Roles;
import sit.int221.oasip.validators.Role;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoEdit {
    private Integer userId;
    @NotBlank
    @Column(unique = true)
    private String name;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Role(enumClass = Roles.class)
    private String role;

    public void setName(String name) {
        this.name = name.trim();
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }
}
