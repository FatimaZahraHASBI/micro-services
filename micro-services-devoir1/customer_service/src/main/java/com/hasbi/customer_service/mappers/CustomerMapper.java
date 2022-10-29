package com.hasbi.customer_service.mappers;

import com.hasbi.customer_service.dto.CustomerRequestDTO;
import com.hasbi.customer_service.dto.CustomerResponseDTO;
import com.hasbi.customer_service.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer CustomerRequestDTOCustomer(CustomerRequestDTO customerRequestDTO);
}
