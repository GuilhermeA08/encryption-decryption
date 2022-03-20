public class Cesar {

  public static String encryption(String message, int key) {
    StringBuilder stringBuilder = new StringBuilder();

    key = key % 26;

    for (int i = 0; i < message.length(); i++) {
      char ch = message.charAt(i);
      if (ch == ' ') {
        stringBuilder.append(ch);
      } else if (ch >= 'a' && ch <= 'z') {
        ch += key;
        if (ch > 'z') {
          ch -= 26;
          stringBuilder.append(ch);
        } else {
          stringBuilder.append(ch);
        }
      } else if (ch >= 'A' && ch <= 'Z') {
        ch += key;
        if (ch > 'Z') {
          ch -= 26;
          stringBuilder.append(ch);
        } else {
          stringBuilder.append(ch);
        }
      }
    }

    message = stringBuilder.toString();
    return message;
  }

  public static String decryption(String message, int key) {
    StringBuilder stringBuilder = new StringBuilder();

    key = key % 26;

    for (int i = 0; i < message.length(); i++) {
      char ch = message.charAt(i);
      if (ch == ' ') {
        stringBuilder.append(ch);
      } else if (ch >= 'a' && ch <= 'z') {
        ch -= key;
        if (ch > 'z') {
          ch -= 26;
          stringBuilder.append(ch);
        } else {
          stringBuilder.append(ch);
        }
      } else if (ch >= 'A' && ch <= 'Z') {
        ch -= key;
        if (ch > 'Z') {
          ch -= 26;
          stringBuilder.append(ch);
        } else {
          stringBuilder.append(ch);
        }
      }
    }

    message = stringBuilder.toString();
    return message;
  }
}
