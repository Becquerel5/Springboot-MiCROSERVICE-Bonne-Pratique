package net.dt.hosting.mapper;

import net.dt.hosting.dto.SubscriptionRequestDTO;
import net.dt.hosting.dto.SubscriptionResponseDTO;
import net.dt.hosting.entities.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper{
    SubscriptionResponseDTO subscriptionToSubscriptionResponseDTO(Subscription subscription);
    Subscription subscriptionRequestDTOSubscription(SubscriptionRequestDTO subscriptionRequestDTO);
}
