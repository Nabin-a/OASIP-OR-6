package sit.int221.oasip.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "catagory")
@Entity
public class Catagory {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "CatagoryName", nullable = false, length = 100)
    private String catagoryName;

    @Column(name = "Description", length = 500)
    private String description;

    @Column(name = "`Duration(min.)`", nullable = false)
    private Integer durationMin;

    public Integer getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(Integer durationMin) {
        this.durationMin = durationMin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}