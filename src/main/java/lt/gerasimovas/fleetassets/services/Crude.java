package lt.gerasimovas.fleetassets.services;

import org.springframework.data.domain.Pageable;

import java.util.List;

/*
D - DTO
E - Entity
 */

public interface Crude<D, E, T> {
    public List<D> getAllDto(Pageable pageable, T filterValue);

    public D getById(Long id);

    public D create(D d);

    public D update(D d) throws NoSuchFieldException;

    public void deleteById(Long id);

}
