public class Teste {

  public static void main(String[] args) {
    //setup inicial
    String string = "ola mundo";
    int key = 1;

    //teste cifra de cesar
    string = Cesar.encryption(string, key);
    System.out.println(string);
    string = Cesar.decryption(string, key);
    System.out.println(string);

    //teste cifra vernam
    string = Vernam.encryptedAndDecrypted(string, "key");
    System.out.println(string);
    string = Vernam.encryptedAndDecrypted(string, "key");
    System.out.println(string);
  }
}
