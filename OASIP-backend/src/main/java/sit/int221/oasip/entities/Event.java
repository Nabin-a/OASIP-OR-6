package sit.int221.oasip.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Table(name = "event", indexes = {
        @Index(name = "ClientFirstsName_index", columnList = "bookingName"),
        @Index(name = "fk_Event_Catagory_idx", columnList = "Category_Id")
})
@Entity
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer eventId;

    @Column(name = "bookingName", length = 100)
    private String bookingName;

    @Column(name = "bookingEmail", length = 45)
    private String bookingEmail;

<<<<<<< HEAD
    @Future
    @Column(name = "StartTime", nullable = false)
=======
    @Column(name = "startTime", nullable = false)
>>>>>>> e995019c9583be5cd38629c230db2de8a363ca6d
    private ZonedDateTime startTime;

    @Column(name = "Durations", nullable = false)
    private Integer durations;

    @Column(name = "Note", length = 500)
    private String note;

    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "Category_Id", nullable = false)
    private Category category;
}
