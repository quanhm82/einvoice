package com.ecom.einvoice.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.ecom.einvoice.model.Invoice;

/**
 * @author quanhoang
 * Rest Repository for Invoice resource
 */
@RepositoryRestResource(path = "invoice", itemResourceRel = "invoice", collectionResourceRel = "invoices")
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, UUID> {
	
	@RestResource(path = "byInvoiceNumber")
	Invoice findByInvoiceNumberEqualsIgnoreCase(String invoiceNumber);
}
