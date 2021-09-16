package ee.helmes.be.service;

import ee.helmes.be.dto.RegistrationDTO;
import ee.helmes.be.model.Registration;
import ee.helmes.be.model.SavedSector;
import ee.helmes.be.model.Sector;
import ee.helmes.be.repository.RegistrationRepository;
import ee.helmes.be.repository.SavedSectorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private SavedSectorRepository savedSectorRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<RegistrationDTO> findAllRegistrations() {
        return this.registrationRepository.findAll().stream().map(r -> this.modelMapper.map(r, RegistrationDTO.class)).collect(Collectors.toList());
    }

    public RegistrationDTO getRegistrationById(long regId) {
        Optional<Registration> optionalRegistration = this.registrationRepository.findById(regId);
        return optionalRegistration.map(registration -> modelMapper.map(registration, RegistrationDTO.class)).orElse(null);
    }

    public RegistrationDTO saveRegistration(RegistrationDTO registrationDTO) {
        Registration savedRegistration = this.registrationRepository.save(modelMapper.map(registrationDTO, Registration.class));
        for (Sector sector : savedRegistration.getSectors()) {
            this.savedSectorRepository.save(new SavedSector(savedRegistration.getId(), sector.getId()));
        }
        return this.modelMapper.map(savedRegistration, RegistrationDTO.class);
    }

    public RegistrationDTO updateRegistration(RegistrationDTO registrationDTO) {
        Optional<Registration> registrationFromDbOptional = this.registrationRepository.findById(registrationDTO.getId());
        if (registrationFromDbOptional.isPresent()) {
            registrationFromDbOptional.get().setName(registrationDTO.getName());
            registrationFromDbOptional.get().setTerms(registrationDTO.isTerms());
            this.savedSectorRepository.deleteByRegistrationId(registrationDTO.getId());
            for (Sector sector : registrationDTO.getSectors()) {
                this.savedSectorRepository.save(new SavedSector(registrationFromDbOptional.get().getId(), sector.getId()));
            }
            registrationFromDbOptional.get().setSectors(registrationDTO.getSectors());
            return this.modelMapper.map(registrationFromDbOptional.get(), RegistrationDTO.class);
        }
        return null;
    }
}
