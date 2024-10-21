import java.lang.Math;

public class Vernam {

    public static void main(String args[]) {
        String plainText = new String("computerscien");
        char[] arText = plainText.toCharArray();

        String key = new String("ABCDEFGXYZHIJ");
        char[] arKey = key.toCharArray();

        char[] cipherText = new char[13];
        System.out.print("Encoded" + plainText + " to be... ");

        for (int i = 0; i < arText.length; i++) {
            cipherText[i] = (char) (arText[i] ^ arKey[i]);
            System.out.print(cipherText[i]);
        }
        System.out.print("\nDecoded to be... ");
        for (int i = 0; i < cipherText.length; i++) {
            char temp = (char) (cipherText[i] ^ arKey[i]);
            System.out.print(temp);
        }
    }
}
