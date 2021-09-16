package ee.helmes.be.service;

import ee.helmes.be.model.Sector;
import ee.helmes.be.repository.SectorRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SectorServiceTests {

    @Autowired
    private SectorService sectorService;

    @MockBean
    private SectorRepository sectorRepository;

    @Before
    public void init() {
        Sector parentSector = new Sector();
        parentSector.setId(1);
        parentSector.setText("1");
        Sector childSector = new Sector();
        childSector.setId(3);
        childSector.setText("2");
        childSector.setSubSectors(Collections.emptyList());
        parentSector.setSubSectors(Collections.singletonList(childSector));
        when(sectorRepository.findAll()).thenReturn(Collections.singletonList(parentSector));
    }

    @Test
    public void whenGetAllSectors_thenRetrievedIdsAreCorrect() {
        List<Sector> sectors = sectorService.findAllSectors();
        assertEquals(2, sectors.size());
        assertEquals(1, sectors.get(0).getId());
        assertEquals(1, sectors.get(0).getSubSectors().size());
        assertEquals(sectors.get(1).getId(), sectors.get(0).getSubSectors().get(0).getId());
    }
}