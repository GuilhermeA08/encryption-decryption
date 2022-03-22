
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AES {
	
	static KeyGenerator keyGenerator;
	static SecretKey secretKey;
	static IvParameterSpec parameterSpec;
	
	public static void generateKeys() throws NoSuchAlgorithmException {
		keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(256);
		secretKey = keyGenerator.generateKey();
		String secretString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		System.out.println("Chave gerada = " + secretString);
	}
	
	public static String encryption(String plaintext) throws NoSuchAlgorithmException, NoSuchPaddingException,
	InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		
		Cipher encryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		parameterSpec = new IvParameterSpec(new byte[16]);
		encryptionCipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);
		byte[] encryptedMessageBytes = encryptionCipher.doFinal(plaintext.getBytes());
		String encryptedMessage = Base64.getEncoder().encodeToString(encryptedMessageBytes);

		return encryptedMessage;
	}
	
	public static String decryption(String cryptedtext) throws NoSuchAlgorithmException, NoSuchPaddingException,
	InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		
		byte [] encryptedMessageBytes = Base64.getDecoder().decode(cryptedtext);
		Cipher decryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		decryptionCipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);
		byte[] decryptedMessageBytes = decryptionCipher.doFinal(encryptedMessageBytes);
		String decryptedMessage = new String(decryptedMessageBytes);
		
		return decryptedMessage;
	}
	
}
