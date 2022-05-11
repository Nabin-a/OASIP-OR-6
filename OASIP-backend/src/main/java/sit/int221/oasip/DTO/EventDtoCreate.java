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
<<<<<<< HEAD
    private Category categoryId;
}


=======
    private Integer eventCategoryId;
}
>>>>>>> 297c06ba9a1d45f92586aa0211ab0381561031a4
