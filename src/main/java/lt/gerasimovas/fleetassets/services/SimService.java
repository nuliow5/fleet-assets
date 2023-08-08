package lt.gerasimovas.fleetassets.services;

import lombok.AllArgsConstructor;
import lt.gerasimovas.fleetassets.converters.SimMapper;
import lt.gerasimovas.fleetassets.dto.SimDTO;
import lt.gerasimovas.fleetassets.entities.Sim;
import lt.gerasimovas.fleetassets.entities.Truck;
import lt.gerasimovas.fleetassets.enumes.Operator;
import lt.gerasimovas.fleetassets.repositories.SimRepository;
import lt.gerasimovas.fleetassets.repositories.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimService implements Crude<SimDTO, Sim, Operator>{
    private SimRepository simRepository;
    private TruckRepository truckRepository;

    @Autowired
    TruckService truckService;
    @Override
    public List<SimDTO> getAllDto(Pageable pageable, Operator operator) {
        if (operator != null){
//            return SimMapper.convertPageToDtoList(this.simRepository.findAll(pageable));
            return SimMapper.convertPageToDtoList(this.simRepository.findByOperator(operator, pageable));
        }
        return SimMapper.fromEntitiesListToDtoList(this.simRepository.findAll());
    }

    @Override
    public SimDTO getById(Long id) {
        if (this.simRepository.findById(id).get() != null){
            return SimMapper.fromEntityToDto(this.simRepository.findById(id).get());
        } else {
            throw new IllegalArgumentException(String.format("Sim by ID: %s not found", id));
        }

    }

    @Override
    public SimDTO create(SimDTO simDTO) {
        if (this.simRepository.findByIccid(simDTO.getIccid()) == null){
            Sim sim = SimMapper.fromDtoToEntity(simDTO);
            if (simDTO.getPin() == null){
                sim.setPin("nera");
            }
            this.simRepository.save(sim);
            return simDTO;
        } else {
            throw new IllegalArgumentException("Sim by iccid all ready existing");
        }

    }

    @Override
    public SimDTO update(SimDTO simDTO) throws NoSuchFieldException {
        Sim simForUpdate = this.simRepository.findById(simDTO.getId()).get();
        if (simDTO.getIccid() != null && this.simRepository.findByIccid(simDTO.getIccid()) == null){
            simForUpdate.setIccid(simDTO.getIccid());
        }
//        else {
//            throw new IllegalArgumentException("Sim by iccid all ready existing");
//        }

        if (simDTO.getNumber() != null){
            simForUpdate.setNumber(simDTO.getNumber());
        }

        if (simDTO.getPin() != null){
            simForUpdate.setPin(simDTO.getPin());
        } else {
            simForUpdate.setPin("nera");
        }

        if (simDTO.getOperator() != null){
            simForUpdate.setOperator(simDTO.getOperator());
        }

        if (simDTO.getPlan() != null){
            simForUpdate.setPlan(simDTO.getPlan());
        }

        if (simDTO.getIp() != null){
            simForUpdate.setIp(simDTO.getIp());
        }

        if (simDTO.getActivate() != null){
            simForUpdate.setActivate(simDTO.getActivate());
        }

        if(simDTO.getDeActivate() != null){
            simForUpdate.setDeActivate(simDTO.getDeActivate());
        }

        if (simDTO.getTruckId() != null){
            Optional<Truck> truck = this.truckRepository.findById(simDTO.getTruckId());
            if (!truck.isEmpty()){
                simForUpdate.setTruck(truck.get());
            } else {
                throw new NoSuchFieldException("This truck License Plate or truckID, do not exist");
            }

        } else if (simDTO.getTruckLicensePlate() != null) {
            Truck truck = this.truckRepository.findByLicensePlate(simDTO.getTruckLicensePlate());
            if (truck != null){
                simForUpdate.setTruck(truck);
            } else {
                throw new NoSuchElementException("This truck License Plate or truckID, do not exist");
            }
        }



        this.simRepository.save(simForUpdate);

        return SimMapper.fromEntityToDto(simForUpdate);
    }

    @Override
    public void deleteById(Long id) {
        if (this.simRepository.findById(id).get() != null){
            this.simRepository.deleteById(id);
        } else {
            throw new NoSuchElementException(String.format("Sim by ID: %s not found", id));
        }

    }
}
