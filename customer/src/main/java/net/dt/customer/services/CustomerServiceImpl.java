package net.dt.customer.services;

import net.dt.customer.dtos.CustomerRequestDTO;
import net.dt.customer.dtos.CustomerResponseDTO;
import net.dt.customer.entities.Customer;
import net.dt.customer.mapper.CustomerMapper;
import net.dt.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }


    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer customer=customerMapper.customerRequestDTOcustomer(customerRequestDTO);
        Customer saveCustomer=customerRepository.save(customer);
        CustomerResponseDTO customerResponseDTO = customerMapper.customerTocustomerResponseDTO(saveCustomer);
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO get(String id) {
        Customer customer = customerRepository.findById(id).get();
        return customerMapper.customerTocustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDTOcustomer(customerRequestDTO);
        Customer updateCustomer = customerRepository.save(customer);
        return customerMapper.customerTocustomerResponseDTO(updateCustomer);
    }

    @Override
    public List<CustomerResponseDTO> list() {
        List<Customer> customers=customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOS=
                customers.stream()
                        .map(cus->customerMapper.customerTocustomerResponseDTO(cus))
                        .collect(Collectors.toList());
        return customerResponseDTOS;
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);

    }
}
