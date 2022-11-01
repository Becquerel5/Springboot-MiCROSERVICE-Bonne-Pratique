package net.dt.hosting.services;

import net.dt.hosting.dto.SubscriptionRequestDTO;
import net.dt.hosting.dto.SubscriptionResponseDTO;
import net.dt.hosting.entities.Subscription;
import net.dt.hosting.exception.ResourceNotFoundException;
import net.dt.hosting.mapper.SubscriptionMapper;
import net.dt.hosting.repositories.SubscriptionRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {
    SubscriptionRepository subscriptionRepository;
    SubscriptionMapper subscriptionMapper;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository, SubscriptionMapper subscriptionMapper) {
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionMapper = subscriptionMapper;
    }

    @Override
    public SubscriptionResponseDTO save(SubscriptionRequestDTO subscriptionRequestDTO) {
        try {
            Subscription subscription=subscriptionMapper.subscriptionRequestDTOSubscription(subscriptionRequestDTO);
            Subscription saveSubscription=subscriptionRepository.save(subscription);

            SubscriptionResponseDTO subscriptionResponseDTO = subscriptionMapper.subscriptionToSubscriptionResponseDTO(saveSubscription);
            return subscriptionResponseDTO;
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Cannot save this subscription");
        }

    }

    @Override
    public SubscriptionResponseDTO getSubscription(String id) {
        try {
            Subscription subscription = subscriptionRepository.findById(id).get();
            return subscriptionMapper.subscriptionToSubscriptionResponseDTO(subscription);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Cannot retrieve this subscription");
        }


    }

    @Override
    public SubscriptionResponseDTO update(SubscriptionRequestDTO subscriptionRequestDTO) {
        try {
            Subscription subscription = subscriptionMapper.subscriptionRequestDTOSubscription(subscriptionRequestDTO);
            Subscription updateSubscription = subscriptionRepository.save(subscription);
            return subscriptionMapper.subscriptionToSubscriptionResponseDTO(updateSubscription);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Cannot update this subscription");
        }

    }

    @Override
    public List<SubscriptionResponseDTO> listSubscription() {
        try {
            List<Subscription> subscriptions=subscriptionRepository.findAll();
            List<SubscriptionResponseDTO> subscriptionResponseDTOS=
                    subscriptions.stream()
                            .map(sub->subscriptionMapper.subscriptionToSubscriptionResponseDTO(sub))
                            .collect(Collectors.toList());
            return subscriptionResponseDTOS;
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Cannot show this subscriptions lists");
        }

    }

    @Override
    public void delete(String id) {
        try {
            subscriptionRepository.deleteById(id);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Cannot delete this subscription");
        }

    }
}
