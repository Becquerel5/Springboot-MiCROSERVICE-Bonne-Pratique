package net.dt.hosting.controller;

import net.dt.hosting.dto.RenewRequestDTO;
import net.dt.hosting.dto.RenewResponseDTO;
import net.dt.hosting.services.RenewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/api/renew")
public class RenewController {

    private RenewService renewService;

    public RenewController(RenewService renewService) {
        this.renewService = renewService;
    }

    @GetMapping(path = "/retrieverenew")
    public List<RenewResponseDTO> allrenews(){
        return renewService.listRenew();
    }

    @PostMapping(path = "/saverenew")
    public RenewResponseDTO save(@RequestBody RenewRequestDTO renewRequestDTO){
        return renewService.save(renewRequestDTO);
    }


    @GetMapping(path = "/retrieverenew/{id}")
    public  RenewResponseDTO getRenew(@PathVariable String id){
        return renewService.getRenew(id);
    }

    @DeleteMapping(path="/renewdelete/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        renewService.delete(id);
    }

    @PutMapping(path="/renewupdate")
    public RenewResponseDTO update(@RequestBody RenewRequestDTO renewRequestDTO) {
        return renewService.update(renewRequestDTO);
    }
}
