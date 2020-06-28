package com.ecom.einvoice.eventhandler;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.ecom.einvoice.feign.EOrderFeignClient;
import com.ecom.einvoice.model.Invoice;
import com.ecom.einvoice.repository.InvoiceRepository;

/**
 * @author quanhoang
 * Handler for events of Invoice entity
 */
@Component
@RepositoryEventHandler(Invoice.class)
public class InvoiceEventHandler {
	Logger logger = LoggerFactory.getLogger(InvoiceEventHandler.class);
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired
	EOrderFeignClient eOrderFeignClient;

	/**
	 * @param invoice
	 * Calling eOrder service to create shipment if status is confirmed
	 * Assume that each invoice only confirmed one time
	 */
	@HandleBeforeSave
	public void handlerInvoiceConfirmStatus(Invoice invoice) {
		logger.info("Invoice {} has changes", invoice.getInvoiceNumber());
		
		if (invoice.getStatus().equalsIgnoreCase("confirmed")) {
			logger.info("Trigger calling Feign to confirm invoice {}", invoice.getInvoiceId());
			eOrderFeignClient.invoiceToShipment(UUID.fromString(invoice.getOrderId()), invoice.getInvoiceNumber());
		}
	}
}
