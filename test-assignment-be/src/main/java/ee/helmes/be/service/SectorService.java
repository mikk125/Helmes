package ee.helmes.be.service;

import ee.helmes.be.model.Sector;
import ee.helmes.be.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    public List<Sector> getAllSectors() {
        return this.getSectors(this.sectorRepository.findAll().stream().filter(s -> s.getParent() == null).collect(Collectors.toList()));
    }

    private List<Sector> getSectors(List<Sector> sectors) {
        List<Sector> result = new ArrayList<>();
        sectors.sort(Comparator.comparing(Sector::getText));
        for (Sector sector : sectors) {
            result.add(sector);
            result.addAll(this.getSectors(sector.getSubSectors()));
        }

        return result;
    }
}
