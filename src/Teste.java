public class Teste {

  public static void main(String[] args) {
    String string = "ola mundo";
    int key = 1;
    string = Cesar.encryption(string, key);
    System.out.println(string);
    string = Cesar.decryption(string, key);
    System.out.println(string);
  }
}
