package net.dt.hosting.mapper;


import net.dt.hosting.dto.HostingRequestDTO;
import net.dt.hosting.dto.HostingResponseDTO;
import net.dt.hosting.entities.Hosting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HostingMapper {
    HostingResponseDTO hostingToHostingResponseDTO(Hosting hosting);
    Hosting hostingRequestDTOHosting(HostingRequestDTO hostingRequestDTO);
    HostingResponseDTO fromHosting(Hosting hosting);
}





























