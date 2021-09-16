package ee.helmes.be.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class SavedSector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_id")
    private long registrationId;

    @Column(name = "sector_id")
    private long sectorId;

    public SavedSector(long registrationId, long sectorId) {
        this.registrationId = registrationId;
        this.sectorId = sectorId;
    }
}
