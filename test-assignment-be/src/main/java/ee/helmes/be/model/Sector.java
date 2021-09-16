package ee.helmes.be.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Sector {

    @Id
    private long id;
    private int depth;
    private String text;
    @Column(name = "parent_sector_id")
    private Integer parentSectorId;

    @OneToMany(mappedBy = "parent")
    private List<Sector> subSectors;

    @JsonIgnore
    @JoinColumn(name = "parent_sector_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Sector parent;
}
