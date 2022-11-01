package net.dt.customer.controller;

import net.dt.customer.dtos.ParticularResponseDTO;
import net.dt.customer.dtos.ParticularResquestDTO;
import net.dt.customer.services.ParticularService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/api")
public class ParticularController {
    private ParticularService particularService;

    public ParticularController(ParticularService particularService) {
        this.particularService = particularService;
    }

    @GetMapping(path = "/getparticulars")
    public List<ParticularResponseDTO> allParticulars(){
        return particularService.list();
    }

    @PostMapping(path = "/saveparticulars")
    public ParticularResponseDTO save(@RequestBody ParticularResquestDTO particularResquestDTO){
        return particularService.save(particularResquestDTO);
    }

    @GetMapping(path = "/getparticulars/{id}")
    public  ParticularResponseDTO getParticulars(@PathVariable String id){
        return particularService.get(id);
    }

    @PutMapping(path="/updateparticulars")
    public ParticularResponseDTO update(@io.swagger.v3.oas.annotations.parameters.RequestBody ParticularResquestDTO particularResquestDTO) {
        return particularService.update(particularResquestDTO);
    }

    @DeleteMapping(path="/deleteparticulars/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        particularService.delete(id);
    }
}
