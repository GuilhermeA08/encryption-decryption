import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.*;

public class RC4 {

  public static SecretKey generateKey() throws NoSuchAlgorithmException {
    KeyGenerator keyGenerator = KeyGenerator.getInstance("RC4");
    keyGenerator.init(128);
    SecretKey secretKey = keyGenerator.generateKey();

    return secretKey;
  }

  public static String encrypted(String message, SecretKey key)
    throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
    Cipher cifrador = Cipher.getInstance("RC4");
    cifrador.init(Cipher.ENCRYPT_MODE, key);

    byte[] bytesCifrados = cifrador.doFinal(message.getBytes());
    String mensagemCifrada = Base64.getEncoder().encodeToString(bytesCifrados);

    return mensagemCifrada;
  }

  public static String decrypted(String cipherMessage, SecretKey key)
    throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
    Cipher cifrador = Cipher.getInstance("RC4");
    cifrador.init(Cipher.DECRYPT_MODE, key);

    byte[] bytesDecifrados = cifrador.doFinal(
      Base64.getDecoder().decode(cipherMessage)
    );
    String mensagemDecifrada = new String(bytesDecifrados);

    return mensagemDecifrada;
  }
}
