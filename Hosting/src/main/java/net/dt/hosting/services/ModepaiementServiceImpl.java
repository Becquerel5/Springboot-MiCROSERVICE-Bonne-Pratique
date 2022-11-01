package net.dt.hosting.services;

import net.dt.hosting.dto.ModepaiementRequestDTO;
import net.dt.hosting.dto.ModepaiementResponseDTO;
import net.dt.hosting.entities.Modepaiement;
import net.dt.hosting.exception.ResourceNotFoundException;
import net.dt.hosting.mapper.ModepaiementMapper;
import org.springframework.http.ResponseEntity;
import net.dt.hosting.repositories.ModepaiementRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ModepaiementServiceImpl implements ModepaiementService {
    ModepaiementRepository modepaiementRepository;
    ModepaiementMapper modepaiementMapper;

    public ModepaiementServiceImpl(ModepaiementRepository modepaiementRepository, ModepaiementMapper modepaiementMapper) {
        this.modepaiementRepository = modepaiementRepository;
        this.modepaiementMapper = modepaiementMapper;
    }

    @Override
    public ModepaiementResponseDTO save(ModepaiementRequestDTO modepaiementRequestDTO) {
        try {
            Modepaiement modepaiement=modepaiementMapper.modepaiementRequestDTOModepaiement(modepaiementRequestDTO);
            Modepaiement saveModepaiement=modepaiementRepository.save(modepaiement);

            ModepaiementResponseDTO modepaiementResponseDTO = modepaiementMapper.modepaiementToModepaiementResponseDTO(saveModepaiement);
            return modepaiementResponseDTO;
        } catch (Exception exception) {
            throw new ResourceNotFoundException("cannot save Modepaiement ");
        }


    }

    @Override
    public ModepaiementResponseDTO getModepaiment(String id) {
        try {
            Modepaiement modepaiement = modepaiementRepository.findById(id).get();
            return modepaiementMapper.modepaiementToModepaiementResponseDTO(modepaiement);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("error,cannot retrieve Modepaiement ");
        }



    }

    @Override
    public ModepaiementResponseDTO update(ModepaiementRequestDTO modepaiementRequestDTO) {
        try {
            Modepaiement modepaiement = modepaiementMapper.modepaiementRequestDTOModepaiement(modepaiementRequestDTO);
            Modepaiement updateModepaiement = modepaiementRepository.save(modepaiement);
            return modepaiementMapper.modepaiementToModepaiementResponseDTO(updateModepaiement);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("An error occured,cannot perform an update");
        }

    }

    @Override
    public List<ModepaiementResponseDTO> listModepaiement() {
        try {
            List<Modepaiement> modepaiements=modepaiementRepository.findAll();
            List<ModepaiementResponseDTO> modepaiementResponseDTOS=
                    modepaiements.stream()
                            .map(mod->modepaiementMapper.modepaiementToModepaiementResponseDTO(mod))
                            .collect(Collectors.toList());
            return modepaiementResponseDTOS;
        } catch (Exception exception) {
            throw new ResourceNotFoundException("cannot find listModepaiement");
        }

    }

    @Override
    public void  delete(String id) {
        try {
            modepaiementRepository.deleteById(id);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Modepaiement doesnot exist");
        }

    }
}
