package net.dt.paiement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModepaimentResponseDTO {


    private String id;
    private String intitule;
    private String description;

}
