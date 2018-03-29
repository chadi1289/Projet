package Duckchain ;
import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class Duckchain {

	public static ArrayList<Block> blockchain = new ArrayList<Block>();

	public static void main(String[] args) {
		//On ajoute des blocks à notre blockchain
		blockchain.add(new Block("Je suis le premier Block" , "0"));
		blockchain.add(new Block("Je suis le second block",blockchain.get(blockchain.size()-1).hash));
		blockchain.add(new Block("Et moi c'est le troisième block",blockchain.get(blockchain.size()-1).hash));
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println(blockchainJson);
	}
}

