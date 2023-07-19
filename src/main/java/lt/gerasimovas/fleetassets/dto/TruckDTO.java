package lt.gerasimovas.fleetassets.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.gerasimovas.fleetassets.enumes.WorkRegion;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TruckDTO {
    private Long id;
    private String licensePlate;
    private String model;
    private Boolean isWork;
    private WorkRegion workRegion;

}
