package ir.viratech.pond_ms.core.i18n;

import ir.viratech.commons.util.i18n.AbstractMessageTranslatorWithLocaleCache;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

import java.util.Locale;

/**
 * MessageTranslator which finds the current locale based on the current user.
 *
 */
public class MessageTranslatorWithUserLocale extends AbstractMessageTranslatorWithLocaleCache {
	
	/**
	 * Default constructor for MessageTranslatorWithUserLocale.
	 */
	public MessageTranslatorWithUserLocale() {
		super(ApplicationContextUtil.getApplicationContext());
	}

	/**
	 * Provides the current locale based on the current user.
	 * @return the current locale
	 */
	@Override
	protected Locale getCurrentLocale() {
		return MessageService.getUserLocale();
	}

}
