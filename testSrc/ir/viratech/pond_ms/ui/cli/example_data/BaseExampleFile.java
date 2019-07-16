package ir.viratech.pond_ms.ui.cli.example_data;

import ir.viratech.commons.util.string.CharSetUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;



/**
 * The Class BaseExampleFile.
 */
public abstract class BaseExampleFile {

	//	public static void main(String[] args)  {
	//		addData();
	//	}

	private Properties examplePropertyFile;
	
	/**
	 * Inits the properties.
	 */
	public void initProperties(){
		try {
			if (this.getPropertyFileName() != null)
			{
				this.examplePropertyFile = new Properties();
				this.examplePropertyFile.load(
						new InputStreamReader(
								BaseExampleFile.class.getResourceAsStream(this.getPropertyFileName()), CharSetUtils.CHARSET_UTF8));
			}
			else
			{
				this.examplePropertyFile = null;
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected String getPropertyFileName(){
		return "baseExample.properties";
	}

	protected abstract void addData();

	/**
	 * Execute.
	 */
	public final void execute() {
		this.initProperties();
		this.addData();
		System.out.println("Example data added: " + this.getClass().getName());
	}

	protected final String getProperty(String propertyName) {
		return this.examplePropertyFile.getProperty(propertyName);
	}

	protected final String getProperty(String propertyName, int i) {
		return this.getProperty(propertyName + i);
	}

	protected boolean getBooleanOf(String val) {
		return val.toLowerCase().startsWith("t");
	}

}

