package net.dt.hosting.mapper;

import net.dt.hosting.dto.ModepaiementRequestDTO;
import net.dt.hosting.dto.ModepaiementResponseDTO;
import net.dt.hosting.entities.Modepaiement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModepaiementMapper {
    ModepaiementResponseDTO modepaiementToModepaiementResponseDTO(Modepaiement modepaiement);
    Modepaiement modepaiementRequestDTOModepaiement(ModepaiementRequestDTO modepaiementRequestDTO);

}
