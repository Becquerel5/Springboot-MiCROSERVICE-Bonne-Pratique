package net.dt.hosting.dto;


import lombok.*;
import net.dt.hosting.entities.Customer;
import net.dt.hosting.entities.Modepaiement;
import net.dt.hosting.entities.Pack;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class HostingRequestDTO {

    private String id;
    private LocalDate dateCreation = LocalDate.now();
    private boolean status;
    private Date dateDecheance;
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
