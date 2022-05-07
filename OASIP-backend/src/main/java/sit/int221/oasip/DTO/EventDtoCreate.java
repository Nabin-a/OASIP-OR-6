package sit.int221.oasip.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class EventDtoCreate {
    private Integer id;
    private String bookingName;
    private String bookingEmail;
    private String category;
    private Instant startTime;
    private String note;
}
