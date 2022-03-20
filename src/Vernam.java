public class Vernam {

	public static String encryptedAndDecrypted(String message, String key) {
		StringBuilder builderMessage = new StringBuilder();

		for (int i = 0; i < message.length(); i++) {
			builderMessage.append((char) (message.charAt(i) ^ key.charAt(i % key.length())));
		}

		String encryptedMessage = builderMessage.toString();

		return encryptedMessage;
	}
}
