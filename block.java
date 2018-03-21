
import java.util.Date;
public class Block {
	/*Ici on va construire un block avec des attributs qui lui sont spécifiques , 
	utiliser cette classe pour créer un blockchain en rajoutant le merkle root */

	public String hash;
	public String previousHash;
	private String data; //notre data sera un simple message 
	private long timeStamp;
	private int nonce ;

	//Constructeur de block
	public Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();// on caclule le hash du code 
	}

	public String calculateHash() {
	String calculatedhash = StringUtil.applySha256(previousHash+Long(timeStamp)+data); //on utilise le  SHA256 fourni avec le projet 
	return calculatedhash;
}

}
