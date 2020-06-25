package com.ecom.einvoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EInvoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EInvoiceApplication.class, args);
	}

}
