package net.dt.hosting.services;

import net.dt.hosting.dto.RenewRequestDTO;
import net.dt.hosting.dto.RenewResponseDTO;

import net.dt.hosting.entities.Renew;
import net.dt.hosting.exception.ResourceNotFoundException;
import net.dt.hosting.mapper.RenewMapper;
import net.dt.hosting.repositories.RenewRepository;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RenewServiceImpl implements RenewService {
    private RenewRepository renewRepository;
    private RenewMapper renewMapper;

    public RenewServiceImpl(RenewRepository renewRepository, RenewMapper renewMapper) {
        this.renewRepository = renewRepository;
        this.renewMapper = renewMapper;
    }

    @Override
    public RenewResponseDTO save(RenewRequestDTO renewRequestDTO) {
        try {
            Renew renew = renewMapper.renewRequestDTORenew(renewRequestDTO);
            Renew saveRenew=renewRepository.save(renew);
            RenewResponseDTO renewResponseDTO = renewMapper.renewToRenewResponseDTO(saveRenew);
            return renewResponseDTO;
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Cannot save this renouvellement");
        }

    }

    @Override
    public RenewResponseDTO getRenew(String id) {
        try {
            Renew renew = renewRepository.findById(id).get();
            return renewMapper.renewToRenewResponseDTO(renew);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Cannot get this renouvellement");
        }

    }

    @Override
    public RenewResponseDTO update(RenewRequestDTO renewRequestDTO) {
        try {
            Renew renew = renewMapper.renewRequestDTORenew(renewRequestDTO);
            Renew updateRenew = renewRepository.save(renew);
            return renewMapper.renewToRenewResponseDTO(updateRenew);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Cannot update Renouvellement");
        }

    }

    @Override
    public List<RenewResponseDTO> listRenew() {
        try {
            List<Renew> renews=renewRepository.findAll();
            List<RenewResponseDTO> renewResponseDTOS=
                    renews.stream()
                            .map(ren->renewMapper.renewToRenewResponseDTO(ren))
                            .collect(Collectors.toList());

            return renewResponseDTOS;
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Error, Cannot show the list iof all renouvellements");
        }

    }

    @Override
    public void delete(String id) {
        try {
            renewRepository.deleteById(id);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Cannot delete Renouvellement");
        }

    }
}
