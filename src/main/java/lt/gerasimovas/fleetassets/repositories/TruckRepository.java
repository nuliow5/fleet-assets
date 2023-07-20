package lt.gerasimovas.fleetassets.repositories;

import lt.gerasimovas.fleetassets.entities.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckRepository extends JpaRepository<Truck, Long> {
    Truck findByLicensePlate(String licensePlate);
}
