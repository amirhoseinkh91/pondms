package ir.viratech.pond_ms.api;

import java.util.Date;

import javax.ws.rs.core.Response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ir.viratech.commons.util.i18n.MessageTranslator;
import ir.viratech.pond_ms.core.i18n.MessageService;

public abstract class BaseServiceHandler {
	
	private MessageTranslator messageTranslator = MessageService.getMessageTranslator();
	
	public MessageTranslator getMessageTranslator() {
		return messageTranslator;
	}
	
	@JsonIgnore
    private final Date date = new Date();
    
    @JsonIgnore
    public final Date getDate() {
        return date;
    }

    public abstract Response handle() throws RequestHandlingException;
}
