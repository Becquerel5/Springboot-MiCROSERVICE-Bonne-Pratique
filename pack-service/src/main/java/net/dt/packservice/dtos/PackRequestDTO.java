package net.dt.packservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dt.packservice.entities.Offre;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackRequestDTO {


    private String id;

    @Column(nullable = false, unique = true)
    private String intitule;

    @Column(nullable = true)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offres_id")
    private Offre offre;

    private LocalDate dateCreation = LocalDate.now();

    private Date dateDescheances;
}

























