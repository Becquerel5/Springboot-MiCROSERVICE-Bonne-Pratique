package net.dt.hosting.services;

import net.dt.hosting.dto.ModepaiementRequestDTO;
import net.dt.hosting.dto.ModepaiementResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;


public interface ModepaiementService{
    ModepaiementResponseDTO save(ModepaiementRequestDTO modepaiementRequestDTO);
    ModepaiementResponseDTO getModepaiment(String id);
    ModepaiementResponseDTO update(ModepaiementRequestDTO modepaiementRequestDTO);
    List<ModepaiementResponseDTO> listModepaiement();
    void delete(String id);

}
