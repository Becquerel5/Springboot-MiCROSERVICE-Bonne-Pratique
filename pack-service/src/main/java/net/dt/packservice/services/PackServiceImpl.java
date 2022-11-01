package net.dt.packservice.services;

import net.dt.packservice.dtos.PackRequestDTO;
import net.dt.packservice.dtos.PackResponseDTO;
import net.dt.packservice.entities.Pack;
import net.dt.packservice.mapper.PackMapper;
import net.dt.packservice.repositories.PackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PackServiceImpl implements PackService {
    private PackMapper packMapper;
    private PackRepository packRepository;

    public PackServiceImpl(PackMapper packMapper, PackRepository packRepository) {
        this.packMapper = packMapper;
        this.packRepository = packRepository;
    }


    @Override
    public PackResponseDTO save(PackRequestDTO packRequestDTO) {
        Pack pack=packMapper.packRequestDTOpack(packRequestDTO);
        Pack savePack=packRepository.save(pack);
        PackResponseDTO packResponseDTO = packMapper.packTopackResponseDTO(savePack);
        return packResponseDTO;
    }

    @Override
    public PackResponseDTO get(String id) {
        Pack pack = packRepository.findById(id).get();
        return packMapper.packTopackResponseDTO(pack);
    }

    @Override
    public PackResponseDTO update(PackRequestDTO packRequestDTO) {
        Pack pack = packMapper.packRequestDTOpack(packRequestDTO);
        Pack updatePack = packRepository.save(pack);
        return packMapper.packTopackResponseDTO(updatePack);
    }

    @Override
    public List<PackResponseDTO> list() {
        List<Pack> packs=packRepository.findAll();
        List<PackResponseDTO> packResponseDTOS=
                packs.stream()
                        .map(cus->packMapper.packTopackResponseDTO(cus))
                        .collect(Collectors.toList());
        return packResponseDTOS;
    }

    @Override
    public void delete(String id) {
        packRepository.deleteById(id);

    }
}
