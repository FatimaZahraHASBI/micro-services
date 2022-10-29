package com.hasbi.billing_service.mappers;

import com.hasbi.billing_service.dto.InvoiceRequestDTO;
import com.hasbi.billing_service.dto.InvoiceResponseDTO;
import com.hasbi.billing_service.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice);
}
