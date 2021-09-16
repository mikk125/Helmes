package ee.helmes.be.service;

import ee.helmes.be.config.ApplicationConfig;
import ee.helmes.be.dto.RegistrationDTO;
import ee.helmes.be.model.Registration;
import ee.helmes.be.model.Sector;
import ee.helmes.be.repository.RegistrationRepository;
import ee.helmes.be.repository.SavedSectorRepository;
import ee.helmes.be.repository.SectorRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.verification.VerificationMode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class RegistrationServiceTests {

    @Autowired
    private RegistrationService registrationService;

    @MockBean
    private RegistrationRepository registrationRepository;

    @MockBean
    private SavedSectorRepository savedSectorRepository;

    @Before
    public void init() {
        Registration registration = new Registration();
        registration.setId(1L);
        when(registrationRepository.findAll()).thenReturn(Collections.singletonList(registration));
    }

    @Test
    public void whenFindAllRegistrations_thenRetrievedIdIsCorrect() {
        List<RegistrationDTO> registrations = registrationService.findAllRegistrations();
        assertEquals(1, registrations.size());
        assertEquals(1L, (long) registrations.get(0).getId());
    }

    @Test
    public void getRegistrationById_returnOptionalEmpty_thenRetrievedNull() {
        when(registrationRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        RegistrationDTO registration = registrationService.getRegistrationById(1L);
        assertNull(registration);
    }

    @Test
    public void getRegistrationById_returnOptionalObject_thenRetrievedIdIsCorrect() {
        Registration registration = new Registration();
        registration.setId(1L);
        when(registrationRepository.findById(Mockito.any())).thenReturn(Optional.of(registration)) ;
        RegistrationDTO result = registrationService.getRegistrationById(1L);
        assertEquals(1L, (long) result.getId());
    }

    @Test
    public void saveRegistration_happyPath() {
        Sector s1 = new Sector();
        s1.setId(1);
        Sector s2 = new Sector();
        s2.setId(2);
        Registration registration = new Registration();
        registration.setId(1L);
        registration.setSectors(Set.of(s1, s2));
        when(registrationRepository.save(any(Registration.class))).thenReturn(registration) ;
        RegistrationDTO result = registrationService.saveRegistration(new RegistrationDTO());
        assertEquals(1L, (long) result.getId());
        verify(savedSectorRepository, times(registration.getSectors().size())).save(Mockito.any());
    }

    @Test
    public void updateRegistration_happyPath() {
        Sector s1 = new Sector();
        s1.setId(1);
        Sector s2 = new Sector();
        s2.setId(2);
        Registration registration = new Registration();
        registration.setId(1L);
        registration.setSectors(Set.of(s1, s2));
        when(registrationRepository.findById(Mockito.any())).thenReturn(Optional.of(registration));
        RegistrationDTO registrationDTO = new RegistrationDTO();
        registrationDTO.setId(registration.getId());
        registrationDTO.setSectors(registration.getSectors());
        RegistrationDTO result = registrationService.updateRegistration(registrationDTO);
        assertEquals(1L, (long) result.getId());
        verify(savedSectorRepository, times(1)).deleteByRegistrationId(Mockito.anyLong());
        verify(savedSectorRepository, times(registration.getSectors().size())).save(Mockito.any());
    }

    @Test
    public void updateRegistration_returnOptionalEmpty_thenRetrievedNull() {
        when(registrationRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        RegistrationDTO result = registrationService.updateRegistration(new RegistrationDTO());
        assertNull(result);
    }
}
