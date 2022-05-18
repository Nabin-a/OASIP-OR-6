package sit.int221.oasip.DTO;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class EventDtoCreate {
    @NotBlank(message = "name must not be blank") @Max(100)
    private String bookingName;

    @NotBlank @Max(45)
    private String bookingEmail;

    @NotBlank
    private ZonedDateTime startTime;
    private Integer durations;

    @Max(value = 500, message = "note must be between 0 and 500")
    private String note;
    private Integer eventCategoryId;
}
