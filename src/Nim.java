package src;
import java.util.*;

public class Nim extends AbstractGame {
	private int tas;	// nb d'allumette au départ
	private int nmax;	// nb max d'allumette qu'un joueur peut tirer
	private int nca;	// nb restant d'allumette

// Constructeur du Nim
	public Nim (int getTas, int getNmax, GamePlayer getJoueur1, GamePlayer getJoueur2) {
		super(getJoueur1, getJoueur2);
		this.tas = getTas;
		this.nmax = getNmax;
		this.nca = tas;
	}

// Return le nombre d'allumettes initial
	public String getInitialNbMatches(){
		return
			"Le tas initiale est de : " + this.tas + " allumettes";
	}

// Return le tas d'allumettes
	public String getNbMatches(){
		return
			"Le tas est de : " + this.nca + " allumettes";
	}

// Partie fini si nca = 0 et donc return true pour stopper la partie
	public boolean isOver(){
		if(this.nca == 0){
			return true;
		}
		else{
			return false;
		}
	}

// Modifie le nombre d'allumettes courant || Appel methode changerJoueur()
	public void jouerTour(int n){
		 this.nca = this.nca - n ;
		 this.changerJoueur();
	}

// Return le nombre d'allumettes restantes dans la partie
	public String situationToString(){
		 return
		 	"Il reste " + this.nca + " "  + "allumettes" + System.lineSeparator();
	}

// Met à jour le nombre d'allumettes restantes
	public int restant(int n){
		return
			this.nca = this.nca - n;
	}

// Vérifie si le coup est possible
	public boolean validMoves(int n){
		if(n <= 0)	{
			System.out.println("Coup negatif impossible");			// Verif si n est positif
			return false;
		}
		if(n > this.nmax){
			System.out.println("Coup superieur au nombre max");	// Verif si n est inférieur au nb max d'allumettes
			return false;
		}
		if(n > this.nca){
			System.out.println("Coup superieur au tas restant");	// Verif si n est inférieur au tas restant
			return false;
		}
		return true;
	}

// Vérifie si la partie est fini et return true si c'est le cas
	public boolean getWinner(){
		if(this.nca <= 0){
			return true;
		}
		else{
			return false;
		}
	}

// Créer un affichage pour visualiser le nombre d'allumettes restantes
	public String moveToString(Integer n){
		for(int i = 1; i < this.nca + 1; i++ ){
			System.out.print(("| i | - "));
		}
		return " ";
	}

// Récupère la case joué par le joueur et la return
	public int ChooseMove(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisissez la case que vous voulez jouer : ");
		int n = scanner.nextInt();
		while (validMoves(n) == false){
			System.out.println("Saisissez la case que vous voulez jouer : ");
			n = scanner.nextInt();
		}
		return n;
	}

// Affiche tout les coups possibles
	public List<Integer> coupPossible(){
		List<Integer> l = new ArrayList<> ();
		for(int i =1;i < Math.min(this.nca, this.nmax) +1 ; i++ ){
			l.add(i);
		}
		return(l);
	}

//Cree et retourne une copie d'une instance de class NIM
	public AbstractGame getCopy(){
			Nim res = new Nim(this.tas, this.nmax, this.joueur1, this.joueur2);
			res.nca = this.nca;
			res.jc = super.jc;
			return res;
	}
}
