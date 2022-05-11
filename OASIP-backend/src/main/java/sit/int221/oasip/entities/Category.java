package sit.int221.oasip.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Table(name = "category")
@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer eventCategoryId;

    @Column(name = "CategoryName", nullable = false, length = 100)
    private String categoryName;

    @Column(name = "Description", length = 500)
    private String description;

    @Column(name = "`Duration(min.)`", nullable = false)
    private Integer durationMin;

    @OneToMany(mappedBy = "category")
    private Set<Event> events = new LinkedHashSet<>();
}