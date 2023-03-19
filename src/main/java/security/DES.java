package security;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.nio.charset.StandardCharsets;

public class DES {
    public byte[] cifrarDES(String texto, SecretKey clave) throws Exception {
        // Crear un objeto Cipher para cifrar
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, clave);

        // Cifrar el texto
        byte[] textoCifrado = cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));
        return textoCifrado;
    }

    public String descifrarDES(byte[] textoCifrado, SecretKey clave) throws Exception {
        // Crear un objeto Cipher para descifrar
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, clave);

        // Descifrar el texto
        byte[] textoDescifrado = cipher.doFinal(textoCifrado);
        return new String(textoDescifrado, StandardCharsets.UTF_8);
    }
}
