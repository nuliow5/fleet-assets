package lt.gerasimovas.fleetassets.converters;

import lt.gerasimovas.fleetassets.dto.PhoneDTO;
import lt.gerasimovas.fleetassets.entities.Phone;
import lt.gerasimovas.fleetassets.entities.Truck;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PhoneMapper {

    public static Phone fromDtoToEntity(PhoneDTO phoneDTO) {
        Phone phone = null;
        if (phoneDTO != null) {
            phone = new Phone();
            phone.setId(phoneDTO.getId());
            phone.setModel(phoneDTO.getModel());
            phone.setImei(phoneDTO.getImei());
            phone.setNumber(phoneDTO.getNumber());
            phone.setOrderNumber(phoneDTO.getOrderNumber());
            phone.setDateOfPurchase(phoneDTO.getDateOfPurchase());
            phone.setChargerType(phoneDTO.getChargerType());

            if (phoneDTO.getTruckId() != null) {
                Truck truck = new Truck();
                truck.setId(phone.getId());
                phone.setTruck(truck);
            }
        }
        return phone;
    }

    public static PhoneDTO fromEntityToDto(Phone phone) {
        PhoneDTO phoneDTO = null;
        if (phone != null){
            phoneDTO = new PhoneDTO();
            phoneDTO.setId(phone.getId());
            phoneDTO.setModel(phone.getModel());
            phoneDTO.setImei(phone.getImei());
            phoneDTO.setNumber(phone.getNumber());
            phoneDTO.setOrderNumber(phone.getOrderNumber());
            phoneDTO.setDateOfPurchase(phone.getDateOfPurchase());
            phoneDTO.setChargerType(phone.getChargerType());

            if (phone.getTruck() != null){
                phoneDTO.setTruckId(phone.getTruck().getId());
                phoneDTO.setTruckLicensePlate(phone.getTruck().getLicensePlate());
            }
        }
        return phoneDTO;
    }


    public static List<PhoneDTO> fromEntitiesListToDtoList(List<Phone> phones){
        List<PhoneDTO> phoneDTOList = null;
        if (phones != null && !phones.isEmpty()){
            phoneDTOList = new ArrayList<>();
            for (Phone p : phones){
                phoneDTOList.add(fromEntityToDto(p));
            }
        }
        return phoneDTOList;
    }

    public static List<PhoneDTO> convertPageToDtoList(Page<Phone> phonePage){
        List<PhoneDTO> phoneDTOList = null;
        if (phonePage != null && !phonePage.isEmpty()){
            phoneDTOList = new ArrayList<>();
            for (Phone p : phonePage){
                phoneDTOList.add(fromEntityToDto(p));
            }
        }
        return phoneDTOList;
    }

}
