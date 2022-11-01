package net.dt.paiement.services;

import net.dt.paiement.dtos.MoyenPaiementRequestDTO;
import net.dt.paiement.dtos.MoyenPaiementResponseDTO;

import java.util.List;

public interface MoyenpaiementService {

    MoyenPaiementResponseDTO getOne(String id);
    List<MoyenPaiementResponseDTO> getAll();
    MoyenPaiementResponseDTO save(MoyenPaiementRequestDTO moyenPaiementRequestDTO);
    MoyenPaiementResponseDTO update(MoyenPaiementRequestDTO moyenPaiementRequestDTO);

    void delete(String id);
}
