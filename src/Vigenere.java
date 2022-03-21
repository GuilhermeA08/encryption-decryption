
public class Vigenere {
	
	public static String encryption(String message, String keyword) {
		StringBuilder builderMessage = new StringBuilder();
		StringBuilder key = new StringBuilder();
		
		message = message.replaceAll(" ", "");
		message = message.toUpperCase();
		keyword = keyword.toUpperCase();
		
		for (int i = 0, j = 0; i < message.length(); i++, j++) {
			if (j == keyword.length()) {
				j = 0;
			}
			key.append(keyword.charAt(j));
		}
		System.out.println(key);
		
		for (int i = 0; i < message.length(); i++) {
			builderMessage.append((char) (((message.charAt(i) + keyword.charAt(i % keyword.length())) % 26) + 'A'));
		}
		
		String encryptedMessage = builderMessage.toString();
		return encryptedMessage;
		
	}
	
	public static String decryption(String message, String keyword) {
		StringBuilder builderMessage = new StringBuilder();
		StringBuilder key = new StringBuilder();
		
		message = message.replaceAll(" ", "");
		message = message.toUpperCase();
		keyword = keyword.toUpperCase();
		
		for (int i = 0, j = 0; i < message.length(); i++, j++) {
			if (j == keyword.length()) {
				j = 0;
			}
			key.append(keyword.charAt(j));
		}
		System.out.println(key);
		
		for (int i = 0; i < message.length(); i++) {
			builderMessage.append((char) (((message.charAt(i) - keyword.charAt(i % keyword.length()) + 26) % 26) + 'A'));
		}
		
		String decryptedMessage = builderMessage.toString();
		return decryptedMessage;
	}

}
