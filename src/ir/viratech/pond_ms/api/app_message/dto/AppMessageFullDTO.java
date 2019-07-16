package ir.viratech.pond_ms.api.app_message.dto;

import ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException;
import ir.viratech.commons.file.model.AbstractFile;
import ir.viratech.commons.file.model.logic.AbstractFileMgr;
import ir.viratech.pond_ms.api.app_message.base.BaseAppMessageFullDTO;
import ir.viratech.pond_ms.model.app_message.AppMessage;
import ir.viratech.pond_ms.model.app_message.AppMessageUrl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * A DTO for class AppMessage.
 *
 */
public class AppMessageFullDTO extends BaseAppMessageFullDTO {

	@Override
	protected Set<String> load_Images(AppMessage appMessage) {
		Set<String> images = new HashSet<>();
		for (AbstractFile file: appMessage.getCreatedImages()) {
			images.add(file.getHashCodeString());
		}
		return images;
	}

	@Override
	protected void save_Images(AppMessage appMessage, Set<String> images) throws BadDtoEntityModificationException {
		appMessage.getCreatedImages().clear();
		for (String imageHash :images) {
			AbstractFile file = AbstractFileMgr.getInstance().getByHashCodeString(imageHash);
			appMessage.addToImages(file);
		}
	}

	/**
	 * FieldInfoContext for AppMessageFullDTO
	 */
	public static class FieldInfoContext extends BaseAppMessageFullDTO.BaseFieldInfoContext {

	}

	@Override
	protected List<String> load_Urls(AppMessage appMessage) {
		List<String> result = new ArrayList<>();
		for (AppMessageUrl appMessageUrl : appMessage.getUrls())
			result.add(appMessageUrl.getUrl());
		return result;
	}

	@Override
	protected void save_Urls(AppMessage appMessage, List<String> urls) throws BadDtoEntityModificationException {
		appMessage.getCreatedUrls().clear();
		for (String url : urls)
			appMessage.addToUrls(url);
	}

}
