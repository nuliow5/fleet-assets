package lt.gerasimovas.fleetassets.entities;

import jakarta.persistence.*;
import lombok.*;
import lt.gerasimovas.fleetassets.enumes.Operator;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "sims")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "iccid", nullable = false, unique = true)
    private String iccid;
    @Column(nullable = false)
    private Integer number;
    private String pin;
    @Enumerated
    @Column(nullable = false)
    private Operator operator;
    @Column(nullable = false)
    private String plan;
    private String ip;
    @Column(nullable = false)
    private LocalDate activate;
    private LocalDate deActivate;
    @OneToOne(mappedBy = "sim", cascade = CascadeType.ALL)
    private Tablet tablet;
    @ManyToOne
    @JoinColumn(name = "truck_id")
    private Truck truck;

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
