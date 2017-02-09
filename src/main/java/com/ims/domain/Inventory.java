package com.ims.domain;

import javax.persistence.*;

@Entity
@Table(name="ims_retailer_inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="invSeq")
	@SequenceGenerator(allocationSize=1, name="invSeq", sequenceName="RET_INV_SEQ")
	@Column(name="ri_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ri_retailer")
	private Retailer retailer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ri_product")
	private Product product;
	
	@Column(name="ri_product_quantity")
	private int productQuantity;
	
	@Column(name="ri_product_threshold")
	private int productThreshold;
	
	public Inventory(){}

	public Inventory(Retailer retailer, Product product, int productQuantity, int productThreshold) {
		super();
		this.retailer = retailer;
		this.product = product;
		this.productQuantity = productQuantity;
		this.productThreshold = productThreshold;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", retailer=" + retailer + ", product=" + product + ", productQuantity="
				+ productQuantity + ", productThreshold=" + productThreshold + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getProductThreshold() {
		return productThreshold;
	}

	public void setProductThreshold(int productThreshold) {
		this.productThreshold = productThreshold;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + productQuantity;
		result = prime * result + productThreshold;
		result = prime * result + ((retailer == null) ? 0 : retailer.hashCode());
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
		Inventory other = (Inventory) obj;
		if (id != other.id)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productQuantity != other.productQuantity)
			return false;
		if (productThreshold != other.productThreshold)
			return false;
		if (retailer == null) {
			if (other.retailer != null)
				return false;
		} else if (!retailer.equals(other.retailer))
			return false;
		return true;
	}	
	
}
