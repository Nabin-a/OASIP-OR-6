package sit.int221.oasip.DTO.userdto;

import lombok.*;


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
    @NotBlank @Size(max=100)
    private String name;

    @NotBlank @Email
    @Size(max=50)
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Role role = Role.student;

    private ZonedDateTime createdOn;
    private ZonedDateTime updatedOn;

    public enum Role{
        student, admin, lecturer
    }

}
