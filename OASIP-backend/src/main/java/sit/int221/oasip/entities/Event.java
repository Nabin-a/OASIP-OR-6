package sit.int221.oasip.entities;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "event", indexes = {
        @Index(name = "ClientFirstsName_index", columnList = "bookName"),
        @Index(name = "fk_Event_Catagory_idx", columnList = "Catagory_Id")
})
@Entity
public class Event {
    @Id
    @Column(name = "bookId", nullable = false)
    private Integer id;

    @Column(name = "bookName", nullable = false, length = 100)
    private String bookName;

    @Column(name = "bookingEmail", nullable = false, length = 45)
    private String bookingEmail;

    @Column(name = "StartTime", nullable = false)
    private Instant startTime;

    @Column(name = "Note", length = 500)
    private String note;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Catagory_Id", nullable = false)
    private Catagory catagory;

    public Catagory getCatagory() {
        return catagory;
    }

    public void setCatagory(Catagory catagory) {
        this.catagory = catagory;
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

    public String getBookingEmail() {
        return bookingEmail;
    }

    public void setBookingEmail(String bookingEmail) {
        this.bookingEmail = bookingEmail;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}