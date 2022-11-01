package net.dt.hosting.services;

import net.dt.hosting.dto.HostingRequestDTO;
import net.dt.hosting.dto.HostingResponseDTO;
import net.dt.hosting.entities.Customer;
import net.dt.hosting.entities.Hosting;
import net.dt.hosting.exception.ResourceNotFoundException;
import net.dt.hosting.mapper.HostingMapper;
import net.dt.hosting.openfeign.CustomerRestClient;
import net.dt.hosting.openfeign.PackRestClient;
import net.dt.hosting.repositories.HostingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class HostingServiceImpl implements HostingService {
    private HostingRepository hostingRepository;
    private HostingMapper hostingMapper;
    private CustomerRestClient customerRestClient;
    private PackRestClient packRestClient;

    public HostingServiceImpl(HostingRepository hostingRepository, HostingMapper hostingMapper, CustomerRestClient customerRestClient, PackRestClient packRestClient) {
        this.hostingRepository = hostingRepository;
        this.hostingMapper = hostingMapper;
        this.customerRestClient = customerRestClient;

        this.packRestClient = packRestClient;
    }


    @Override
    public HostingResponseDTO save(HostingRequestDTO hostingRequestDTO) {
        try {
            //Customer customer =  customerRestClient(customer.);
            //hostingRequestDTO.setCustomerId(UUID.randomUUID().toString());
            Hosting hosting = hostingMapper.hostingRequestDTOHosting(hostingRequestDTO);

            Hosting saveHosting=hostingRepository.save(hosting);



            HostingResponseDTO hostingResponseDTO = hostingMapper.hostingToHostingResponseDTO(saveHosting);
            return hostingResponseDTO;
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Cannot save this Hosting");
        }

    }

    @Override
    public HostingResponseDTO getHosting(String id) {
        try {
            Hosting hosting = hostingRepository.findById(id).get();
            Customer customer = customerRestClient.getCustomer(hosting.getCustomerId());
            hosting.setCustomer(customer);
            return hostingMapper.fromHosting(hosting);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("error Cannot get this hosting");
        }

    }

    @Override
    public HostingResponseDTO update(HostingRequestDTO hostingRequestDTO) {
        try {
            Hosting hosting = hostingMapper.hostingRequestDTOHosting(hostingRequestDTO);
            //Hosting updateHosting = hostingRepository.findById(hostingRequestDTO.getId()).get();

            Hosting updateHosting = hostingRepository.save(hosting);
            return hostingMapper.hostingToHostingResponseDTO(updateHosting);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Error Cannot update Hosting");
        }

    }

    @Override
    public List<HostingResponseDTO> hostingsByCustomerId(String customerId) {
        try {
            List<Hosting> hostings=hostingRepository.findByCustomerId(customerId);
            return hostings
                    .stream()
                    .map(hosting -> hostingMapper.fromHosting(hosting))
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Cannot retrieve hostings By Customers");
        }

    }

    @Override
    public List<HostingResponseDTO> hostingsByPackId(String packId) {
        try {
            List<Hosting> hostings=hostingRepository.findByPackId(packId);
            return hostings
                    .stream()
                    .map(hosting -> hostingMapper.fromHosting(hosting))
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Cannot retrieve hostings By Pack");
        }

    }


    @Override
    public List<HostingResponseDTO> listHosting() {
        try {
            List<Hosting> hostings=hostingRepository.findAll();
            List<HostingResponseDTO> hostingResponseDTOS=
                    hostings.stream()
                            .map(host->hostingMapper.hostingToHostingResponseDTO(host))
                            .collect(Collectors.toList());
            return hostingResponseDTOS;
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Cannot retrieve listHosting");
        }

    }

    @Override
    public void delete(String id) {
        try {
            hostingRepository.deleteById(id);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Cannot delete Hosting");
        }

    }


}
























