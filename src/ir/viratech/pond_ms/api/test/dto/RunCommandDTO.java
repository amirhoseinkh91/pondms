package ir.viratech.pond_ms.api.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class RunCommandDTO.
 */
public class RunCommandDTO {

	private String className;
	
	/**
	 * Gets the class name.
	 *
	 * @return the class name
	 */
	@JsonProperty("class")
	public String getClassName() {
		return this.className;
	}
	
	/**
	 * Sets the class name.
	 *
	 * @param className the new class name
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	private String methodName = "main";
	
	/**
	 * Gets the method name.
	 *
	 * @return the method name
	 */
	@JsonProperty("method")
	public String getMethodName() {
		return this.methodName;
	}
	
	/**
	 * Sets the method name.
	 *
	 * @param methodName the new method name
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+"{" +
				"class: " + this.getClassName()
				+ ", " +
				"method: " + this.getMethodName()
				+"}";
	}
}
