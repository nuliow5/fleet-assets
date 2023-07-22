package lt.gerasimovas.fleetassets.repositories;

import lt.gerasimovas.fleetassets.entities.Sim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimRepository extends JpaRepository<Sim, Long> {
    Sim findByNumber(Integer number);

}
