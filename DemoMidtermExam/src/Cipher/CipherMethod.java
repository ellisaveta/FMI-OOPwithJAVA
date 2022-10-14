package Cipher;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CipherMethod {
    IEncryptable callbackFtn;

    public CipherMethod(IEncryptable callbackFtn) {
        this.callbackFtn = callbackFtn;
    }

    // returns the encrypted string
    public String encryptText(String plainText, String cipher) {
        return callbackFtn.encrypt(plainText, cipher);
    }

    // returns the decrypted string
    public String decryptText(String cipherText, String cipher) {
        return callbackFtn.decrypt(cipherText, cipher);
    }
}
