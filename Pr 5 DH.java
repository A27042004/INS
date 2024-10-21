/*
Key exchange using Diffie-Hellman implementing the diffie-helman 
key exchanges algs to securely.
 */
import java.util.*;

public class DH {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter PRIME NUMBER 1 p: ");
        int p = sc.nextInt();
        System.out.print("Enter PRIME NUMBER 2 p: ");
        int g = sc.nextInt();
        System.out.print("Choose 1st secret no(Alice) 'a': ");
        int a = sc.nextInt();
        System.out.print("Choose 2st secret no(Alice) 'b': ");
        int b = sc.nextInt();

        int A = (int) Math.pow(g, a) % p;//Public Key of Alice
        int B = (int) Math.pow(g, b) % p;//Public Key of Bob

        System.out.println("Public Key of Alice : " + A);
        System.out.println("Public Key of Bob : " + B);

        int S_A = (int) Math.pow(B, a) % p;//Alice
        int S_B = (int) Math.pow(A, b) % p;//Bob

        System.out.println("Shared Key of Alice S_A: " + S_A);
        System.out.println("Shared Key of Bob S_B : " + S_B);

        if (S_A == S_B) {
            System.out.println("Alice and Bob can communicate " + "with each other!!!");
            System.out.println("They share a secret no = " + S_A);
        } else {
            System.out.println("Alice and Bob cannot" + "communicate with each other!!!");
        }

    }
}
