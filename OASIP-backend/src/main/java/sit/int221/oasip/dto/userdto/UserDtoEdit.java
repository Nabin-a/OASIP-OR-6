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
<<<<<<< HEAD:OASIP-backend/src/main/java/sit/int221/oasip/dto/userdto/UserDtoEdit.java
=======
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
>>>>>>> 94535d093c48c6836842d69c4ffa416c79f36bc1:OASIP-backend/src/main/java/sit/int221/oasip/DTO/userdto/UserDtoEdit.java


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoEdit {
    private Integer userId;
<<<<<<< HEAD:OASIP-backend/src/main/java/sit/int221/oasip/dto/userdto/UserDtoEdit.java


    @Column(unique = true)
    private String name;

=======
    @NotBlank
    @Column(unique = true)
    private String name;

    @NotBlank
>>>>>>> 94535d093c48c6836842d69c4ffa416c79f36bc1:OASIP-backend/src/main/java/sit/int221/oasip/DTO/userdto/UserDtoEdit.java
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
