package com.ims.dto;

import java.util.ArrayList;
import java.util.List;

import com.ims.domain.Category;
import com.ims.domain.Product;

public class ProductDTO {

	private int id;
	
	private String name;
	
	private int supplierPrice;
	
	private int retailerPrice;
	
	private List<SimpleCategory> categories;
	
	public ProductDTO(){}
	
	public class SimpleCategory {
		private int c_id;
		private String c_name;
		
		public SimpleCategory(){}
		
		public SimpleCategory(Category category) {
			c_id = category.getId();
			c_name = category.getName();
		}

		@Override
		public String toString() {
			return "SimpleCategory [c_id=" + c_id + ", c_name=" + c_name + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + c_id;
			result = prime * result + ((c_name == null) ? 0 : c_name.hashCode());
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
			SimpleCategory other = (SimpleCategory) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (c_id != other.c_id)
				return false;
			if (c_name == null) {
				if (other.c_name != null)
					return false;
			} else if (!c_name.equals(other.c_name))
				return false;
			return true;
		}

		private ProductDTO getOuterType() {
			return ProductDTO.this;
		}

		public int getC_id() {
			return c_id;
		}

		public void setC_id(int c_id) {
			this.c_id = c_id;
		}

		public String getC_name() {
			return c_name;
		}

		public void setC_name(String c_name) {
			this.c_name = c_name;
		}


		
		
		
		
	}
	
	public ProductDTO(Product product){
		this.id=product.getId();
		this.name=product.getName();
		this.supplierPrice=product.getSupplierPrice();
		this.retailerPrice=product.getRetailerPrice();
		this.categories = new ArrayList<SimpleCategory>();
		
		for (Category category: product.getCategories()) {
			this.categories.add(new SimpleCategory(category));
		}
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", supplierPrice=" + supplierPrice + ", retailerPrice="
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
		ProductDTO other = (ProductDTO) obj;
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

	public List<SimpleCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<SimpleCategory> categories) {
		this.categories = categories;
	}
	
	
//	public Product convertToDomain() {
//		Product product = new Product();
//		product.setId(id);
//		product.setName(name);
//		product.setRetailerPrice(retailerPrice);
//		product.setSupplierPrice(supplierPrice);
//		product.setCategories(CategoryLogic.getAllCategoriesByProduct(id));
//		return product;
//	}
	
	
	
}
