package net.dt.packservice.controllers;

import net.dt.packservice.dtos.PackRequestDTO;
import net.dt.packservice.dtos.PackResponseDTO;
import net.dt.packservice.services.PackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/api")
public class PackController {
    private PackService packService;

    public PackController(PackService packService) {
        this.packService = packService;
    }



    @GetMapping(path = "/getpacks")
    public List<PackResponseDTO> allpacks(){
        return packService.list();
    }

    @PostMapping(path = "/savepacks")
    public PackResponseDTO save(@RequestBody PackRequestDTO packRequestDTO){
        return packService.save(packRequestDTO);
    }

    @GetMapping(path = "/getpacks/{id}")
    public  PackResponseDTO getoffres(@PathVariable String id){
        return packService.get(id);
    }

    @PutMapping(path="/updatepacks")
    public PackResponseDTO update(@RequestBody PackRequestDTO packRequestDTO) {
        return packService.update(packRequestDTO);
    }

    @DeleteMapping(path="/deletepacks/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        packService.delete(id);
    }
}
