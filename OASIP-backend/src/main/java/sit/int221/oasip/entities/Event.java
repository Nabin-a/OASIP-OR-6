package sit.int221.oasip.entities;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "event", indexes = {
        @Index(name = "ClientFirstsName_index", columnList = "bookingName"),
        @Index(name = "fk_Event_Catagory_idx", columnList = "Category_Id")
})
@Entity
public class Event {
    @Id
    @Column(name = "bookingId", nullable = false)
    private Integer id;

    @Column(name = "bookingName", nullable = false, length = 100)
    private String bookingName;

    @Column(name = "bookingEmail", nullable = false, length = 45)
    private String bookingEmail;

    @Column(name = "eventCatagoryName", length = 45)
    private String eventCategoryName;

    @Column(name = "StartTime", nullable = false)
    private Instant startTime;

    @Column(name = "Durations", nullable = false)
    private Integer durations;

    @Column(name = "Note", length = 500)
    private String note;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Category_Id", nullable = false)
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public String getEventCategoryName() {
        return eventCategoryName;
    }

    public Integer getDurations() {
        return durations;
    }

    public void setDurations(Integer durations) {
        this.durations = durations;
    }

    public void setEventCategoryName(String eventCatagoryName) {
        this.eventCategoryName = eventCatagoryName;
    }

    public String getBookingEmail() {
        return bookingEmail;
    }

    public void setBookingEmail(String bookingEmail) {
        this.bookingEmail = bookingEmail;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}