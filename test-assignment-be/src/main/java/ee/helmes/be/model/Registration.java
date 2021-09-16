package ee.helmes.be.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean terms;
    @OneToMany
    @JoinTable(
            name="saved_sector",
            joinColumns = @JoinColumn( name="registration_id"),
            inverseJoinColumns = @JoinColumn( name="sector_id")
    )
    public Set<Sector> sectors;
}
