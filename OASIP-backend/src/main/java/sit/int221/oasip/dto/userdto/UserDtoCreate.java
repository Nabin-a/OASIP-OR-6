package sit.int221.oasip.dto.userdto;

import lombok.*;
import sit.int221.oasip.entities.Roles;
import sit.int221.oasip.validators.Name;
import sit.int221.oasip.validators.Role;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoCreate {

    @NotBlank
    @Name
    @Column(unique = true)
    @Size(max=100)
    private String name;

    @sit.int221.oasip.validators.Email
    @Column(unique = true)
    @NotBlank @Email
    @Size(max=50)
    private String email;

    @Size(max = 14, min = 8)
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Role(enumClass = Roles.class)
    private String role;

    public void setName(String name) {
        this.name = name.trim();
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }
}
