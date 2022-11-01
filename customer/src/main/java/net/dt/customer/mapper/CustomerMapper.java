package net.dt.customer.mapper;

import net.dt.customer.dtos.CustomerRequestDTO;
import net.dt.customer.dtos.CustomerResponseDTO;
import net.dt.customer.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerResponseDTO customerTocustomerResponseDTO(Customer customer);
    Customer customerRequestDTOcustomer(CustomerRequestDTO customerRequestDTO);
}
