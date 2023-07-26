package lt.gerasimovas.fleetassets.repositories;

import lt.gerasimovas.fleetassets.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
