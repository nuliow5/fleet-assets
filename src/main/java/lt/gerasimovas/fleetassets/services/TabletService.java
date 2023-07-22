package lt.gerasimovas.fleetassets.services;

import lombok.AllArgsConstructor;

import lt.gerasimovas.fleetassets.converters.TabletMapper;
import lt.gerasimovas.fleetassets.dto.TabletDTO;
import lt.gerasimovas.fleetassets.entities.Sim;
import lt.gerasimovas.fleetassets.entities.Tablet;
import lt.gerasimovas.fleetassets.entities.Truck;
import lt.gerasimovas.fleetassets.repositories.SimRepository;
import lt.gerasimovas.fleetassets.repositories.TabletRepository;
import lt.gerasimovas.fleetassets.repositories.TruckRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TabletService implements Crude<TabletDTO, Tablet> {
    private TabletRepository tabletRepository;
    private SimRepository simRepository;
    private TruckRepository truckRepository;

    @Override
    public List<TabletDTO> getAllDto(Pageable pageable) {
        if (pageable != null) {
            return TabletMapper.convertPageToDtoList(this.tabletRepository.findAll(pageable));
        }
        return TabletMapper.fromEntitiesListToDtoList(this.tabletRepository.findAll());
    }

    @Override
    public TabletDTO getById(Long id) {
        return TabletMapper.fromEntityToDto(this.tabletRepository.findById(id).get());
    }

    @Override
    public TabletDTO create(TabletDTO tabletDTO) {
        Tablet tablet = TabletMapper.fromDtoToEntity(tabletDTO);
        this.tabletRepository.save(tablet);
        return tabletDTO;
    }

        @Override
    public TabletDTO update(TabletDTO tabletDTO) throws NoSuchFieldException {
        Tablet tabletForUpdate = this.tabletRepository.findById(tabletDTO.getId()).get();

        if (tabletDTO.getModel() != null) {
            tabletForUpdate.setModel(tabletDTO.getModel());
        }

        if (tabletDTO.getImei() != null) {
            tabletForUpdate.setImei(tabletDTO.getImei());
        }

        if (tabletDTO.getNumber() != null) {
            tabletForUpdate.setNumber(tabletDTO.getNumber());
        }

        if (tabletDTO.getOrderNumber() != null) {
            tabletForUpdate.setOrderNumber(tabletDTO.getOrderNumber());
        }

        if (tabletDTO.getSimId() != null) {
            Optional<Sim> sim = this.simRepository.findById(tabletDTO.getSimId());
            if (!sim.isEmpty()) {
                tabletForUpdate.setSim(sim.get());
            } else {
                throw new NoSuchFieldException("Sim by ID doesnt exist");
            }
        } else if (tabletDTO.getSimNumber() != null) {
            Sim sim = this.simRepository.findByNumber(tabletDTO.getSimNumber());
            if (sim != null) {
                tabletForUpdate.setSim(sim);
            } else {
                throw new NoSuchFieldException("Sim by SIM NUMBER doesnt exist");
            }
        }

        if (tabletDTO.getTruckId() != null) {
            Optional<Truck> truck = this.truckRepository.findById(tabletDTO.getTruckId());
            if (!truck.isEmpty()) {
               tabletForUpdate.setTruck(truck.get());
            } else {
                throw new NoSuchFieldException("Truck by ID doesnt exist");
            }
        } else if (tabletDTO.getTruckLicensePlate() != null) {
            Truck truck = this.truckRepository.findByLicensePlate(tabletDTO.getTruckLicensePlate());
            if (truck != null){
                tabletForUpdate.setTruck(truck);
            } else {
                throw new NoSuchFieldException("Truck by PLATE NUMBER doesnt exist");
            }
        }

        this.tabletRepository.save(tabletForUpdate);

        return TabletMapper.fromEntityToDto(tabletForUpdate);
    }

//    @Override
//    public TabletDTO update(TabletDTO tabletDTO) {
//        Tablet tabletForUpdate = tabletRepository.findById(tabletDTO.getId()).orElseThrow(()  -> new NoSuchElementException());
//        tabletForUpdate.setModel(tabletDTO.getModel());
//        tabletForUpdate.setImei(tabletDTO.getImei());
//        tabletForUpdate.setNumber(tabletDTO.getNumber());
//        tabletForUpdate.setOrderNumber(tabletDTO.getOrderNumber());
//        tabletForUpdate.setSim(this.simRepository.findById(tabletDTO.getSimId()).get());
//        tabletForUpdate.setTruck(this.truckRepository.findById(tabletDTO.getTruckId()).get());
//        tabletForUpdate.setDateOfPurchase(tabletDTO.getDateOfPurchase());
//        tabletForUpdate.setChargerType(tabletDTO.getChargerType());
//
//        this.tabletRepository.save(tabletForUpdate);
//
//        return TabletMapper.fromEntityToDto(tabletForUpdate);
//    }

    @Override
    public void deleteById(Long id) {
        if (this.tabletRepository.findById(id) != null) {
            this.tabletRepository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }
    }
}
