package net.dt.customer.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dt.customer.entities.Customer;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParticularResponseDTO extends Customer {

    @Id
    private String id;
    private String sexe;
    private String cni;
    private String prenom;


}
