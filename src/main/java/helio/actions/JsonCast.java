package helio.actions;

import org.json.XML;

import com.google.gson.JsonObject;

import helio.blueprints.Action;
import helio.blueprints.exceptions.ActionException;

public class JsonCast implements Action{

	private String format;
	
	public void configure(JsonObject configuration) {
		if(configuration.has("format")) {
			this.format = configuration.get("format").getAsString();
		}else {
			throw new IllegalArgumentException("Provided configuration lacks of mandatory key 'format' specifying the input data format");
		}
	}

	public String run(String values) throws ActionException {
		if(format.equals("xml"))
			return XML.toJSONObject(values).toString();
		return values;
	}

}
