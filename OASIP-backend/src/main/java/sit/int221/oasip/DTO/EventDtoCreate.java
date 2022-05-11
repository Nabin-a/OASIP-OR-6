package sit.int221.oasip.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.int221.oasip.entities.Category;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class EventDtoCreate {
    private String bookingName;
    private String bookingEmail;
    private Instant startTime;
    private Integer durations;
    private String note;
    private Category category;
}


