package ir.viratech.pond_ms.api.app_message.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ir.viratech.commons.file.model.AbstractFile;
import ir.viratech.pond_ms.api.app_message.base.BaseAppMessageViewDTO;
import ir.viratech.pond_ms.model.app_message.AppMessage;
import ir.viratech.pond_ms.model.app_message.AppMessageUrl;


/**
 * A DTO for class AppMessage.
 *
 */
public class AppMessageViewDTO extends BaseAppMessageViewDTO {


    @Override
    protected Set<String> load_Images(AppMessage appMessage) {
        Set<String> images = new HashSet<>();
        for (AbstractFile file: appMessage.getCreatedImages()) {
            images.add(file.getHashCodeString());
        }
        return images;
    }

	@Override
	protected List<String> load_Urls(AppMessage appMessage) {
		List<String> result = new ArrayList<>();
		for (AppMessageUrl appMessageUrl : appMessage.getUrls())
			result.add(appMessageUrl.getUrl());
		return result;
	}

}
