package lt.gerasimovas.fleetassets.repositories;

import lt.gerasimovas.fleetassets.entities.Sim;
import lt.gerasimovas.fleetassets.enumes.Operator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimRepository extends JpaRepository<Sim, Long> {
    Sim findByNumber(Integer number);

    Sim findByIccid(String iccid);

    Page<Sim> findByOperator(Operator operator, Pageable pageable);

}
