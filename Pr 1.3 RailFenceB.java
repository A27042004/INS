
import java.util.*;

public class RailFenceB {

    int depth;

    String Encryption(String plaintext, int depth) throws Exception {
        int r = depth, len = plaintext.length();
        int c = len / depth;
        c = c + 1;
        char mat[][] = new char[r][c];
        int k = 0;

        String cipherText = "";

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (k != len) {
                    mat[j][i] = plaintext.charAt(k++);
                    System.out.println("mat[" + j + "][" + i + "]=" + mat[j][i]);
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                cipherText += mat[i][j];
            }
        }
        return cipherText;
    }

    String Decryption(String cipherText, int depth) throws Exception {
        int r = depth, len = cipherText.length();
        int c = len / depth;
        char mat[][] = new char[r][c];
        int k = 0;

        String plainText = "";

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = cipherText.charAt(k++);
            }
        }
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                plainText += mat[j][i];
            }
        }
        return plainText;
    }
}

class RailFence {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int depth;

        String plainText, cipherText, decryptedText;

        System.out.println("Enter plain text:");
        plainText = sc.nextLine();

        System.out.println("Enter depth(No of Rails) for Encryption:");
        depth = sc.nextInt();

        RailFenceB rf = new RailFenceB();

        cipherText = rf.Encryption(plainText, depth);
        System.out.println("Encrypted text is:\n" + cipherText);

        decryptedText = rf.Decryption(cipherText, depth);
        System.out.println("Decrypted text is:\n" + decryptedText);

    }
}
