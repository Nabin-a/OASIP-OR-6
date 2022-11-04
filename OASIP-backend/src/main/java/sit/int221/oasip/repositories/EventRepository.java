package sit.int221.oasip.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import sit.int221.oasip.entities.Event;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query(value = "select * from event e where e.bookingEmail = :bookingEmail order by e.startTime desc", nativeQuery = true)
    List<Event> findAllByBookingEmail(@Param("bookingEmail") String bookingEmail);

    @Query(value = "select e.* from event e join eventcategoryowner ec on e.category_id = ec.eventCategoryId where ec.userId = :userId", nativeQuery = true)
    List<Event> findAllByEventCategoryOwner(@Param("userId") Integer userId);

    @Query(value = "select e.* from event e \n" +
            "join user u on e.bookingEmail = u.email \n" +
            "where eventId = :eventId and u.email = :email", nativeQuery = true)
    Event findByBookingEmailAndId(@Param("eventId") Integer eventId, @Param("email") String email);

    @Query(value = "select e.* from event e join eventcategoryowner ec on e.category_id = ec.eventCategoryId where e.eventId = :eventId and ec.userId = :userId ", nativeQuery = true)
    Optional<Event> findEventByEventCategoryOwner(@Param("eventId") int eventId, @Param("userId") int userId);

}