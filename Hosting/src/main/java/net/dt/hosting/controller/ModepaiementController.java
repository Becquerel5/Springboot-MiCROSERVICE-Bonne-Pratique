package net.dt.hosting.controller;

import net.dt.hosting.dto.ModepaiementRequestDTO;
import net.dt.hosting.dto.ModepaiementResponseDTO;
import net.dt.hosting.exception.ResourceNotFoundException;
import net.dt.hosting.services.ModepaiementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(name = "/api/paiement")
public class ModepaiementController {
    private ModepaiementService modepaiementService;

    public ModepaiementController(ModepaiementService modepaiementService) {
        this.modepaiementService = modepaiementService;
    }

    @GetMapping(path = "/retrieve")
    public List<ModepaiementResponseDTO> allmodepaiements(){
        return modepaiementService.listModepaiement();
    }

    @PostMapping(path = "/save")
    public ModepaiementResponseDTO save(@RequestBody ModepaiementRequestDTO modepaiementRequestDTO){
        return modepaiementService.save(modepaiementRequestDTO);
    }

    @GetMapping(path = "/retrieve/{id}")
    public  ModepaiementResponseDTO getModepaiement(@PathVariable String id){
        return modepaiementService.getModepaiment(id);

    }

    @DeleteMapping(path="/paiementdelete/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        modepaiementService.delete(id);

    }

    @PutMapping(path="/paiementupdate")
    public ModepaiementResponseDTO update(@RequestBody ModepaiementRequestDTO modepaiementRequestDTO) {
        return modepaiementService.update(modepaiementRequestDTO);
    }
}
