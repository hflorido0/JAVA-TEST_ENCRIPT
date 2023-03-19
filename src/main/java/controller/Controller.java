package controller;

import security.DES;
import security.RSA;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

public class Controller {

    public Controller () {
    }

    public void init () {
        RSA();
        DES();
    }
    public void RSA() {
        try {
            RSA rsa = new RSA();
            // Generar un par de claves RSA
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair claves = keyGen.generateKeyPair();

            // Cifrar una cadena de texto
            String texto = "Este es un texto secreto que se va a encriptar con RSA";
            byte[] textoCifrado = rsa.cifrarRSA(texto.getBytes(), claves);

            // Descifrar el texto
            byte[] textoDescifrado = rsa.descifrarRSA(textoCifrado, claves);

            System.out.println("Texto original: " + texto);
            System.out.println("Texto cifrado: " + new String(textoCifrado));
            System.out.println("Texto descifrado: " + new String(textoDescifrado));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DES() {

        try {

            DES des = new DES();

            // Generar una clave DES de 8 bytes
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(new SecureRandom());
            SecretKey clave = keyGenerator.generateKey();

            // Cifrar una cadena de texto
            String texto = "Este es un texto secreto que se va a encriptar con DES";
            byte[] textoCifrado = des.cifrarDES(texto, clave);

            // Descifrar el texto
            String textoDescifrado = des.descifrarDES(textoCifrado, clave);

            System.out.println("Texto original: " + texto);
            System.out.println("Texto cifrado: " + new String(textoCifrado));
            System.out.println("Texto descifrado: " + textoDescifrado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
