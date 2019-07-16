package ir.viratech.pond_ms.ui.cli.file;

import ir.viratech.commons.file.model.AbstractFile;
import ir.viratech.commons.file.model.logic.AbstractFileMgr;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

import java.util.List;

public class ListFiles {

	public static void main(String[] args) {
		ApplicationContextUtil.initializeCliApplicationContext();
		List<AbstractFile> list = AbstractFileMgr.getInstance().list();
		System.out.println("total: "+list.size());
		for (AbstractFile file : list) {
			System.out.println(file);
			System.out.println("\tview: "+file.getFileUrl_ViewMode());
			System.out.println("\tdownload: "+file.getFileUrl_DownloadMode());
		}
	}

}
