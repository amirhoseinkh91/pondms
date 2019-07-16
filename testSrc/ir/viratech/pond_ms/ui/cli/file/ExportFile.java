package ir.viratech.pond_ms.ui.cli.file;

import ir.viratech.commons.file.cli.FileCli;
import ir.viratech.commons.file.model.AbstractFile;
import ir.viratech.commons.file.model.logic.AbstractFileMgr;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

import java.io.File;
import java.io.IOException;

public class ExportFile {
	
	public static void main(String[] args) throws IOException {
		ApplicationContextUtil.initializeCliApplicationContext();
		AbstractFile file = AbstractFileMgr.getInstance().get(1L);
		if (file == null) {
			System.out.println("no file was found.");
			return;
		}
		File outputFile = new File("C:/x.jpg");
		System.out.println("Writing file: "+file+" to "+outputFile);
		FileCli.writeFile(file, outputFile);
		System.out.println("done");
	}
}
