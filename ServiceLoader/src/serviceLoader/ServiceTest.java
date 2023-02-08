package serviceLoader;

import java.util.Optional;
import java.util.ServiceLoader;

public class ServiceTest {

    public static void main(String[] args) {

    }


    public static ServiceLoader<Cipher> cipherLoader = ServiceLoader.load(Cipher.class);

    public static Cipher getCipher(int minStrength) {
        for (Cipher cipher : cipherLoader) {
            if (cipher.strength() >= minStrength) return cipher;
        }
        return null;
    }

    public static Optional<Cipher> getCipher2 (int minStrength){
        return cipherLoader.stream()
                .filter(descr -> descr.type() ==
                        serviceLoader.impl.CaesarCipher.class)
                .findFirst()
                .map(ServiceLoader.Provider::get);
    }
}
