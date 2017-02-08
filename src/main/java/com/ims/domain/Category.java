package com.ims.domain;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="ims_category")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="categorySeq")
	@SequenceGenerator(allocationSize=1, name="categorySeq", sequenceName="CAT_SEQ")
	@Column(name="c_id")
	private Integer id;
	
	@Column(name="c_name")
	private String name;
	
	@ManyToMany(mappedBy="categories", fetch=FetchType.EAGER)
	List<Product> products;
	
	public Category(){}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", products=" + products + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
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
		Category other = (Category) obj;
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
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
}
