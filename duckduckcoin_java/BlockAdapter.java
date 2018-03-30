package Duckchain;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class BlockAdapter implements JsonSerializer<Block> {
	@Override
	public JsonElement serialize(Block block, Type arg1, JsonSerializationContext arg2) {
		JsonObject resultat = new JsonObject();
		resultat.addProperty("hash", block.getHash());
		resultat.addProperty("previousHash", block.previousHash);
		resultat.addProperty("data", block.data);
		resultat.addProperty("timestamp", new Date(block.timeStamp).toString());
		
		return resultat;
	}
}
