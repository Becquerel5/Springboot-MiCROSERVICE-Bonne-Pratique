package net.dt.hosting.controller;

import net.dt.hosting.dto.SubscriptionRequestDTO;
import net.dt.hosting.dto.SubscriptionResponseDTO;
import net.dt.hosting.services.SubscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/api/subscription")
public class SubscriptionController {
    private SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping(path = "/retrievesubscription")
    public List<SubscriptionResponseDTO> allsubscription(){
        return subscriptionService.listSubscription();
    }

    @PostMapping(path = "/savesubscription")
    public SubscriptionResponseDTO save(@RequestBody SubscriptionRequestDTO subscriptionRequestDTO){
        return subscriptionService.save(subscriptionRequestDTO);
    }

    @GetMapping(path = "/retrievesubscription/{id}")
    public  SubscriptionResponseDTO getSubscription(@PathVariable String id){
        return subscriptionService.getSubscription(id);
    }

    @DeleteMapping(path="/subscriptiondelete/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        subscriptionService.delete(id);
    }

    @PutMapping(path="/subscriptionupdate")
    public SubscriptionResponseDTO update(@RequestBody SubscriptionRequestDTO subscriptionRequestDTO) {
        return subscriptionService.update(subscriptionRequestDTO);
    }
}
