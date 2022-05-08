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
public class EventDtoList {
    private Integer id;
    private String bookingName;
    private Instant startTime;
    private Integer durations;
    private String categoryName;
    private Integer categoryDuration;
}
