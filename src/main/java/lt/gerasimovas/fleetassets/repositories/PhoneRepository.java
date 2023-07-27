package lt.gerasimovas.fleetassets.repositories;

import lt.gerasimovas.fleetassets.entities.Phone;
import lt.gerasimovas.fleetassets.enumes.ChargerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    Page<Phone> findByChargerType(ChargerType chargerType, Pageable pageable);
}
