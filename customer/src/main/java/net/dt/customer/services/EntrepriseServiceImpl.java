package net.dt.customer.services;

import net.dt.customer.dtos.EntrepriseRequestDTO;
import net.dt.customer.dtos.EntrepriseResponse;
import net.dt.customer.entities.Entreprise;
import net.dt.customer.mapper.EntrepriseMapper;
import net.dt.customer.repository.EntrepriseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EntrepriseServiceImpl implements EntrepriseService {
    private EntrepriseRepository entrepriseRepository;
    private EntrepriseMapper entrepriseMapper;

    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository, EntrepriseMapper entrepriseMapper) {
        this.entrepriseRepository = entrepriseRepository;
        this.entrepriseMapper = entrepriseMapper;
    }


    @Override
    public EntrepriseResponse save(EntrepriseRequestDTO entrepriseRequestDTO) {
        Entreprise entreprise=entrepriseMapper.entrepriseRequestDTOentreprise(entrepriseRequestDTO);
        Entreprise saveEntreprise=entrepriseRepository.save(entreprise);
        EntrepriseResponse entrepriseResponse = entrepriseMapper.entrepriseToentrepriseResponseDTO(saveEntreprise);
        return entrepriseResponse;
    }

    @Override
    public EntrepriseResponse get(String id) {
        Entreprise entreprise = entrepriseRepository.findById(id).get();
        return entrepriseMapper.entrepriseToentrepriseResponseDTO(entreprise);
    }

    @Override
    public EntrepriseResponse update(EntrepriseRequestDTO entrepriseRequestDTO) {
        Entreprise entreprise = entrepriseMapper.entrepriseRequestDTOentreprise(entrepriseRequestDTO);
        Entreprise updateEntreprise = entrepriseRepository.save(entreprise);
        return entrepriseMapper.entrepriseToentrepriseResponseDTO(updateEntreprise);
    }

    @Override
    public List<EntrepriseResponse> list() {
        List<Entreprise> entreprises=entrepriseRepository.findAll();
        List<EntrepriseResponse> entrepriseResponses=
                entreprises.stream()
                        .map(en->entrepriseMapper.entrepriseToentrepriseResponseDTO(en))
                        .collect(Collectors.toList());
        return entrepriseResponses;
    }

    @Override
    public void delete(String id) {
        entrepriseRepository.deleteById(id);

    }
}
