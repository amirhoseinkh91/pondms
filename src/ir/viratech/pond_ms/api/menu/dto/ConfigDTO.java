package ir.viratech.pond_ms.api.menu.dto;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.User;

/**
 * The Class ConfigDTO.
 */
public class ConfigDTO {

	/**
	 * The Class UserConfigDto.
	 */
	public static class UserConfigDto {

		private String uid;

		@JsonProperty
		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
		}

		private String title;

		@JsonProperty
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		private String userFullName;

		/**
		 * Gets the user full name.
		 *
		 * @return the user full name
		 */
		@JsonProperty
		public String getUserFullName() {
			return this.userFullName;
		}

		/**
		 * Sets the user full name.
		 *
		 * @param userFullName
		 *            the new user full name
		 */
		public void setUserFullName(String userFullName) {
			this.userFullName = userFullName;
		}

		private Set<String> features;

		/**
		 * Gets the features.
		 *
		 * @return the features
		 */
		@JsonProperty
		public Set<String> getFeatures() {
			return this.features;
		}

		/**
		 * Sets the features.
		 *
		 * @param features
		 *            the new features
		 */
		public void setFeatures(Set<String> features) {
			this.features = features;
		}

		private boolean passwordExpired;

		@JsonProperty
		public boolean isPasswordExpired() {
			return passwordExpired;
		}

		public void setPasswordExpired(boolean passwordExpired) {
			this.passwordExpired = passwordExpired;
		}

		private String orguid;
		@JsonProperty
		public String getOrguid() {
			return orguid;
		}

		public void setOrguid(String orguid) {
			this.orguid = orguid;
		}

		/**
		 * Instantiates a new user config dto.
		 *
		 * @param u
		 *            the u
		 */
		public UserConfigDto(User u) {
			this.features = new HashSet<String>();
			if (u != null) {
				this.setUid(u.getExtuid());
				this.setTitle(u.getDisplayString());
				this.setUserFullName(u.getDisplayString());
				this.setPasswordExpired(u.isPasswordExpired());
				if (u.getOrganization() != null)
					this.setOrguid(u.getOrganization().getExtuid());
				for (Feature feature : u.getExposableFeatures()) {
					this.features.add(feature.getName());
				}
			}
		}

	}

	@JsonProperty
	UserConfigDto userConfig;
	@JsonProperty
	Map<String, String> dynamicConfig;
	@JsonProperty
	ObjectNode config;

	/**
	 * Instantiates a new config dto.
	 */
	public ConfigDTO() {
		this.config = new ObjectMapper().createObjectNode();// TODO: Think about
															// the configuration
															// of the
															// ObjectMapper
	}

	/**
	 * Sets the dynamic config.
	 *
	 * @param dynamicConfig
	 *            the dynamic config
	 */
	public void setDynamicConfig(Map<String, String> dynamicConfig) {
		this.dynamicConfig = dynamicConfig;
	}

	/**
	 * Gets the dynamic config.
	 *
	 * @return the dynamic config
	 */
	public Map<String, String> getDynamicConfig() {
		return this.dynamicConfig;
	}

	/**
	 * Sets the user config.
	 *
	 * @param user
	 *            the new user config
	 */
	public void setUserConfig(User user) {
		this.userConfig = new UserConfigDto(user);
	}

	/**
	 * Gets the user config.
	 *
	 * @return the user config
	 */
	public UserConfigDto getUserConfig() {
		return this.userConfig;
	}

	/**
	 * Gets the config.
	 *
	 * @return the config
	 */
	public ObjectNode getConfig() {
		return this.config;
	}

	/**
	 * Put config.
	 *
	 * @param key
	 *            the key
	 * @param config
	 *            the config
	 */
	public void putConfig(String key, ObjectNode config) {
		this.config.put(key, config);
	}

	/**
	 * Put server config.
	 *
	 * @param key
	 *            the key
	 * @param protocol
	 *            the protocol
	 * @param port
	 *            the port
	 * @param host
	 *            the host
	 * @param contextPath
	 *            the context path
	 */
	public void putServerConfig(String key, String protocol, String port, String host, String contextPath) {
		ObjectNode on = new ObjectMapper().createObjectNode();
		on.put("protocol", protocol);
		on.put("port", port);
		on.put("host", host);
		on.put("contextPath", contextPath);
		this.config.put(key, on);
	}
}
