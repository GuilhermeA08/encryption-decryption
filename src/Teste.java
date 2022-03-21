import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Teste {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException {
		// setup inicial
		String string = "OLA MUNDO";
		int key = 1;

    // teste cifra vigenere
    String plaintext = "Atacar base sul";
    String keyword = "Limao";
    System.out.println("-------------------------------");
    System.out.println("Mensagem aberta: " + plaintext);
    System.out.println("Palavra-chave: " + keyword);
    System.out.println("-------------------------------");
    System.out.println("Operação: ");
    System.out.print("Chave: ");
    plaintext = Vigenere.encryption(plaintext, keyword);
    System.out.println("Mensagem cifrada: " + plaintext);
    System.out.println("-------------------------------");
    System.out.print("Chave: ");
    plaintext = Vigenere.decryption(plaintext, keyword);
    System.out.println("Mensagem decifrada: " + plaintext);
    System.out.println("-------------------------------");

		// teste cifra vernam
		string = Vernam.encryptedAndDecrypted(string, "key");
		System.out.println(string);
		string = Vernam.encryptedAndDecrypted(string, "key");
		System.out.println(string);

		string = "Ola mundo";
		System.out.println("-------------------------------");
		try {
			AES.gerarChave();
			string = AES.encryption(string);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Mensagem cifrada: " + string);
		System.out.println("-------------------------------");
		try {
			string = AES.decryption(string);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Mensagem decifrada: " + string);
	}
}
