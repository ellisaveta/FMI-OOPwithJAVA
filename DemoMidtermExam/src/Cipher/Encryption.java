package Cipher;

import java.util.ArrayList;

public class Encryption {

    private class MonoEncryption implements IEncryptable {
        @Override
        public String encrypt(String plainText, String cipher) {
            char[] plainTextArray = plainText.toUpperCase().toCharArray();
            char[] cipherArray = cipher.toUpperCase().toCharArray();
            char[] alphabet = new char[26];
            char letter = 'A';
            for (int i = 0; i < alphabet.length; i++) {
                alphabet[i] = letter++;
            }
            String cipherText = "";
            ArrayList<Character> newCipher = new ArrayList<>();
            for (char c : cipherArray) {
                if (!newCipher.contains(c)) {
                    newCipher.add(c);
                }
            }
            for (int j = alphabet.length - 1; j >= 0; j--) {
                if(!newCipher.contains(alphabet[j]))
                {
                    newCipher.add(alphabet[j]);
                }
            }

            for (int i = 0; i < plainTextArray.length; i++) {
                int position = 0;
                while(alphabet[position] != plainTextArray[i])
                {
                    position++;
                }
                cipherText = cipherText.concat(String.format("%c", newCipher.get(position)));
            }
            return cipherText;
        }

        @Override
        public String decrypt(String cipherText, String cipher) {
            char[] cipherTextArray = cipherText.toUpperCase().toCharArray();
            char[] cipherArray = cipher.toUpperCase().toCharArray();
            char[] alphabet = new char[26];
            char letter = 'A';
            for (int i = 0; i < alphabet.length; i++) {
                alphabet[i] = letter++;
            }
            ArrayList<Character> newCipher = new ArrayList<>();
            for (char c : cipherArray) {
                if (!newCipher.contains(c)) {
                    newCipher.add(c);
                }
            }
            for (int j = alphabet.length - 1; j >= 0; j--) {
                if(!newCipher.contains(alphabet[j]))
                {
                    newCipher.add(alphabet[j]);
                }
            }
            String plainText = "";
            for (int i = 0; i < cipherTextArray.length; i++) {
                int position = 0;
                while(newCipher.get(position) != cipherTextArray[i])
                {
                    position++;
                }
                plainText = plainText.concat(String.format("%c", alphabet[position]));
            }
            return plainText;
        }
    }

    public IEncryptable getMonoCipherMethod()
    {
        return new MonoEncryption();
    }
}
