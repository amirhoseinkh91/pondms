package ir.viratech.pond_ms.api.model;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class UIMetadata {
	public static ObjectNode buildMessage(String text, String type){
		ObjectNode message = JsonNodeFactory.instance.objectNode();
		message.put("text", text);
		message.put("type", type);
		ObjectNode tmp = JsonNodeFactory.instance.objectNode();
		tmp.set("message", message);
		return tmp;
	}
}
