package ir.viratech.pond_ms.core.i18n;


import ir.viratech.commons.util.i18n.MessageServiceUtil;
import ir.viratech.commons.util.i18n.MessageTranslator;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

import java.util.Locale;

/**
 * Utility class for creating i18n messages.
 */
public final class MessageService {

	private MessageService() {
		// private constructor added to hide the implicit public one
		super();
	}

	/**
	 * Gets the message.
	 *
	 * @param message the message
	 * @return the message
	 */
	public static String getMessage(String message){
		return getMessageWithLocale(message, getUserLocale());
	}
	
	/**
	 * Gets the message.
	 *
	 * @param message the message
	 * @param args the args
	 * @return the message
	 */
	public static String getMessage(String message, Object... args){
		return getMessageWithLocale(message, getUserLocale(), args);
	}
	
	/**
	 * Gets the message with locale.
	 *
	 * @param message the message
	 * @param locale the locale
	 * @param args the args
	 * @return the message with locale
	 */
	public static String getMessageWithLocale(String message, Locale locale, Object... args){
		return ApplicationContextUtil.getApplicationContext().getMessage(message, args, locale);
	}

	/**
	 * Gets the default locale.
	 *
	 * @return the default locale
	 */
	public static Locale getDefaultLocale(){
		return MessageServiceUtil.LOCALE_FA_IR;
	}

	/**
	 * Gets the user locale.
	 *
	 * @return the user locale
	 */
	public static Locale getUserLocale(){
		//TODO Implement it correctly
		return getDefaultLocale();
	}

	/**
	 * Gets the message with default.
	 *
	 * @param message the message
	 * @param defaultValue the default value
	 * @return the message with default
	 */
	public static String getMessageWithDefault(String message, String defaultValue){
		return getMessageWithLocaleAndDefault(message, defaultValue, getUserLocale());
	}
	
	/**
	 * Gets the message with default.
	 *
	 * @param message the message
	 * @param defaultValue the default value
	 * @param args the args
	 * @return the message with default
	 */
	public static String getMessageWithDefault(String message, String defaultValue, Object... args){
		return getMessageWithLocaleAndDefault(message, defaultValue, getUserLocale(), args);
	}
	
	/**
	 * Gets the message with locale and default.
	 *
	 * @param message the message
	 * @param defaultValue the default value
	 * @param locale the locale
	 * @param args the args
	 * @return the message with locale and default
	 */
	public static String getMessageWithLocaleAndDefault(String message, String defaultValue, Locale locale, Object... args){
		return ApplicationContextUtil.getApplicationContext().getMessage(message, args, defaultValue, locale);
	}
	
	private static final MessageTranslator MESSAGE_TRANSLATOR = new MessageTranslatorWithUserLocale();
	
	public static MessageTranslator getMessageTranslator() {
		return MESSAGE_TRANSLATOR;
	}
	
	
	/**
	 * Finds the appropriate message for a given message key.
	 *
	 * @param messageKey the message
	 * @return the appropriate message
	 */
	public static String getSuffixMessage(String messageKey){
		return MessageServiceUtil.getSuffixMessage(messageKey, getMessageTranslator());
	}
}
