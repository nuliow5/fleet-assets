package lt.gerasimovas.fleetassets.services;

import lombok.AllArgsConstructor;
import lt.gerasimovas.fleetassets.converters.SimMapper;
import lt.gerasimovas.fleetassets.dto.SimDTO;
import lt.gerasimovas.fleetassets.entities.Sim;
import lt.gerasimovas.fleetassets.repositories.SimRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class SimService implements Crude<SimDTO, Sim>{
    private SimRepository simRepository;

    public List<SimDTO> getAllDto(Pageable pageable) {
        if (pageable != null){
            return SimMapper.convertPageToDtoList(simRepository.findAll(pageable));
        }
        return SimMapper.fromEntitiesListToDtoList(simRepository.findAll());
    }

    @Override
    public SimDTO getById(Long id) {
        return SimMapper.fromEntityToSimDto(simRepository.findById(id).get());
    }

    @Override
    public SimDTO create(SimDTO simDTO) {
        Sim sim = SimMapper.fromDtoToSimEntity(simDTO);
        this.simRepository.save(sim);

        return simDTO;
    }

    @Override
    public SimDTO update(SimDTO simDTO) {
        Sim simForUpdate = simRepository.findById(simDTO.getId()).get();
        if (simDTO.getIccid() != null){
            simForUpdate.setIccid(simDTO.getIccid());
        }

        if (simDTO.getNumber() != null){
            simForUpdate.setNumber(simDTO.getNumber());
        }

        if (simDTO.getPin() != null){
            simForUpdate.setPin(simDTO.getPin());
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

        simRepository.save(simForUpdate);
        return simDTO;
    }

    @Override
    public void deleteById(Long id) {
        if (simRepository.findById(id).get() != null){
            simRepository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }

    }
}
