package net.dt.hosting.services;

import net.dt.hosting.dto.HostingRequestDTO;
import net.dt.hosting.dto.HostingResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

public interface HostingService {
    HostingResponseDTO save(HostingRequestDTO hostingRequestDTO);
    HostingResponseDTO getHosting(String id);
    HostingResponseDTO update(HostingRequestDTO HostingRequestDTO);
    List<HostingResponseDTO> hostingsByCustomerId(String customerId);
    List<HostingResponseDTO> hostingsByPackId(String packId);
    List<HostingResponseDTO> listHosting();
    void delete(String id);
}






























