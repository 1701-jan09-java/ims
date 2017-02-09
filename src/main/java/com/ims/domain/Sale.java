package com.ims.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="ims_retailer_sale")
public class Sale {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="saleSeq")
	@SequenceGenerator(allocationSize=1, name="saleSeq", sequenceName="RET_SALE_SEQ")
	@Column(name="rs_id")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="rs_retailer")
	private Retailer retailer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="rs_product")
	private Product product;
	
	@Column(name="rs_product_quantity")
	private int productQuantity;
	
	@Column(name="rs_cost")
	private double cost;
	
	@Column(name="rs_ts")
	@Temporal(value=TemporalType.DATE)
	private Date saleDate;
	
	public Sale(){}

	public Sale(Retailer retailer, Product product, int productQuantity, double cost, Date saleDate) {
		super();
		this.retailer = retailer;
		this.product = product;
		this.productQuantity = productQuantity;
		this.cost = cost;
		this.saleDate = saleDate;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", retailer=" + retailer + ", product=" + product + ", productQuantity="
				+ productQuantity + ", cost=" + cost + ", saleDate=" + saleDate + "]";
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
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
		result = prime * result + productQuantity;
		result = prime * result + ((retailer == null) ? 0 : retailer.hashCode());
		result = prime * result + ((saleDate == null) ? 0 : saleDate.hashCode());
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
		Sale other = (Sale) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (id != other.id)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productQuantity != other.productQuantity)
			return false;
		if (retailer == null) {
			if (other.retailer != null)
				return false;
		} else if (!retailer.equals(other.retailer))
			return false;
		if (saleDate == null) {
			if (other.saleDate != null)
				return false;
		} else if (!saleDate.equals(other.saleDate))
			return false;
		return true;
	}
	
}
