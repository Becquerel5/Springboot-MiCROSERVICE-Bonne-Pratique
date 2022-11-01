package net.dt.hosting.mapper;

import net.dt.hosting.dto.RenewRequestDTO;
import net.dt.hosting.dto.RenewResponseDTO;
import net.dt.hosting.entities.Renew;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RenewMapper{
    RenewResponseDTO renewToRenewResponseDTO(Renew renew);
    Renew renewRequestDTORenew(RenewRequestDTO hostingRequestDTO);
}
