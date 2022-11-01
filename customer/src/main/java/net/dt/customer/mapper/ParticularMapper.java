package net.dt.customer.mapper;

import net.dt.customer.dtos.ParticularResponseDTO;
import net.dt.customer.dtos.ParticularResquestDTO;
import net.dt.customer.entities.Particular;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParticularMapper {

    ParticularResponseDTO particularToparticularResponseDTO(Particular particular);
    Particular particularRequestDTOparticular(ParticularResquestDTO particularResquestDTO);
}
