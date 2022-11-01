package net.dt.packservice.mapper;

import net.dt.packservice.dtos.OffreRequestDTO;
import net.dt.packservice.dtos.OffreResponseDTO;
import net.dt.packservice.entities.Offre;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface OffreMapper {
    OffreResponseDTO offreTooffreResponseDTO(Offre offre);
    Offre offreRequestDTOoffre(OffreRequestDTO offreRequestDTO);
}
