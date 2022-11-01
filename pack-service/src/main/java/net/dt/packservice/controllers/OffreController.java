package net.dt.packservice.controllers;

import net.dt.packservice.dtos.OffreRequestDTO;
import net.dt.packservice.dtos.OffreResponseDTO;
import net.dt.packservice.services.OffreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/api")
public class OffreController {
    private OffreService offreService;

    public OffreController(OffreService offreService) {
        this.offreService = offreService;
    }

    @GetMapping(path = "/getoffres")
    public List<OffreResponseDTO> alloffres(){
        return offreService.list();
    }

    @PostMapping(path = "/saveoffres")
    public OffreResponseDTO save(@RequestBody OffreRequestDTO offreRequestDTO){
        return offreService.save(offreRequestDTO);
    }

    @GetMapping(path = "/getoffres/{id}")
    public  OffreResponseDTO getoffres(@PathVariable String id){
        return offreService.get(id);
    }

    @PutMapping(path="/updateoffres")
    public OffreResponseDTO update(@RequestBody OffreRequestDTO offreRequestDTO) {
        return offreService.update(offreRequestDTO);
    }

    @DeleteMapping(path="/deleteoffres/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        offreService.delete(id);
    }

}
