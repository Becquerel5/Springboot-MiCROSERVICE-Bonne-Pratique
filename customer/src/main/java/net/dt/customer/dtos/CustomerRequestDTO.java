package net.dt.customer.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class CustomerRequestDTO {

    @Id
    private String id;
    private String name;
    private String telephone1;
    private String telephone2;
    private String email;
    private Boolean status;
    private String ville;
    private String country;

}
