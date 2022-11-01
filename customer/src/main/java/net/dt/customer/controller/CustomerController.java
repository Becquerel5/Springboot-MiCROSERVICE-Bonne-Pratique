package net.dt.customer.controller;


import net.dt.customer.dtos.CustomerRequestDTO;
import net.dt.customer.dtos.CustomerResponseDTO;
import net.dt.customer.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/getcustomers")
    public List<CustomerResponseDTO> allcustomers(){
        return customerService.list();
    }

    @PostMapping(path = "/savecustomers")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerService.save(customerRequestDTO);
    }

    @GetMapping(path = "/getcustomers/{id}")
    public  CustomerResponseDTO getCustomer(@PathVariable String id){
        return customerService.get(id);
    }

    @PutMapping(path="/updatecustomers")
    public CustomerResponseDTO update(@io.swagger.v3.oas.annotations.parameters.RequestBody CustomerRequestDTO customerRequestDTO) {
        return customerService.update(customerRequestDTO);
    }

    @DeleteMapping(path="/deletecustomers/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        customerService.delete(id);
    }
}
