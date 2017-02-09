package com.ims.domain;

import javax.persistence.*;

@Entity
@Table(name="ims_po_line")
public class PurchaseOrderLine {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="poLineSeq")
	@SequenceGenerator(allocationSize=1, name="poLineSeq", sequenceName="PO_LINE_SEQ")
	@Column(name="pol_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pol_po")
	private PurchaseOrder purchaseOrder;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pol_product")
	private Product product;
	
	@Column(name="pol_quantity")
	private int quantity;
	
	@Column(name="pol_cost")
	private double cost;
	
	public PurchaseOrderLine(){}

	public PurchaseOrderLine(PurchaseOrder purchaseOrder, Product product, int quantity, double cost) {
		super();
		this.purchaseOrder = purchaseOrder;
		this.product = product;
		this.quantity = quantity;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "PurchaseOrderLine [id=" + id + ", purchaseOrder=" + purchaseOrder + ", product=" + product
				+ ", quantity=" + quantity + ", cost=" + cost + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((purchaseOrder == null) ? 0 : purchaseOrder.hashCode());
		result = prime * result + quantity;
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
		PurchaseOrderLine other = (PurchaseOrderLine) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (id != other.id)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (purchaseOrder == null) {
			if (other.purchaseOrder != null)
				return false;
		} else if (!purchaseOrder.equals(other.purchaseOrder))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
	
	
}
