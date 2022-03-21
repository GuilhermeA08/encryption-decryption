
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
	
	public static String encryption(String plaintext) throws NoSuchAlgorithmException, NoSuchPaddingException,
	InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		
		keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(256);
		secretKey = keyGenerator.generateKey();
		String secretKeyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		System.out.println("Chave gerada = " + secretKeyString);
		
		Cipher encryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		parameterSpec = new IvParameterSpec(new byte[16]);
		encryptionCipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);
		byte[] encryptedMessageBytes = encryptionCipher.doFinal(plaintext.getBytes());
		String encryptedMessage = Base64.getEncoder().encodeToString(encryptedMessageBytes);

		return encryptedMessage;
	}
	
	public static String decryption(String cryptedtext) throws NoSuchAlgorithmException, NoSuchPaddingException,
	InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		
		keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(256);
		secretKey = keyGenerator.generateKey();
		String secretKeyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		System.out.println("Chave gerada = " + secretKeyString);
		
		Cipher decryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		decryptionCipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);
		byte[] decryptedMessageBytes = decryptionCipher.doFinal();
		String decryptedMessage = new String(decryptedMessageBytes);
		
		return decryptedMessage;
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(256);
		SecretKey secretKey = keyGenerator.generateKey();
		String secretKeyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		System.out.println("generated key = " + secretKeyString);

		// Encrypt Hello world message
		Cipher encryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec parameterSpec = new IvParameterSpec(new byte[16]);
		encryptionCipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);
		String message = "Hello world";
		byte[] encryptedMessageBytes = encryptionCipher.doFinal(message.getBytes());
		String encryptedMessage = Base64.getEncoder().encodeToString(encryptedMessageBytes);
		System.out.println("Encrypted message = " + encryptedMessage);

		// Decrypt the encrypted message
		Cipher decryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		decryptionCipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);
		byte[] decryptedMessageBytes = decryptionCipher.doFinal(encryptedMessageBytes);
		String decryptedMessage = new String(decryptedMessageBytes);
		System.out.println("decrypted message = " + decryptedMessage);
	}
}
