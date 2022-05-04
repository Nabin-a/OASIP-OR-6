package sit.int221.oasip.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import sit.int221.oasip.entities.Event;

import java.util.Date;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
}