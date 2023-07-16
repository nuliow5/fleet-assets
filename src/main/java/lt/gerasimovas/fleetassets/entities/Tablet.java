//package lt.gerasimovas.fleetassets.entities;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lt.gerasimovas.fleetassets.enumes.ChargerType;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "tablets")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class Tablet {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String model;
//    private String imei;
//    private String number;
//    private String orderNumber;
//
//    private Sim sim;
//    @Column(name = "date_of_purchase")
//    private LocalDate dateOfPurchase;
//    private ChargerType chargerType;
//
//    @Column(name = "created_at")
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt;
//
//    @PrePersist
//    void prePersist() {
//        this.createdAt = LocalDateTime.now();
//    }
//    @PreUpdate
//    void preUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
//
//}
