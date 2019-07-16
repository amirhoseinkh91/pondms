package ir.viratech.just_ro.model.version;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Version {

	
	///version model why is not added to git
	@JsonProperty
	private boolean isCritical;
	@JsonProperty
	private String androidVersion;
	@JsonProperty
	private String serverVersion;

	public Version(boolean isCritical, String androidVersion, String serverVersion) {
		this.isCritical = isCritical;
		this.androidVersion = androidVersion;
		this.serverVersion = serverVersion;
	}
	
	public Version()
	{
		
	}

	public boolean getIsCritical() {
		return isCritical;
	}

	public void setIsCritical(boolean isCritical) {
		this.isCritical = isCritical;
	}

	public String getAndroidVersion() {
		return androidVersion;
	}

	public void setAndroidVersion(String androidVersion) {
		this.androidVersion = androidVersion;
	}

	public String getServerVersion() {
		return serverVersion;
	}

	public void setServerVersion(String serverVersion) {
		this.serverVersion = serverVersion;
	}

}
