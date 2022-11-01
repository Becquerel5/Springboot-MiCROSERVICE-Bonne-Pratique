package net.dt.hosting.services;

import net.dt.hosting.dto.RenewRequestDTO;
import net.dt.hosting.dto.RenewResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;


public interface RenewService {
    RenewResponseDTO save(RenewRequestDTO renewRequestDTO);
    RenewResponseDTO getRenew(String id);
    RenewResponseDTO update(RenewRequestDTO renewRequestDTO);
    List<RenewResponseDTO> listRenew();
    void delete(String id);
}
