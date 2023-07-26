package lt.gerasimovas.fleetassets.services;

import lombok.AllArgsConstructor;
import lt.gerasimovas.fleetassets.converters.PhoneMapper;
import lt.gerasimovas.fleetassets.dto.PhoneDTO;
import lt.gerasimovas.fleetassets.entities.Phone;
import lt.gerasimovas.fleetassets.entities.Truck;
import lt.gerasimovas.fleetassets.repositories.PhoneRepository;
import lt.gerasimovas.fleetassets.repositories.TruckRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PhoneService implements Crude<PhoneDTO, Phone> {
    private PhoneRepository phoneRepository;

    private TruckRepository truckRepository;


    @Override
    public List<PhoneDTO> getAllDto(Pageable pageable) {
        if (pageable != null) {
            return PhoneMapper.convertPageToDtoList(this.phoneRepository.findAll(pageable));
        }
        return PhoneMapper.fromEntitiesListToDtoList(this.phoneRepository.findAll());
    }

    @Override
    public PhoneDTO getById(Long id) {
        return PhoneMapper.fromEntityToDto(this.phoneRepository.findById(id).get());
    }

    @Override
    public PhoneDTO create(PhoneDTO phoneDTO) {
        Phone phone = PhoneMapper.fromDtoToEntity(phoneDTO);
        this.phoneRepository.save(phone);
        return phoneDTO;
    }

    @Override
    public PhoneDTO update(PhoneDTO phoneDTO) throws NoSuchFieldException {
        Phone phoneForUpdate = this.phoneRepository.findById(phoneDTO.getId()).get();

        if (phoneDTO.getModel() != null){
            phoneForUpdate.setModel(phoneDTO.getModel());
        }

        if (phoneDTO.getImei() != null){
            phoneForUpdate.setImei(phoneDTO.getImei());
        }

        if (phoneDTO.getNumber() != null){
            phoneForUpdate.setNumber(phoneDTO.getNumber());
        }

        if (phoneDTO.getOrderNumber() != null){
            phoneForUpdate.setOrderNumber(phoneDTO.getOrderNumber());
        }

        if (phoneDTO.getDateOfPurchase() != null){
            phoneForUpdate.setDateOfPurchase(phoneDTO.getDateOfPurchase());
        }

        if (phoneDTO.getChargerType() != null){
            phoneForUpdate.setChargerType(phoneDTO.getChargerType());
        }

        if (phoneDTO.getTruckId() != null){
            Optional<Truck> truck = truckRepository.findById(phoneDTO.getTruckId());
            if (!truck.isEmpty()){
                phoneForUpdate.setTruck(truck.get());
            } else {
                throw new NoSuchFieldException("Truck by ID doesnt exist");
            }
        }

        this.phoneRepository.save(phoneForUpdate);

        return PhoneMapper.fromEntityToDto(phoneForUpdate);
    }

    @Override
    public void deleteById(Long id) {
        if (this.phoneRepository.findById(id) != null) {
            this.phoneRepository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }
    }
}
