package lt.gerasimovas.fleetassets.repositories;

import lt.gerasimovas.fleetassets.entities.Truck;
import lt.gerasimovas.fleetassets.enumes.WorkRegion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckRepository extends JpaRepository<Truck, Long> {
    Truck findByLicensePlate(String licensePlate);

    Page<Truck> findByWorkRegion(WorkRegion workRegion, Pageable pageable);
}
