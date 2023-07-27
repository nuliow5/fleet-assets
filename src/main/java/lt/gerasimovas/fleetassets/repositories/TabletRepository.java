package lt.gerasimovas.fleetassets.repositories;

import lt.gerasimovas.fleetassets.entities.Tablet;
import lt.gerasimovas.fleetassets.enumes.ChargerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TabletRepository extends JpaRepository<Tablet, Long> {
    Page<Tablet> findByChargerType(ChargerType chargerType, Pageable pageable);
}
