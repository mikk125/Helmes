package ee.helmes.be.repository;

import ee.helmes.be.model.SavedSector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface SavedSectorRepository extends JpaRepository<SavedSector, Long> {

    @Transactional
    @Modifying
    @Query("delete from SavedSector ss where ss.registrationId = ?1")
    void deleteByRegistrationId(long registrationId);
}
