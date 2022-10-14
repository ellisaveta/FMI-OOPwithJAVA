package cipher.demomidtermfx;

import Cipher.CipherMethod;
import Cipher.Encryption;

public class TestMethod {
    CipherMethod method;

    public TestMethod(Encryption method) {
        this.method = new CipherMethod(method.getMonoCipherMethod());
    }
}
