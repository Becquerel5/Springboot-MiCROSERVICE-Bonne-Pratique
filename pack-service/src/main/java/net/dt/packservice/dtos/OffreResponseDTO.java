package net.dt.packservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;


@AllArgsConstructor @NoArgsConstructor @Data
public class OffreResponseDTO {


    private String id;
    private String intitule;
    private String description;
    private LocalDate dateCreation = LocalDate.now();
}
