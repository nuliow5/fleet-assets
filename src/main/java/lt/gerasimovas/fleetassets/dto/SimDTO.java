package lt.gerasimovas.fleetassets.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.gerasimovas.fleetassets.enumes.Operator;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SimDTO {
    private Long id;
    private Long iccid;
    private Integer number;
    private String pin;
    private Operator operator;
    private String plan;
    private String ip;
    private LocalDate activate;
    private LocalDate deActivate;
}
