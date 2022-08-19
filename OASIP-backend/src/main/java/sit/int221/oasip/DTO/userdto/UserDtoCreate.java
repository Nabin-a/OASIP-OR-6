package sit.int221.oasip.DTO.userdto;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;


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
    @Value("${role: student}")
    private String role;
    private ZonedDateTime createdOn;
    private ZonedDateTime updatedOn;
}
