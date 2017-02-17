package com.ims.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="ims_purchase_order")
public class PurchaseOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="poSeq")
	@SequenceGenerator(allocationSize=1, name="poSeq", sequenceName="PURCH_ORDER_SEQ")
	@Column(name="po_id")
	private int id;
	
	@Column(name="po_ts")
	@Temporal(value=TemporalType.DATE)
	private Date purchaseDate;
	
	@ManyToOne
	@JoinColumn(name="po_supplier")
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name="po_retailer")
	private Retailer retailer;
	
	@Column(name="po_cost")
	private double cost;	
	
	public PurchaseOrder(){}

	public PurchaseOrder(Date purchaseDate, Supplier supplier, Retailer retailer, double cost) {
		super();
		this.purchaseDate = purchaseDate;
		this.supplier = supplier;
		this.retailer = retailer;
		this.cost = cost;
	}
	
	public PurchaseOrder(Supplier supplier, Retailer retailer, double cost) {
		super();
		this.supplier = supplier;
		this.retailer = retailer;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", purchaseDate=" + purchaseDate + ", supplier=" + supplier + ", retailer="
				+ retailer + ", cost=" + cost + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + ((retailer == null) ? 0 : retailer.hashCode());
		result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseOrder other = (PurchaseOrder) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (id != other.id)
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (retailer == null) {
			if (other.retailer != null)
				return false;
		} else if (!retailer.equals(other.retailer))
			return false;
		if (supplier == null) {
			if (other.supplier != null)
				return false;
		} else if (!supplier.equals(other.supplier))
			return false;
		return true;
	}	

}
