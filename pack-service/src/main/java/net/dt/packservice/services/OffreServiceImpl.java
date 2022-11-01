package net.dt.packservice.services;

import net.dt.packservice.dtos.OffreRequestDTO;
import net.dt.packservice.dtos.OffreResponseDTO;
import net.dt.packservice.entities.Offre;
import net.dt.packservice.mapper.OffreMapper;
import net.dt.packservice.mapper.PackMapper;
import net.dt.packservice.repositories.OffreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OffreServiceImpl implements OffreService {
    private OffreMapper offreMapper;
   private OffreRepository offreRepository;

    public OffreServiceImpl(OffreMapper offreMapper, OffreRepository offreRepository) {
        this.offreMapper = offreMapper;
        this.offreRepository = offreRepository;

    }

    @Override
    public OffreResponseDTO save(OffreRequestDTO offreRequestDTO) {
        Offre offre=offreMapper.offreRequestDTOoffre(offreRequestDTO);
        Offre saveOffre=offreRepository.save(offre);
        OffreResponseDTO offreResponseDTO = offreMapper.offreTooffreResponseDTO(saveOffre);
        return offreResponseDTO;
    }

    @Override
    public OffreResponseDTO get(String id) {
        Offre offre = offreRepository.findById(id).get();
        return offreMapper.offreTooffreResponseDTO(offre);
    }

    @Override
    public OffreResponseDTO update(OffreRequestDTO offreRequestDTO) {
        Offre offre = offreMapper.offreRequestDTOoffre(offreRequestDTO);
        Offre updateOffre = offreRepository.save(offre);
        return offreMapper.offreTooffreResponseDTO(updateOffre);
    }

    @Override
    public List<OffreResponseDTO> list() {
        List<Offre> offres=offreRepository.findAll();
        List<OffreResponseDTO> offreResponseDTOS=
                offres.stream()
                        .map(cus->offreMapper.offreTooffreResponseDTO(cus))
                        .collect(Collectors.toList());
        return offreResponseDTOS;
    }

    @Override
    public void delete(String id) {
        offreRepository.deleteById(id);

    }
}
