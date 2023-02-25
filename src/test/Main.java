package test;
import main.*;
import java.util.Scanner;

/**
 * @author OTMANE ER-RAGRAGUI  120 117 39
 * @author ABDESSAMAD BOUZEKRI 120 122 48
 */

public class Main {

	public static void main(String[] args){
		String type;
	    Scanner sc = new Scanner(System.in);
		Boolean flag = true; // ce flag permet de confirmer les bon inputs sinon refaire!

		while(flag){
			System.out.print("\nQue souhaitez-vous faire ? (choix : cryptage ou decryptage ou stop) : ");
			type = sc.next();
			flag = false;
			try {
				choix(type);
			} catch (Exception e) {
				System.out.println("\n **** Attention les inputs doivent etre que des 0 et des 1! ****");
				flag = true;
			}
		}

	}
	
	
	static void choix(String type) throws Exception {
		DES_ENCRYPTION_DECRYPTION ed  = new DES_ENCRYPTION_DECRYPTION();
		int[] encr = new int[64];  //message encrypte
		int[] decr = new int[64];  //message decrypte
		Scanner sc = new Scanner(System.in);
		String type_ = type;
		String msg;
		String key;
		
		switch(type_)
	    {
	    	case "cryptage" : 
	    		
	    		System.out.println("\n *** Cryptage du message ***");
		    	System.out.print("\nEntrer le message a crypter (64 bits) : ");
		 	    msg = sc.next();
		 	    System.out.print("\nEntrer la clef (64 bits) : ");
			    key = sc.next();

			    encr = ed.crypte_decrypte(msg, key,type_); //on souhaite encrypter le message
			    
			  //On affiche le message crypte
			    
			    System.out.print(" \nMessage Crypte : ");
			    FUNCTIONS.AffichageTableau(encr,64);
		    	System.out.println("\n");
		    	
		    	System.out.print("Que souhaitez-vous faire ? (choix : cryptage ou decryptage ou stop) : ");
		    	type_ = sc.next();
		    	choix(type_);
		 	 
	    	case "decryptage" :
	    		
	    		System.out.println(" \n*** Decryptage du message *** ");
		    	System.out.print("\nEnter le message a decrypter (64 bits) : ");
		    	msg = sc.next();
		    	
		    	System.out.print("\nEntrer la clef (64 bits) : ");
			    key = sc.next();
			    
		    	decr = ed.crypte_decrypte(msg, key,type_); //on souhaite decrypter le message
		  
		    	//On affiche le message decrypte

		    	System.out.print("\nMessage Decrypte : ");
				FUNCTIONS.AffichageTableau(decr,64);
				System.out.println("\n");
				
				System.out.print("Que souhaitez-vous faire ? (choix : cryptage ou decryptage ou stop) : ");
		    	type_ = sc.next();
		    	choix(type_);
			
	    	case "stop" : 
	    		System.exit(0);

		    default : 
		    	
		    	System.out.print("\nVeuillez choisir cryptage, decryptage ou stop : ");
		    	type_ = sc.next();
		    	choix(type_);
			
	    }
	}

}
