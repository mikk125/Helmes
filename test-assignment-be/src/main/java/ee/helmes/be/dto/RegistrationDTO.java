package ee.helmes.be.dto;

import ee.helmes.be.model.Sector;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class RegistrationDTO {

    private Long id;
    private String name;
    private boolean terms;
    public Set<Sector> sectors;

}
