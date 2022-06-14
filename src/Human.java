package src;
import java.util.*;

public class Human implements GamePlayer {
	protected String name;
	AbstractGame game;

//Constructeur de la class
	public Human(String name){
		this.name = name;
	}

// Methode de l'interface GamePlayer
	public int ChooseMove(AbstractGame game){
		System.out.println("Quel coup voulez vous jouez ?");
		Scanner scannerc = new Scanner(System.in);
		int n = scannerc.nextInt();
		while(game.validMoves(n) == false ){
			System.out.println("Saisissez une case valide :");
			n = scannerc.nextInt();
		}
		return n;
	}

// retourner le nom du joueur humain
	public String toString(){
		return this.name;
	}
}
