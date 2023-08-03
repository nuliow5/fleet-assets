package lt.gerasimovas.fleetassets.entities;

import javax.persistence.*;
import lombok.*;
import lt.gerasimovas.fleetassets.enumes.ChargerType;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tablets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tablet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    @Column(name = "imei", nullable = false, unique = true)
    private String imei;
    @Column(name = "number", nullable = false, unique = true)
    private String number;
    private String orderNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sim_id", referencedColumnName = "id", unique = true)
    private Sim sim;

    @ManyToOne
    @JoinColumn(name = "truck_id")
    private Truck truck;
    @Column(name = "date_of_purchase")
    private LocalDate dateOfPurchase;
    private ChargerType chargerType;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
