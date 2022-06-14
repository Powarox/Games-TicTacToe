package src;
import java.util.*;

public abstract class AbstractGame {
	public GamePlayer joueur1;
	public GamePlayer joueur2;
	public GamePlayer jc;

	public AbstractGame (GamePlayer getJoueur1,GamePlayer getJoueur2) {
		this.joueur1 = getJoueur1;
		this.joueur2 = getJoueur2;
		this.jc = getJoueur1;
	}

	public boolean rejouer() {
   	Scanner sc = new Scanner(System.in);
      System.out.println("Voulez vous rejouez ?");
		System.out.println("Taper sur N pour quitter et autre pour rejouer !");
     	String response = sc.next();
     	if (response.equalsIgnoreCase("y")) {
      	return true;
      }
		else if (response.equalsIgnoreCase("n")) {
			System.out.println("Merci d'avoir jouer ! :)");
	 		return false;
		}
		return true;
	}

// Change le joueur courant
	public void changerJoueur(){
		if(this.jc == joueur1){
			this.jc = joueur2;
		}
		else{
			this.jc = joueur1;
		}
	}

// Retourne le joueur courant
	public GamePlayer getCurrentPlayer(){
			return this.jc;
	}

// Ce qui suit represente les methodes abstraites aux deux jeux.
	public abstract AbstractGame getCopy();

	public abstract List<Integer> coupPossible();

	public abstract boolean isOver();

	public abstract void jouerTour(int n);

	public abstract boolean getWinner();

	public abstract String situationToString();

	public abstract boolean validMoves(int n);

	public abstract String moveToString(Integer n);
}
