package ir.viratech.pond_ms.api.layer.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import ir.viratech.pond_ms.model.file.DataFile;

public class DataFileDTO {

	public static final String TYPE__RASTER = "raster";
	public static final String TYPE__VECTOR = "vector";

	@JsonProperty("reference")
	private String reference;

	@JsonProperty("layer_uid")
	private String layerUID;

	@JsonProperty("date")
	private Date date;

	@JsonProperty("type")
	private String type;

	@JsonProperty("file_hash")
	private String hashCode;

	@JsonProperty("uid")
	private String fileUID;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getLayerUID() {
		return layerUID;
	}

	public void setLayerUID(String layerUID) {
		this.layerUID = layerUID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	public String getFileUID() {
		return fileUID;
	}

	public void setFileUID(String fileUID) {
		this.fileUID = fileUID;
	}

	public void loadFrom(DataFile file) {
		this.setDate(file.getDataCollectionDate());
		this.setReference(file.getDataReference());
		this.setHashCode(file.getAbstractFile().getHashCodeString());
		this.setType(file.getAbstractFile().getContentType());
		this.setFileUID(file.getExtuid());
	}

	public void saveTo(DataFile file) {
		// TODO Implement this method and use it properly
	}

}
