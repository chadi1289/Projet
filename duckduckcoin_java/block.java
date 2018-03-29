package Duckchain;
import java.util.*;
public class Block {
	/*Ici on va créer un block avec des attributs qui lui sont spécifiques , 
	utiliser cette classe pour créer un blockchain en rajoutant le merkle root */

	public String hash;
	private String previousHash;
	private String data; //notre data sera un simple message 
	private long timeStamp;

	//Constructeur de block
	public Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.setHash(calculateHash());// on caclule le hash du code 
	}

	public String calculateHash() {
	String calculatedhash = HashUtil.applySha256(previousHash+timeStamp+data); //on utilise le  SHA256 fourni avec le projet 
	return calculatedhash;
}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

}
