package com.ecom.einvoice.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * @author quanhoang
 * Invoice as a resource
 */
@Entity
@Table
public class Invoice {
	
	@Id
	@Column(name = "INVOICE_ID")
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID invoiceId;
	
	@Column(name = "ORDER_ID")
	private String orderId;
	
	@Column(name = "ORDER_DATE")
	private Timestamp createDate;;
	
	@Column(name = "CUSTOMER_PHONE")
	private String customerPhone;
	
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	
	@Column(name = "SHIPPING_ADDR")
	private String shippingAddress;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "DELIVERY_DATE")
	private Timestamp deliveryDate;
	
	@Column(name = "AMOUNT")
	private double totalAmount;
	
	@Column(name = "STATUS")
	private String status;

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Timestamp getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Timestamp deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UUID getInvoiceId() {
		return invoiceId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
