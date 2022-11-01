package net.dt.customer.controller;

import net.dt.customer.dtos.EntrepriseRequestDTO;
import net.dt.customer.dtos.EntrepriseResponse;
import net.dt.customer.services.EntrepriseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/api")
public class EntrepriseController {
    private EntrepriseService entrepriseService;

    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @GetMapping(path = "/getentreprise")
    public List<EntrepriseResponse> allEntreprise(){
        return entrepriseService.list();
    }

    @PostMapping(path = "/saveentreprise")
    public EntrepriseResponse save(@RequestBody EntrepriseRequestDTO entrepriseRequestDTO){
        return entrepriseService.save(entrepriseRequestDTO);
    }

    @GetMapping(path = "/getentreprise/{id}")
    public  EntrepriseResponse getEntreprise(@PathVariable String id){
        return entrepriseService.get(id);
    }

    @PutMapping(path="/updateentreprise")
    public EntrepriseResponse update(@io.swagger.v3.oas.annotations.parameters.RequestBody EntrepriseRequestDTO entrepriseRequestDTO) {
        return entrepriseService.update(entrepriseRequestDTO);
    }

    @DeleteMapping(path="/deleteentreprise/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        entrepriseService.delete(id);
    }
}
