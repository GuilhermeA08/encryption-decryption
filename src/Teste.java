import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Teste {

  public static void main(String[] args)
    throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
    // Cifra de Cesar
    String mensagem = "OLA MUNDO";
    int key = 1;

    /*
    System.out.println("Cifra de Cesar");
    mensagem = Cesar.encryption(mensagem, key);
    System.out.println("mensagem criptografada: " + mensagem);
    mensagem = Cesar.decryption(mensagem, key);
    System.out.println("mensagem descriptografada: " + mensagem);*/

    /*
    // teste cifra vigenere
    System.out.println("Cifra de Vigenere");
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
    System.out.println("Mensagem decifrada: " + plaintext);*/

    /*
    // teste cifra vernam
    System.out.println("Cifra de Vernam");
    mensagem = Vernam.encryptedAndDecrypted(mensagem, "key");
    System.out.println("mensagem criptografada: " + mensagem);
    mensagem = Vernam.encryptedAndDecrypted(mensagem, "key");
    System.out.println("mensagem descriptografada: " + mensagem);*/

    /*
    String string = "Ola mundo";
    System.out.println("AES 256 Bits");
    System.out.println("-------------------------------");

    AES.generateKeys();

    try {
      string = AES.encryption(string);
    } catch (
      InvalidKeyException
      | NoSuchAlgorithmException
      | NoSuchPaddingException
      | InvalidAlgorithmParameterException
      | IllegalBlockSizeException
      | BadPaddingException e
    ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("Mensagem cifrada: " + string);
    try {
      string = AES.decryption(string);
    } catch (
      InvalidKeyException
      | NoSuchAlgorithmException
      | NoSuchPaddingException
      | InvalidAlgorithmParameterException
      | IllegalBlockSizeException
      | BadPaddingException e
    ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("Mensagem decifrada: " + string);*/

    /*
    //Cifra RC4
    System.out.println("Cifra RC4");
    SecretKey secretKey = RC4.generateKey();
    mensagem = RC4.encrypted(mensagem, secretKey);
    System.out.println("Mensagem criptografada: " + mensagem);
    mensagem = RC4.decrypted(mensagem, secretKey);
    System.out.println("Mensagem descriptografada: " + mensagem);*/
  }
}
