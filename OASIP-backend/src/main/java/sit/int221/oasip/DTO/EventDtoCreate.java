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
    private Instant startTime;
    private String note;
    private String categoryId;
<<<<<<< HEAD
}
=======
}
>>>>>>> b034ef11eb27b5c569baa8bb216076e23abd660d
