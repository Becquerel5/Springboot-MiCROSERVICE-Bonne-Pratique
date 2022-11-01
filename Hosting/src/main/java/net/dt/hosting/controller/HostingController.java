package net.dt.hosting.controller;

import net.dt.hosting.dto.HostingRequestDTO;
import net.dt.hosting.dto.HostingResponseDTO;
import net.dt.hosting.services.HostingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api")
public class HostingController {
    private HostingService hostingService;

    public HostingController(HostingService hostingService) {
        this.hostingService = hostingService;
    }

    @GetMapping(path = "/hostings")
    public List<HostingResponseDTO> allhostings(){
        return hostingService.listHosting();
    }

    @PostMapping(path = "/save")
    public HostingResponseDTO save(@RequestBody HostingRequestDTO hostingRequestDTO){
        return hostingService.save(hostingRequestDTO);
    }

    @GetMapping(path = "/hostings/{id}")
    public  HostingResponseDTO getHosting(@PathVariable String id){
        return hostingService.getHosting(id);
    }

    @GetMapping(path = "/hostings/{customerId}")
    public List<HostingResponseDTO> getHostingsByCustomer(@PathVariable String customerId){
        return hostingService.hostingsByCustomerId(customerId);
    }

    @GetMapping(path = "/hostings/{packId}")
    public List<HostingResponseDTO> getHostingsByPack(@PathVariable String packId){
        return hostingService.hostingsByPackId(packId);
    }


    @DeleteMapping(path="/hostings/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        hostingService.delete(id);
    }

    @PutMapping(path="/hostingsupdate")
    public HostingResponseDTO update(@RequestBody HostingRequestDTO hostingRequestDTO) {
        return hostingService.update(hostingRequestDTO);
    }

}



































