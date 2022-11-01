package net.dt.paiement.mapper;

import net.dt.paiement.dtos.ModepaimentRequestDTO;
import net.dt.paiement.dtos.ModepaimentResponseDTO;
import net.dt.paiement.entities.Modepaiment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModePaiementMapper {
    ModepaimentResponseDTO modepaimenToModepaiementResponseDTO(Modepaiment modepaiment);
    Modepaiment modepaaimentRequestDTOModepaiement(ModepaimentRequestDTO modepaimentRequestDTO);
    ModepaimentResponseDTO fromModepaiment(Modepaiment modepaiment);

}
