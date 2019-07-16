package ir.viratech.pond_ms.api.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RunCommandResultDTO {
	
	private String resultString;
	@JsonProperty
	public String getResultString() {
		return resultString;
	}
	public void setResultString(String resultString) {
		this.resultString = resultString;
	}
	
	private String exceptionStackTrace;
	@JsonProperty
	public String getExceptionStackTrace() {
		return exceptionStackTrace;
	}
	public void setExceptionStackTrace(String exceptionStackTrace) {
		this.exceptionStackTrace = exceptionStackTrace;
	}
	
}
