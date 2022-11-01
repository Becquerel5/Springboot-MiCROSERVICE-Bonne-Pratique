package net.dt.customer.mapper;

import net.dt.customer.dtos.EntrepriseRequestDTO;
import net.dt.customer.dtos.EntrepriseResponse;
import net.dt.customer.entities.Entreprise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntrepriseMapper {

    EntrepriseResponse entrepriseToentrepriseResponseDTO(Entreprise entreprise);
    Entreprise entrepriseRequestDTOentreprise(EntrepriseRequestDTO entrepriseRequestDTO);
}
