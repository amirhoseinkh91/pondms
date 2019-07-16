package ir.viratech.pond_ms.api.customer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppConfigDTO {
	@JsonProperty
	public String getCriticalForVersionsBelow() {
		return "";
	}
	
	@JsonProperty
	public String getCurrentServerVersion() {
		return "200";
	}
}
