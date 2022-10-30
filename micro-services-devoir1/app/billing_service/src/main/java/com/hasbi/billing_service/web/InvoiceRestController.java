package com.hasbi.billing_service.web;

import com.hasbi.billing_service.dto.InvoiceRequestDTO;
import com.hasbi.billing_service.dto.InvoiceResponseDTO;
import com.hasbi.billing_service.services.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
@AllArgsConstructor
public class InvoiceRestController{
    private InvoiceService invoiceService;

    @GetMapping(path = "/invoices/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String invoiceId){
        return invoiceService.getInvoice(invoiceId);
    }

    @GetMapping(path = "/invoicesByCustomer/{customerId}")
    public List<InvoiceResponseDTO> getInvoicesByCustomer(@PathVariable String customerId){
        return invoiceService.invoicesByCustomerId(customerId);
    }

    @PostMapping(path = "/invoices")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO){
        return invoiceService.save(invoiceRequestDTO);
    }

    @GetMapping(path = "/invoices")
    public List<InvoiceResponseDTO> getInvoices(){
        return invoiceService.allInvoices();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
