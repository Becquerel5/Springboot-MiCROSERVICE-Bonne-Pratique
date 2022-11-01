package net.dt.packservice.mapper;


import net.dt.packservice.dtos.PackRequestDTO;
import net.dt.packservice.dtos.PackResponseDTO;
import net.dt.packservice.entities.Pack;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PackMapper {
    PackResponseDTO packTopackResponseDTO(Pack pack);
    Pack packRequestDTOpack(PackRequestDTO packRequestDTO);
}
