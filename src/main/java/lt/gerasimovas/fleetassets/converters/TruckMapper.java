package lt.gerasimovas.fleetassets.converters;

import lt.gerasimovas.fleetassets.dto.TruckDTO;
import lt.gerasimovas.fleetassets.entities.Truck;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class TruckMapper {

    public static Truck fromDtoToSimEntity(TruckDTO truckDTO) {
        Truck truck = null;
        if (truckDTO != null) {
            truck = new Truck();
            truck.setId(truckDTO.getId());
            truck.setLicensePlate(truckDTO.getLicensePlate());
            truck.setModel(truckDTO.getModel());
            truck.setIsWork(truckDTO.getIsWork());
            truck.setWorkRegion(truckDTO.getWorkRegion());
        }
        return truck;
    }

    public static TruckDTO fromEntityToSimDto(Truck truck) {
        TruckDTO truckDTO = null;
        if (truck != null) {
            truckDTO = new TruckDTO();
            truckDTO.setId(truck.getId());
            truckDTO.setLicensePlate(truck.getLicensePlate());
            truckDTO.setModel(truck.getModel());
            truckDTO.setIsWork(truck.getIsWork());
            truckDTO.setWorkRegion(truck.getWorkRegion());
        }
        return truckDTO;
    }

    public static List<TruckDTO> fromEntitiesListToDtoList(List<Truck> trucks) {
        List<TruckDTO> truckDTOList = null;
        if (trucks != null && !trucks.isEmpty()) {
            truckDTOList = new ArrayList<>();
            for (Truck t : trucks) {
                truckDTOList.add(fromEntityToSimDto(t));
            }
        }

        return truckDTOList;
    }

    public static List<TruckDTO> convertPageToDtoList(Page<Truck> truckPage) {
        List<TruckDTO> truckDTOList = null;
        if (truckPage != null && !truckPage.isEmpty()){
            truckDTOList = new ArrayList<>();
            for (Truck t : truckPage){
                truckDTOList.add(fromEntityToSimDto(t));
            }
        }
        return truckDTOList;
    }


}
