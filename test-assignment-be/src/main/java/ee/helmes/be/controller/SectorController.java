package ee.helmes.be.controller;

import ee.helmes.be.model.Sector;
import ee.helmes.be.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping("/sectors")
    public List<Sector> findSectors() {
        return sectorService.findAllSectors();
    }

}
