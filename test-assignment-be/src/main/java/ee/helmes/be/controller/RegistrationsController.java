package ee.helmes.be.controller;

import ee.helmes.be.dto.RegistrationDTO;
import ee.helmes.be.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/registrations")
public class RegistrationsController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public List<RegistrationDTO> findRegistrations() {
        return this.registrationService.findAllRegistrations();
    }

    @GetMapping("/{id}")
    public RegistrationDTO getRegistrationById(@PathVariable("id") long id) {
        return this.registrationService.getRegistrationById(id);
    }

    @PostMapping("/new")
    public RegistrationDTO saveRegistration(@RequestBody RegistrationDTO newRegistration) {
        return registrationService.saveRegistration(newRegistration);
    }

    @PutMapping("/update")
    public RegistrationDTO updateRegistration(@RequestBody RegistrationDTO updateRegistration) {
        return registrationService.updateRegistration(updateRegistration);
    }


}
