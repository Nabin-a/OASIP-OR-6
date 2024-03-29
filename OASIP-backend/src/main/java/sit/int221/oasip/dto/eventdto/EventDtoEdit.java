package sit.int221.oasip.dto.eventdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDtoEdit {
    @NotNull(message = "Start time must not be null")
    @Future
    private Instant startTime;

    @Size(max = 500)
    private String note;


}
