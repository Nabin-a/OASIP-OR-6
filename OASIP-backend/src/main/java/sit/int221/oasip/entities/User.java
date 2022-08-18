package sit.int221.oasip.entities;

import javax.persistence.*;
import java.time.Instant;
import java.time.ZonedDateTime;

@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    private Integer userId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Lob
    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "createdOn", nullable = false)
    private ZonedDateTime createdOn;

    @Column(name = "updatedOn", nullable = false)
    private ZonedDateTime updatedOn;

    public ZonedDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(ZonedDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public ZonedDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(ZonedDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return userId;
    }

    public void setId(Integer id) {
        this.userId = id;
    }
}