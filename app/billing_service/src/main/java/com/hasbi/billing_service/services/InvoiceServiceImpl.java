package com.hasbi.billing_service.services;

import com.hasbi.billing_service.dto.InvoiceRequestDTO;
import com.hasbi.billing_service.dto.InvoiceResponseDTO;
import com.hasbi.billing_service.entities.Customer;
import com.hasbi.billing_service.entities.Invoice;
import com.hasbi.billing_service.exceptions.CustomerNotFoundException;
import com.hasbi.billing_service.mappers.InvoiceMapper;
import com.hasbi.billing_service.openfeign.CustomerRestClient;
import com.hasbi.billing_service.repositories.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    private InvoiceMapper mapper;
    private CustomerRestClient customerRestClient;

    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        Customer customer=null;
        try {
            customer = customerRestClient.getCustomer(invoiceRequestDTO.getCustomerID());
        }catch (Exception e){
            throw new CustomerNotFoundException("Customer not found");
        }
        Invoice invoice = mapper.fromInvoiceRequestDTO(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        Invoice savedInvoice = invoiceRepository.save(invoice);
        savedInvoice.setCustomer(customer);
        return mapper.fromInvoice(savedInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).get();
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerID());
        invoice.setCustomer(customer);
        return mapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> invoicesByCustomerId(String customerId) {
        List<Invoice> invoices = invoiceRepository.findByCustomerID(customerId);
        for (Invoice invoice: invoices){
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerID());
            invoice.setCustomer(customer);
        }
        return invoices
                .stream()
                .map(invoice -> mapper.fromInvoice(invoice))
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> allInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        for (Invoice invoice: invoices){
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerID());
            invoice.setCustomer(customer);
        }
        return invoices.stream().map(invoice -> mapper.fromInvoice(invoice)).collect(Collectors.toList());
    }
}
