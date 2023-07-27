package lt.gerasimovas.fleetassets.services;

import lombok.AllArgsConstructor;
import lt.gerasimovas.fleetassets.converters.TruckMapper;
import lt.gerasimovas.fleetassets.dto.TruckDTO;
import lt.gerasimovas.fleetassets.entities.Truck;
import lt.gerasimovas.fleetassets.enumes.WorkRegion;
import lt.gerasimovas.fleetassets.repositories.TruckRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
@AllArgsConstructor
public class TruckService implements Crude<TruckDTO, Truck, WorkRegion>{

    private TruckRepository truckRepository;
//    @Override
    public List<TruckDTO> getAllDto(Pageable pageable, WorkRegion workRegion) {
        if (workRegion != null){
            return TruckMapper.convertPageToDtoList(this.truckRepository.findByWorkRegion(workRegion, pageable));
        }
        return TruckMapper.fromEntitiesListToDtoList(this.truckRepository.findAll());
    }

    @Override
    public TruckDTO getById(Long id) {
        return TruckMapper.fromEntityToSimDto(this.truckRepository.findById(id).get());
    }

    @Override
    public TruckDTO create(TruckDTO truckDTO) {
        Truck truck = TruckMapper.fromDtoToSimEntity(truckDTO);
        this.truckRepository.save(truck);
        return truckDTO;
    }

    @Override
    public TruckDTO update(TruckDTO truckDTO) {
        Truck truckForUpdate = this.truckRepository.findById(truckDTO.getId()).get();
        if (truckDTO.getLicensePlate() != null){
            truckForUpdate.setLicensePlate(truckDTO.getLicensePlate());
        }

        if (truckDTO.getModel() != null){
            truckForUpdate.setModel(truckDTO.getModel());
        }

        if (truckDTO.getIsWork() != null){
            truckForUpdate.setIsWork(truckDTO.getIsWork());
        }

        if (truckDTO.getWorkRegion() != null){
            truckForUpdate.setWorkRegion(truckDTO.getWorkRegion());
        }

        this.truckRepository.save(truckForUpdate);

        return TruckMapper.fromEntityToSimDto(truckForUpdate);
    }

    @Override
    public void deleteById(Long id) {
        if (this.truckRepository.findById(id) != null){
            this.truckRepository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }

    }
}
