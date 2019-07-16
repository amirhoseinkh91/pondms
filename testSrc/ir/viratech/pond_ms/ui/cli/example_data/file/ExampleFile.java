package ir.viratech.pond_ms.ui.cli.example_data.file;

import ir.viratech.commons.file.cli.FileCli;
import ir.viratech.commons.file.model.AbstractFile;
import ir.viratech.base.AbstractEntityDAO;
import ir.viratech.pond_ms.ui.cli.example_data.BaseExampleFile;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FilenameUtils;

/**
 * The Class ExampleRole.
 */
public class ExampleFile extends BaseExampleFile{

	@Override
	protected void addData() {
		AbstractEntityDAO.touchSession();
		addFile("ali.jpg", "image/jpeg");
		addFile("sampleText.txt", "text/html");
	}

	private void addFile(String resourceName, String contentType) {
		String name = FilenameUtils.getName(resourceName);
		URL resource = ExampleFile.class.getResource(resourceName);
		try {
			AbstractFile file = FileCli.addFile(contentType, name, resource);
			System.out.println("download link:" + file.getFileUrl_DownloadMode());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String... args) {
		new ExampleFile().addData();
	}

}
