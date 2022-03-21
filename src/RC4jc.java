import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;

public class RC4jc {

  public static void main(String[] args)
    throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
    KeyGenerator keyGenerator = KeyGenerator.getInstance("RC4");
    keyGenerator.init(256);
    SecretKey secretKey = keyGenerator.generateKey();
    String secretKeyString = Base64
      .getEncoder()
      .encodeToString(secretKey.getEncoded());
    System.out.println("generated key = " + secretKeyString);

    //Encrypt Hello world message
    Cipher encryptionCipher = Cipher.getInstance("RC4");
    IvParameterSpec parameterSpec = new IvParameterSpec(new byte[16]);
    encryptionCipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);
    String message = "Hello world";
    byte[] encryptedMessageBytes = encryptionCipher.doFinal(message.getBytes());
    String encryptedMessage = Base64
      .getEncoder()
      .encodeToString(encryptedMessageBytes);
    System.out.println("Encrypted message = " + encryptedMessage);

    //Decrypt the encrypted message
    Cipher decryptionCipher = Cipher.getInstance("RC4");
    decryptionCipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);
    byte[] decryptedMessageBytes = decryptionCipher.doFinal(
      encryptedMessageBytes
    );
    String decryptedMessage = new String(decryptedMessageBytes);
    System.out.println("decrypted message =" + decryptedMessage);
  }
}
