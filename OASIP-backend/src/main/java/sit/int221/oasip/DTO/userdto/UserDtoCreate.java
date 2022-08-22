package sit.int221.oasip.dto.userdto;

import lombok.*;
import sit.int221.oasip.entities.Roles;
import sit.int221.oasip.validators.Name;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;

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


    @Enumerated(value = EnumType.STRING)
    private Roles role;

    private ZonedDateTime createdOn;
    private ZonedDateTime updatedOn;

}
