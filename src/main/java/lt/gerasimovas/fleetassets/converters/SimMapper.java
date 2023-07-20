package lt.gerasimovas.fleetassets.converters;

import lt.gerasimovas.fleetassets.dto.SimDTO;
import lt.gerasimovas.fleetassets.entities.Sim;
import lt.gerasimovas.fleetassets.entities.Truck;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class SimMapper {
    public static Sim fromDtoToEntity(SimDTO simDTO) {
        Sim sim = null;
        if (simDTO != null) {
            sim = new Sim();
            sim.setId(simDTO.getId());
            sim.setIccid(simDTO.getIccid());
            sim.setNumber(simDTO.getNumber());
            sim.setPin(simDTO.getPin());
            sim.setOperator(simDTO.getOperator());
            sim.setPlan(simDTO.getPlan());
            sim.setIp(simDTO.getIp());
            sim.setActivate(simDTO.getActivate());
            sim.setDeActivate(simDTO.getDeActivate());

            if (simDTO.getTruckId() != null){
                Truck truck = new Truck();
                truck.setId(sim.getId());
                sim.setTruck(truck);
            }
        }
        return sim;
    }

    public static SimDTO fromEntityToDto(Sim sim) {
        SimDTO simDTO = null;
        if (sim != null) {
            simDTO = new SimDTO();
            simDTO.setId(sim.getId());
            simDTO.setIccid(sim.getIccid());
            simDTO.setNumber(sim.getNumber());
            simDTO.setPin(sim.getPin());
            simDTO.setOperator(sim.getOperator());
            simDTO.setPlan(sim.getPlan());
            simDTO.setIp(sim.getIp());
            simDTO.setActivate(sim.getActivate());
            simDTO.setDeActivate(sim.getDeActivate());

            if (sim.getTruck() != null){
                simDTO.setTruckId(sim.getTruck().getId());
                simDTO.setTruckLicensePlate(sim.getTruck().getLicensePlate());
            }
        }
        return simDTO;
    }

    public static List<SimDTO> fromEntitiesListToDtoList(List<Sim> sims) {
        List<SimDTO> simDTOList = null;
        if (sims != null && !sims.isEmpty()) {
            simDTOList = new ArrayList<>();
            for (Sim s : sims) {
                simDTOList.add(fromEntityToDto(s));
            }
        }
        return simDTOList;
    }

    public static List<SimDTO> convertPageToDtoList(Page<Sim> simPage) {
        List<SimDTO> simDTOList = null;
        if (simPage != null && !simPage.isEmpty()) {
            simDTOList = new ArrayList<>();
            for (Sim s : simPage) {
                simDTOList.add(fromEntityToDto(s));
            }
        }
        return simDTOList;
    }


}
