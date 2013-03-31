package dk.cphbusiness.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import com.google.common.base.Preconditions;

public class Translator {
	private static String localeLanguage = "en";
	private static String localeCountry = "US";
	private static ResourceBundle messages;
	
	static {
		initializeBundle();
	}

	private static void initializeBundle() {
		Locale locale = new Locale(localeLanguage, localeCountry);
		messages = ResourceBundle.getBundle("dk.cphbusiness.utils.messages.translations", locale);
	}
	
	public static String getLocaleLanguage() {
		return localeLanguage;
	}

	public static String getLocaleCountry() {
		return localeCountry;
	}

	public static void changeLanguage(String newLanguage, String newCountry){
	    Preconditions.checkNotNull(newLanguage);
        Preconditions.checkArgument(!newLanguage.isEmpty());
        Preconditions.checkNotNull(newCountry);
        Preconditions.checkArgument(!newCountry.isEmpty());
        
		localeCountry = newCountry;
		localeLanguage = newLanguage;
		
		initializeBundle();
	}
	
	public static String getMessage(String messageKey){
	    Preconditions.checkNotNull(messageKey);
	    Preconditions.checkArgument(!messageKey.isEmpty());
    
		return messages.getString(messageKey);
	}
	
	public static String getMessage(String messageKey, Object... arguments){
	    Preconditions.checkNotNull(messageKey);
        Preconditions.checkArgument(!messageKey.isEmpty());
        Preconditions.checkNotNull(arguments);
        
		return MessageFormat.format(messages.getString(messageKey), arguments);
	}
}
