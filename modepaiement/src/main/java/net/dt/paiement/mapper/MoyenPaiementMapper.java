package net.dt.paiement.mapper;

import net.dt.paiement.dtos.MoyenPaiementRequestDTO;
import net.dt.paiement.dtos.MoyenPaiementResponseDTO;
import net.dt.paiement.entities.MoyenPaiement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MoyenPaiementMapper {
    MoyenPaiementResponseDTO moyenpaimentToMoyenPaimentResponseDTO(MoyenPaiement moyenPaiement);
    MoyenPaiement moyenPaimentRequestDTOMoyenpaiment(MoyenPaiementRequestDTO moyenPaiementRequestDTO);

}
