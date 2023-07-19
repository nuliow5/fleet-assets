package lt.gerasimovas.fleetassets.services;

import org.springframework.data.domain.Pageable;

import java.util.List;

/*
D - DTO
E - Entity
 */

public interface Crude<D, E> {
    public List<D> getAllDto(Pageable pageable);

    public D getById(Long id);

    public D create(D d);

    public D update(D d);

    public void deleteById(Long id);




}
