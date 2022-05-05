package sit.int221.oasip.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class EventDtoDetail {
    private Integer id;
    private String bookingName;
    private String bookingEmail;
    private Instant startTime;
    private Integer durations;
    private String category;
    private String note;
}