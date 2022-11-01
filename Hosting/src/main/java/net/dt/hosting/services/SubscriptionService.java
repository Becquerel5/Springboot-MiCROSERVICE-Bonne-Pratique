package net.dt.hosting.services;

import net.dt.hosting.dto.SubscriptionRequestDTO;
import net.dt.hosting.dto.SubscriptionResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;


public interface SubscriptionService  {
    SubscriptionResponseDTO save(SubscriptionRequestDTO subscriptionRequestDTO);
    SubscriptionResponseDTO getSubscription(String id);
    SubscriptionResponseDTO update(SubscriptionRequestDTO subscriptionRequestDTO);
    List<SubscriptionResponseDTO> listSubscription();
    void delete(String id);
}
