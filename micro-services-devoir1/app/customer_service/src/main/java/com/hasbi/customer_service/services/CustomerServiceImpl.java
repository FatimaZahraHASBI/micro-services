package com.hasbi.customer_service.services;

import com.hasbi.customer_service.dto.CustomerRequestDTO;
import com.hasbi.customer_service.dto.CustomerResponseDTO;
import com.hasbi.customer_service.entities.Customer;
import com.hasbi.customer_service.mappers.CustomerMapper;
import com.hasbi.customer_service.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional @AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;
    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.CustomerRequestDTOCustomer(customerRequestDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(savedCustomer);
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.CustomerRequestDTOCustomer(customerRequestDTO);
        Customer updatedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(updatedCustomer);
    }

    @Override
    public List<CustomerResponseDTO> listCustomers() {
        List<Customer> customers=customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOList =
                customers.stream()
                        .map(cust->customerMapper.customerToCustomerResponseDTO(cust))
                        .collect(Collectors.toList());
        return customerResponseDTOList;
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}
