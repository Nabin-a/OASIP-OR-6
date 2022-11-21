package sit.int221.oasip.dto.eventdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}