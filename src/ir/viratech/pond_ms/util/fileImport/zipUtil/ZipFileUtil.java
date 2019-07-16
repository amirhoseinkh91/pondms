package ir.viratech.pond_ms.util.fileImport.zipUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;

import ir.viratech.commons.file.model.AbstractFile;

public class ZipFileUtil {

	public String unzip(AbstractFile zipFile) throws IOException {
		String outPath = creatOutPath(zipFile);
		extractFromZip(zipFile, outPath);
		return outPath;
	}

	private String creatOutPath(AbstractFile zipFile) {
		String zipFileName = zipFile.getName();
		String tmp_dir_prefix = zipFileName.substring(0, zipFileName.indexOf(".zip")) + "_";

		// get the default temporary folders path
		String default_tmp = System.getProperty("java.io.tmpdir");

		Path tmpPath = null;
		try {
			// set a prefix
			tmpPath = Files.createTempDirectory(tmp_dir_prefix);

		} catch (IOException e) {
			tmpPath = new File(default_tmp).toPath();
		}
		System.out.println("TMP: " + tmpPath.toString());
		return tmpPath.toString();
	}

	private void extractFromZip(AbstractFile zipFile, String outputFolder) throws IOException {

		byte[] buffer = new byte[1024];

		// create output directory is not exists
		File folder = new File(outputFolder);
		if (!folder.exists()) {
			folder.mkdir();
		}

		// get the zip file content
		ZipInputStream zis = new ZipInputStream(zipFile.getBinaryStream());
		// get the zipped file list entry
		ZipEntry ze = zis.getNextEntry();

		while (ze != null) {

			String fileName = ze.getName();
			File newFile = new File(outputFolder + File.separator + fileName);

			System.out.println("file unzip : " + newFile.getAbsoluteFile());

			// create all non exists folders
			// else you will hit FileNotFoundException for compressed folder
			new File(newFile.getParent()).mkdirs();

			FileOutputStream fos = new FileOutputStream(newFile);

			int len;
			while ((len = zis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}

			fos.close();
			ze = zis.getNextEntry();
		}

		zis.closeEntry();
		zis.close();

		System.out.println("extract done");
	}

	public void deleteFile(String path) {
		try {
			FileUtils.deleteDirectory(new File(path));
		} catch (IOException e) {
		}
		System.out.println("delete done");
	}

}
