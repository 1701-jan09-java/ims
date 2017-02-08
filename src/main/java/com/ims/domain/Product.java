package com.ims.domain;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="ims_product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="productSeq")
	@SequenceGenerator(allocationSize=1, name="productSeq", sequenceName="PROD_SEQ")
	@Column(name="p_id")
	private Integer id;
	
	@Column(name="p_name")
	private String name;
	
	@Column(name="p_supplier_price")
	private String supplierPrice;
	
	@Column(name="p_retailer_price")
	private String retailerPrice;
	
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((retailerPrice == null) ? 0 : retailerPrice.hashCode());
		result = prime * result + ((supplierPrice == null) ? 0 : supplierPrice.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (retailerPrice == null) {
			if (other.retailerPrice != null)
				return false;
		} else if (!retailerPrice.equals(other.retailerPrice))
			return false;
		if (supplierPrice == null) {
			if (other.supplierPrice != null)
				return false;
		} else if (!supplierPrice.equals(other.supplierPrice))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupplierPrice() {
		return supplierPrice;
	}

	public void setSupplierPrice(String supplierPrice) {
		this.supplierPrice = supplierPrice;
	}

	public String getRetailerPrice() {
		return retailerPrice;
	}

	public void setRetailerPrice(String retailerPrice) {
		this.retailerPrice = retailerPrice;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
}
