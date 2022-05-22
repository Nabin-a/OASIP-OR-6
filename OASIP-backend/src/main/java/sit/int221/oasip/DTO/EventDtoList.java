package sit.int221.oasip.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class EventDtoList {
    private Integer id;
    private String bookingName;
    private ZonedDateTime startTime;
    private Integer durations;
    private String categoryName;

}