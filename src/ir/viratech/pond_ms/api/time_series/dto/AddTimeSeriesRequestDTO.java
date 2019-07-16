package ir.viratech.pond_ms.api.time_series.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddTimeSeriesRequestDTO {

	@JsonProperty("pond_uid")
	private String pondUid;
	@JsonProperty("gis_vector_object_uid")
	private String GISVectorObjectUid;
	@JsonProperty("file_format")
	private String fileFormat;
	@JsonProperty("time_series_group_uid")
	private String timeSeriesGroupUid;
	@JsonProperty("file_hash")
	private String fileHash;
	@JsonProperty("reference")
	private String reference;
	@JsonProperty("collection_date")
	private Date collectionDate;
	
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Date getCollectionDate() {
		return collectionDate;
	}
	public void setCollectionDate(Date collectionDate) {
		this.collectionDate = collectionDate;
	}
	public String getPondUid() {
		return pondUid;
	}
	public void setPondUid(String pondUid) {
		this.pondUid = pondUid;
	}

	public String getFileFormat() {
		return fileFormat;
	}
	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}
	public String getTimeSeriesGroupUid() {
		return timeSeriesGroupUid;
	}
	public void setTimeSeriesGroupUid(String timeSeriesGroupUid) {
		this.timeSeriesGroupUid = timeSeriesGroupUid;
	}
	public String getFileHash() {
		return fileHash;
	}
	public void setFileHash(String fileHash) {
		this.fileHash = fileHash;
	}
	public String getGISVectorObjectUid() {
		return GISVectorObjectUid;
	}
	public void setGISVectorObjectUid(String gISVectorObjectUid) {
		GISVectorObjectUid = gISVectorObjectUid;
	}
}
