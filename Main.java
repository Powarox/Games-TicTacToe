package src;
import java.util.*;

public class Main {
	public static void main (String [] args) {
		Initialisation init = new Initialisation();
		Scanner scanner = new Scanner(System.in);
		System.out.println("            ---------- Bienvenu dans le FIL ROUGE ---------- ");
		System.out.println(" ~ Quel Jeu voulez vous jouer ?");
		System.out.println(" ~ Taper 1 pour le MORPION ou 2 pour le jeu de NIM ! :)");

		// Verifie si la valeur est un entier puis si ele est égale à 1 ou 2
		if (init.verifie_jeu() == 1){
			init.choixdejoueur();
        	int a = init.verifie_mode_de_jeu();	// Même verification que pour verfie_jeu mais pour le mode de jeu
			if(a == 1){
         	init.humanVShuman();
			}
			if(a == 2){
				init.humanVSjoueuraleatoire();
			}
			if(a == 3){
				init.humanVSMinMaxPlayer();
			}
			if(a == 4){
				init.joueuraleatoireVSMinMaxPlayer();
			}
		}
		// Même fonctionnement mais pour le Nim
		else{
			init.choixdejoueur();
        	int a = init.verifie_mode_de_jeu();
			if(a == 1){
         	init.humanVShuman2();
			}
			if(a == 2){
				init.humanVSjoueuraleatoire2();
			}
			if(a == 3){
				init.humanVSMinMaxPlayer2();
			}
			if(a == 4){
				init.joueuraleatoireVSMinMaxPlayer2();
			}
		}
	}
}
