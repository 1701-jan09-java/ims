package com.ims.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"retId","supId","lines","cost"})
public class PurchaseOrderDTO {
	
	@JsonProperty("retId")
	private Integer retId;
	
	@JsonProperty("supId")
	private Integer supId;
	
	@JsonProperty("cost")
	private Double cost;
	
	@JsonProperty("lines")
	private List<POLineDTO> lines = null;
	
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
	
	public PurchaseOrderDTO(){}
	
	public Integer getRetId() {
		return retId;
	}
	
	public void setRetId(Integer retId) {
		this.retId = retId;
	}
	
	public Integer getSupId() {
		return supId;
	}
	
	public void setSupId(Integer supId) {
		this.supId = supId;
	}
	
	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public List<POLineDTO> getLines() {
		return lines;
	}
	
	public void setLines(List<POLineDTO> lines) {
		this.lines = lines;
	}
	
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	
	@Override
	public String toString() {
		return "PurchaseOrderDTO [retId=" + retId + ", supId=" + supId + ", lines=" + lines + ", additionalProperties="
				+ additionalProperties + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additionalProperties == null) ? 0 : additionalProperties.hashCode());
		result = prime * result + ((lines == null) ? 0 : lines.hashCode());
		result = prime * result + ((retId == null) ? 0 : retId.hashCode());
		result = prime * result + ((supId == null) ? 0 : supId.hashCode());
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
		PurchaseOrderDTO other = (PurchaseOrderDTO) obj;
		if (additionalProperties == null) {
			if (other.additionalProperties != null)
				return false;
		} else if (!additionalProperties.equals(other.additionalProperties))
			return false;
		if (lines == null) {
			if (other.lines != null)
				return false;
		} else if (!lines.equals(other.lines))
			return false;
		if (retId == null) {
			if (other.retId != null)
				return false;
		} else if (!retId.equals(other.retId))
			return false;
		if (supId == null) {
			if (other.supId != null)
				return false;
		} else if (!supId.equals(other.supId))
			return false;
		return true;
	}

}
