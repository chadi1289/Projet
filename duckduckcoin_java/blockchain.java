package Duckchain ;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class Duckchain {

	public static LinkedList<Block> blockchain = new LinkedList<Block>();
	
	public static void main(String[] args) {
		//On ajoute des blocks à notre blockchain
		blockchain.addLast(new Block("Je suis le premier Block" , "0"));
		blockchain.addLast(new Block("Je suis le second block",blockchain.get(blockchain.size()-1).hash));
		blockchain.addLast(new Block("Et moi c'est le troisième block",blockchain.get(blockchain.size()-1).hash));
		
		Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(Block.class, new BlockAdapter()).create();
		JsonObject blockchainJson = new JsonObject();
		
		blockchainJson.add("blocks", gson.toJsonTree(blockchain));
		
		System.out.println(gson.toJson(blockchainJson));
	}
}
