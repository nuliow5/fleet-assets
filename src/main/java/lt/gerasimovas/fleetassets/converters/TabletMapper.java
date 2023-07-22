package lt.gerasimovas.fleetassets.converters;

import lt.gerasimovas.fleetassets.dto.TabletDTO;
import lt.gerasimovas.fleetassets.entities.Sim;
import lt.gerasimovas.fleetassets.entities.Tablet;
import lt.gerasimovas.fleetassets.entities.Truck;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class TabletMapper {

    public static Tablet fromDtoToEntity(TabletDTO tabletDTO) {
        Tablet tablet = null;
        if (tabletDTO != null) {
            tablet = new Tablet();
            tablet.setId(tabletDTO.getId());
            tablet.setModel(tabletDTO.getModel());
            tablet.setImei(tabletDTO.getImei());
            tablet.setNumber(tabletDTO.getNumber());
            tablet.setOrderNumber(tabletDTO.getOrderNumber());

            if (tabletDTO.getSimId() != null) {
                Sim sim = new Sim();
                sim.setId(tablet.getId());
                tablet.setSim(sim);
            }

            if (tabletDTO.getTruckId() != null) {
                Truck truck = new Truck();
                truck.setId(tablet.getId());
//                truck.setLicensePlate(tabletDTO.getTruckLicensePlate());
                tablet.setTruck(truck);
            }
        }
        return tablet;
    }

    public static TabletDTO fromEntityToDto(Tablet tablet) {
        TabletDTO tabletDTO = null;
        if (tablet != null) {
            tabletDTO = new TabletDTO();
            tabletDTO.setId(tablet.getId());
            tabletDTO.setModel(tablet.getModel());
            tabletDTO.setImei(tablet.getImei());
            tabletDTO.setNumber(tablet.getNumber());
            tabletDTO.setOrderNumber(tablet.getOrderNumber());

            if (tablet.getSim() != null) {
                tabletDTO.setSimId(tablet.getSim().getId());
                tabletDTO.setSimNumber(tablet.getSim().getNumber());
            }

            if (tablet.getTruck() != null) {
                tabletDTO.setTruckId(tablet.getTruck().getId());
                tabletDTO.setTruckLicensePlate(tablet.getTruck().getLicensePlate());
            }

        }
        return tabletDTO;
    }

    public static List<TabletDTO> fromEntitiesListToDtoList(List<Tablet> tablets) {
        List<TabletDTO> tabletDTOList = null;
        if (tablets != null && !tablets.isEmpty()) {
            tabletDTOList = new ArrayList<>();
            for (Tablet t : tablets) {
                tabletDTOList.add(fromEntityToDto(t));
            }
        }
        return tabletDTOList;
    }

    public static List<TabletDTO> convertPageToDtoList(Page<Tablet> tabletPage) {
        List<TabletDTO> tabletDTOList = null;
        if (tabletPage != null && !tabletPage.isEmpty()) {
            tabletDTOList = new ArrayList<>();
            for (Tablet t : tabletPage) {
                tabletDTOList.add(fromEntityToDto(t));
            }
        }
        return tabletDTOList;
    }


}
