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


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoEdit {
    private Integer userId;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Role(enumClass = Roles.class)
    private String role;
}
