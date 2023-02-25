package test;
import java.util.Random;


/**
 * @author OTMANE ER-RAGRAGUI  120 117 39
 * @author ABDESSAMAD BOUZEKRI 120 122 48
 */


// La classe suivante genere un plainText dans 64 Bits et une clef sur 8 pour tester dans la classe Main.


public class Generate64bitsExample {
    public static void main(String[] args) {

        Random random = new Random();
        System.out.print("\nPlainText: ");

        for(int i = 0; i < 64;i++){
            System.out.print((random.nextInt(10))%2);
        }

        System.out.print("\nKey:       ");

        for(int i = 0; i < 8;i++){
            System.out.print((random.nextInt(10))%2);
        }
        System.out.println("\n\n");
    }
}

