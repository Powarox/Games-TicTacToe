package src;
import java.util.*;

public class TicTacToe extends AbstractGame{
	protected GamePlayer [][] grille = new GamePlayer [3][3];
   private int counter;
   private char posn[] = new char[10];
	private char player;

// Constructeur du Morpion
	public TicTacToe(GamePlayer getJoueur1, GamePlayer getJoueur2){
		super(getJoueur1, getJoueur2);
	}

// Return True si il y a alignement sur une ligne
	public boolean testLigne(int lig){
		return grille[lig][0] != null && grille[lig][0] == grille[lig][1] && grille[lig][0] == grille[lig][2];
	}

// Return True si il a alignement sur une colonne
	public boolean testColonne(int col){
		return grille[0][col] != null && grille[0][col] == grille[1][col] && grille[0][col] == grille[2][col];
	}

// Return True si il y a alignement sur la diago 0 4 8
	public boolean testDiago048(){
		return grille[0][0] != null && grille[0][0] == grille[1][1] && grille[0][0] == grille[2][2];
	}

// Return True si il y a alignement sur la diago 2 4 6
	public boolean testDiago246(){
		return grille[0][2] != null && grille[0][2] == grille[1][1] && grille[0][2] == grille[2][0];
	}

// Return False si toute la grille est pleine
	public boolean testCasesNull(){
		int a = 0;
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				if(grille[i][j] != null){
					a = a + 1;
				}
			}
		}
		if(a == 9){
			return false;
		}
		else{
			return true;
		}
	}

// Return True si un des alignements est True
	public boolean getWinner(){
		return testLigne(0) || testLigne(1) || testLigne(2) || testColonne(0) || testColonne(1) || testColonne(2) || testDiago048() || testDiago246();
	}

// Return True si aucun alignement & aucunes cases vides
	public boolean isOver(){
		if(testLigne(0) == false && testLigne(1) == false && testLigne(2) == false && testColonne(0) == false && testColonne(1) == false && testColonne(2) == false && testDiago048() == false && testDiago246() == false && testCasesNull() == false){
			return true;
		}
		else{
			return false;
		}
	}

// Remplit la grille avec Joueur Courant || Change de joueur
	public void jouerTour(int n){
		grille[(int)(n/3)][n%3] = this.jc;
		this.changerJoueur();
	}

// Verifie que le coup rentré est possible
	public boolean validMoves(int n){
		return grille[(int)(n/3)][n%3] == null;
	}

// Affiche tout les coups possibles sous forme de liste
	public List<Integer> coupPossible(){
		int k=0;
		List<Integer> l = new ArrayList<> ();
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				if(grille[i][j] == null){
					l.add(k);
				}
				k++;
			}
		}
		return l;
	}

// Affiche une grille pour voir l'avancé de la partie
	public String situationToString(){
 		System.out.println("  ---------------------  ");
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(grille[i][j] == null){
					System.out.print(" " + "   |   ");
				}
				else{
					System.out.print("| " + grille[i][j] + " |");
				}
			}
			System.out.println(" ");
 			System.out.println("  ---------------------  ");
		}
		return " ";
	}

// Affiche la case qui vient d'être joué || appel coupPossible
	public String moveToString(Integer n){
		int lig = (int)(n/3);
		int col = n%3;
		System.out.println("Les cases jouables sont : ");
		System.out.println(this.coupPossible());
		return "Case (" + lig + "," + col + ")";
	}

// C'est la mothode de l'interface GamePlayer
	public int ChooseMove(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisissez la case que vous voulez jouer : ");
		int n = scanner.nextInt();
		while (validMoves(n) == false){
			System.out.println("Case deja prise ,Saisissez une case valide : ");
			n = scanner.nextInt();
		}
		return n;
	}

// Cree et retourne une copie d'une instance de class TicTacToe
	public AbstractGame getCopy(){
		TicTacToe res = new TicTacToe(this.joueur1,this.joueur2);
		res.jc = super.jc;
		return res;
	}
}
