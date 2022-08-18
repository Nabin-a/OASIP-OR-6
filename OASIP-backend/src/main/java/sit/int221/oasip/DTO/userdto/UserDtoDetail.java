package sit.int221.oasip.DTO.userdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoDetail {
    private Integer userId;
    private String name;
    private String email;
    private String role;
    private ZonedDateTime createOn;
    private ZonedDateTime updateOn;

}
