package net.dt.hosting.dto;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModepaiementResponseDTO{

    private String id;
    private String intitule;
    private String description;


}
