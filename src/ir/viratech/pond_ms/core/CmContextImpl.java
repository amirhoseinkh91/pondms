package ir.viratech.pond_ms.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ir.viratech.commons.cm.aspect.creditable.CmCredibilityContextInterface;
import ir.viratech.commons.cm.aspect.private_tag.CmPrivateTagContextInterface;
import ir.viratech.commons.cm.aspect.topic.CmTopicContextInterface;
import ir.viratech.commons.cm.aspect.topic.model.Topic;
import ir.viratech.commons.cm.aspect.topic.model.logic.TopicMgr;
import ir.viratech.commons.cm.core.CmContextInterface;
import ir.viratech.commons.cm.core.UploadedFileNotFoundException;
import ir.viratech.commons.file.model.AbstractFile;
import ir.viratech.commons.file.model.NativeFile;
import ir.viratech.commons.file.model.logic.AbstractFileMgr;
import ir.viratech.commons.file.model.logic.NativeFileMgr;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.model.auth.AccessDeniedException;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.logic.UserMgr;

public class CmContextImpl implements CmContextInterface<CmFileImpl>, CmCredibilityContextInterface, CmTopicContextInterface, CmPrivateTagContextInterface {
	@Override
	public String getUsernameByUid(String uid) throws EntityObjectNotFoundException {
		User user = UserMgr.getInstance().getByExtuid(uid);
		if (user == null)
			return null;
		return user.getUsername();
	}

	@Override
	public String getCurrentUserUsername() {
		return ApplicationContextUtil.getCurrentExecutionContext().getUsername();
	}

	@Override
	public Collection<Topic> getRootOfAccessTopicsForCurrentUser() {
		List<Topic> topics = new ArrayList<Topic>();
		topics.add(TopicMgr.getInstance().getRoot());
		return topics;
	}

	@Override
	public Collection<Topic> getRootOfForbiddenTopicsForCurrentUser() {
		List<Topic> topics = new ArrayList<Topic>();
		return topics;
	}

	@Override
	public String getCurrentUserFirstName() {
		User user = ApplicationContextUtil.getCurrentExecutionContext().getUser();
		if (user == null)
			return null;
		return user.getFirstName();
	}

	@Override
	public String getCurrentUserLastName() {
		User user = ApplicationContextUtil.getCurrentExecutionContext().getUser();
		if (user == null)
			return null;
		return user.getLastName();
	}



	@Override
	public CmFileImpl getFileByHashCodeString(String hashCodeString) {
		AbstractFile abstractFile = AbstractFileMgr.getInstance().getByHashCodeString(hashCodeString);
		if(abstractFile == null)
			return null;
		return new CmFileImpl(abstractFile);

	}

	@Override
	public void addFile(CmFileImpl file) {
		AbstractFileMgr.getInstance().add(file.getFile());

	}

	@Override
	public CmFileImpl createNewFileInstance() {
		NativeFile newFile = NativeFileMgr.getInstance().createNew();
		return new CmFileImpl(newFile);
	}

	private int secretLevel = 4;

	@Override
	public Integer getCurrentUserSecretLevel() {
		return secretLevel;
	}

	public void setSecretLevel(int secretLevel) {
		this.secretLevel = secretLevel;
	}

	private double currentUserCredibility = 1;
	@Override
	public double getCurrentUserCredibility() {
		return currentUserCredibility;
	}
	public void setCurrentUserCredibility(double currentUserCredibility) {
		this.currentUserCredibility = currentUserCredibility;
	}

	@Override
	public CmFileImpl persistTempFile(String tempFileHashCode) throws UploadedFileNotFoundException {
		return this.getFileByHashCodeString(tempFileHashCode);
	}

	@Override
	public long getTempFileSize(String tempFileHashCode) {
		CmFileImpl file = this.getFileByHashCodeString(tempFileHashCode);
		if (file == null)
			return 0;
		else
			return file.getSize();
	}

	@Override
	public String getTempFileName(String tempFileHashCode) {
		CmFileImpl file = this.getFileByHashCodeString(tempFileHashCode);
		if (file == null)
			return null;
		else
			return file.getName();
	}

	@Override
	public void checkAccessToContainer(String container_uid) throws AccessDeniedException {

	}

}