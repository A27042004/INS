
import java.security.PrivateKey;
import java.security.*;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;

public class DigitalSignature {

    //Signing Algorithm
    private static final String SIGNING_ALGORITHM = "SHA256withRSA";
    private static final String RSA = "RSA";
    private static Scanner sc;

    //Function to implement Digital Signature
    //using SHA256 and RSA algorithm
    //by passing private key
    public static byte[] Create_Digital_Signature(byte[] input, PrivateKey Key) throws Exception {
        Signature signature = Signature.getInstance(SIGNING_ALGORITHM);
        signature.initSign(Key);
        signature.update(input);
        return signature.sign();
    }

    //Generating the assymmetric key pair
    //using SecureRandom class
    //functions and RSA algorithm
    public static KeyPair Generate_RSA_KeyPair() throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
        keyPairGenerator.initialize(2048, secureRandom);
        return keyPairGenerator.generateKeyPair();
    }

    //Function for verification code
    //digital signature by using the public key
    public static boolean Verify_Digital_Signature(byte[] input,
            byte[] signatureToVerify, PublicKey key
    ) throws Exception {
        Signature signature = Signature.getInstance(SIGNING_ALGORITHM);
        signature.initVerify(key);
        signature.update(input);
        return signature.verify(signatureToVerify);
    }

    //Driver code
    public static void main(String args[]) throws Exception {
        String input = "Good Morning";
        KeyPair keyPair = Generate_RSA_KeyPair();
        //fUNCTION CALL
        byte[] signature = Create_Digital_Signature(input.getBytes(), keyPair.getPrivate());
        System.out.println("Signature Value:\n " + DatatypeConverter.printHexBinary(signature));
        System.out.println("Verification : " + Verify_Digital_Signature(input.getBytes(), signature, keyPair.getPublic()));

    }
}
