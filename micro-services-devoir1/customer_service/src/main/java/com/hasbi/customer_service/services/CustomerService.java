package com.hasbi.customer_service.services;

import com.hasbi.customer_service.dto.CustomerRequestDTO;
import com.hasbi.customer_service.dto.CustomerResponseDTO;
import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> listCustomers();
    void deleteCustomer(String id);
}
