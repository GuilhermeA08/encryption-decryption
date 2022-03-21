public class Teste {

	public static void main(String[] args) {
		// setup inicial
		String string = "OLA MUNDO";
		int key = 1;

		// teste cifra de cesar
		string = Cesar.encryption(string, key);
		System.out.println(string);
		string = Cesar.decryption(string, key);
		System.out.println(string);

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

	}
}
