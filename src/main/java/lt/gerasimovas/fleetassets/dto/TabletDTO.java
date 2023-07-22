package lt.gerasimovas.fleetassets.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.gerasimovas.fleetassets.enumes.ChargerType;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TabletDTO {
    private Long id;
    private String model;
    private String imei;
    private String number;
    private String orderNumber;
//    @JsonIgnore
    private Long simId;
    private Integer simNumber;
//    @JsonIgnore
    private Long truckId;
    private String truckLicensePlate;
    private LocalDate dateOfPurchase;
    private ChargerType chargerType;



}
