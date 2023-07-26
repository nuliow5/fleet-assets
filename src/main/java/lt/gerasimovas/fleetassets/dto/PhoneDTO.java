package lt.gerasimovas.fleetassets.dto;


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
public class PhoneDTO {
    private Long id;
    private String model;
    private String imei;
    private String number;
    private String orderNumber;
    private LocalDate dateOfPurchase;
    private ChargerType chargerType;
    //    @JsonIgnore
    private Long truckId;
    private String truckLicensePlate;
}
