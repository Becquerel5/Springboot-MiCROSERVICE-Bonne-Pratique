package net.dt.hosting.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public  class Hosting {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;

    //@Enumerated(value = EnumType.STRING)
    //private InfantType type;

    @Column(name = "dateCreation")
    private LocalDate dateCreation = LocalDate.now();

    @Column(name = "status")
    private boolean status;

    @Column(name = "dateDecheance")
    private Date dateDecheance;

    @Column(name = "operateur")
    private String operateur;


    private String packId;


    private String customerId;

    @Transient
    private Pack pack;

    @Transient
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modepaiement_id")
    private Modepaiement modepaiement;


}