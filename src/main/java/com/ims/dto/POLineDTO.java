package com.ims.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"prodId","count","cost"})
public class POLineDTO {

	@JsonProperty("prodId")
	private Integer prodId;
	
	@JsonProperty("count")
	private Integer count;

	@JsonProperty("cost")
	private Double cost;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}
	
	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
	
	public POLineDTO(){}
	
	public Integer getProdId() {
		return prodId;
	}
	
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public Integer getCount() {
		return count;
	}
	
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public Double getCost() {
		return cost;
	}
	
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "POLineDTO [prodId=" + prodId + ", count=" + count + ", cost=" + cost + ", additionalProperties="
				+ additionalProperties + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additionalProperties == null) ? 0 : additionalProperties.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((prodId == null) ? 0 : prodId.hashCode());
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
		POLineDTO other = (POLineDTO) obj;
		if (additionalProperties == null) {
			if (other.additionalProperties != null)
				return false;
		} else if (!additionalProperties.equals(other.additionalProperties))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (prodId == null) {
			if (other.prodId != null)
				return false;
		} else if (!prodId.equals(other.prodId))
			return false;
		return true;
	}

}
