package net.dt.customer.services;

import net.dt.customer.dtos.ParticularResponseDTO;
import net.dt.customer.dtos.ParticularResquestDTO;
import net.dt.customer.entities.Particular;
import net.dt.customer.mapper.ParticularMapper;
import net.dt.customer.repository.ParticularRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParticularServiceImpl implements ParticularService {
    private ParticularRepository particularRepository;
    private ParticularMapper particularMapper;

    public ParticularServiceImpl(ParticularRepository particularRepository, ParticularMapper particularMapper) {
        this.particularRepository = particularRepository;
        this.particularMapper = particularMapper;
    }


    @Override
    public ParticularResponseDTO save(ParticularResquestDTO particularResquestDTO) {
        Particular particular=particularMapper.particularRequestDTOparticular(particularResquestDTO);
        Particular saveParticular=particularRepository.save(particular);
        ParticularResponseDTO particularResponseDTO = particularMapper.particularToparticularResponseDTO(saveParticular);
        return particularResponseDTO;
    }

    @Override
    public ParticularResponseDTO get(String id) {
        Particular particular = particularRepository.findById(id).get();
        return particularMapper.particularToparticularResponseDTO(particular);
    }

    @Override
    public ParticularResponseDTO update(ParticularResquestDTO particularResquestDTO) {
        Particular particular = particularMapper.particularRequestDTOparticular(particularResquestDTO);
        Particular updateParticular = particularRepository.save(particular);
        return particularMapper.particularToparticularResponseDTO(updateParticular);
    }

    @Override
    public List<ParticularResponseDTO> list() {
        List<Particular> particulars=particularRepository.findAll();
        List<ParticularResponseDTO> particularResponseDTOS=
                particulars.stream()
                        .map(pa->particularMapper.particularToparticularResponseDTO(pa))
                        .collect(Collectors.toList());
        return particularResponseDTOS;
    }

    @Override
    public void delete(String id) {
        particularRepository.deleteById(id);

    }
}
