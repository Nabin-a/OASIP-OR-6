package sit.int221.oasip.DTO;

import lombok.*;

import javax.validation.constraints.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class EventDtoCreate {
    @NotBlank(message = "name must not be blank") @Size(max = 100, message = "size must between 1 - 100")
    private String bookingName;

    @NotBlank @Email @Size(max = 45)
    private String bookingEmail;

    @Future(message = "must be future Date time")
    @NotNull
    private ZonedDateTime startTime;

    private Integer durations;

    @Size(max = 500)
    private String note;

    @NotNull
    private Integer eventCategoryId;
}
