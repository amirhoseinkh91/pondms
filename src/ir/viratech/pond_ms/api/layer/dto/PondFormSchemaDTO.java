package ir.viratech.pond_ms.api.layer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PondFormSchemaDTO {

	@JsonProperty("form_key")
	private String key;
	
	@JsonProperty("is_secret")
	private boolean secret;
	
	@JsonProperty("form_schema")
	private String entitySchema;
	
	public String getKey() {
		return key;
	}
	
	public boolean isSecret() {
		return secret;
	}
	
	public String getEntitySchema() {
		return entitySchema;
	}

	public PondFormSchemaDTO() {
	}
	
	public PondFormSchemaDTO(String key, boolean secrecy, String schema) {
		this.entitySchema = schema;
		this.secret = secrecy;
		this.key = key;
	}
}
