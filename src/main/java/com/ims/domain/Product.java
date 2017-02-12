package com.ims.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ims_product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="productSeq")
	@SequenceGenerator(allocationSize=1, name="productSeq", sequenceName="PROD_SEQ")
	@Column(name="p_id")
	private int id;
	
	@Column(name="p_name")
	private String name;
	
	@Column(name="p_supplier_price")
	private int supplierPrice;
	
	@Column(name="p_retailer_price")
	private int retailerPrice;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="ims_product_category",
			   joinColumns = {
					   @JoinColumn(name="p_id")
			   },
			   inverseJoinColumns = {
					   @JoinColumn(name="c_id")
			   }
				
			)
	List<Category> categories;
	
	public Product(){}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", supplierPrice=" + supplierPrice + ", retailerPrice="
				+ retailerPrice + ", categories=" + categories + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + retailerPrice;
		result = prime * result + supplierPrice;
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
		Product other = (Product) obj;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (retailerPrice != other.retailerPrice)
			return false;
		if (supplierPrice != other.supplierPrice)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSupplierPrice() {
		return supplierPrice;
	}

	public void setSupplierPrice(int supplierPrice) {
		this.supplierPrice = supplierPrice;
	}

	public int getRetailerPrice() {
		return retailerPrice;
	}

	public void setRetailerPrice(int retailerPrice) {
		this.retailerPrice = retailerPrice;
	}

	@JsonIgnore
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
}
