// Nous avons créer cette Classe Initialisation pour alléger le Main
package src;
import java.util.*;

public class Initialisation  {
	public Scanner scanner = new Scanner(System.in);

	public GamePlayer choixdejoueur(){
		System.out.println(System.lineSeparator());
		System.out.println("Choisissez les types de joueurs :");
		System.out.println("Tapez 1 si c'est deux humains :");
		System.out.println("Tapez 2 si c'est un humain vs un joueur aleatoire :");
		System.out.println("Tapez 3 si c'est un humain vs l'algorithme MinMax :");
		System.out.println("Tapez 4 si c'est un joueur aleaotoire vs l'algorithme MinMax :");
		return null;
	}

// Verifie si la saisie est bonne pour le jeu
	public int verifie_jeu(){
		int gameChoose = 0;
     	boolean valid = false;
		while(! valid){
   		try{
   			gameChoose = scanner.nextInt();
   			if(gameChoose == 1 || gameChoose == 2){	// Le coup est valide on sort du while
   				valid = true;
					break;
   			}
		 		else{		// Le coup est un chiffre mais pas valide on redemande la saisie
     				System.out.println("La Valeur entree n'est pas valide !");
   			}
   		}
			catch (InputMismatchException e){	// Le coup n'est pas un chiffre on redemande la saisie
         	System.out.println("Veuillez entrer un chiffre svp ! 1 pour jouer au MORPION et 2 pour jouer au NIM");
         	scanner.next();
         }
		}
		return gameChoose;
	}

// Verifie si la saisie est bonne pour le mode de jeu
	public int verifie_mode_de_jeu(){
		int gameChoose2 = 0 ;
    	boolean valid2 = false;
		while(! valid2){
			try{
   			gameChoose2 = scanner.nextInt();
   			if(gameChoose2 == 1 || gameChoose2 == 2  || gameChoose2 == 3 || gameChoose2 == 4 ){ // Le coup est valide on sort du while
     			 	valid2 = true;
					break;
     			}
			 	else{		// Le coup est un chiffre mais pas valide on redemande la saisie
    				System.out.println("La Valeur entree n'est pas valide. veuillez entrer une valeure comprise entre 1 et 4 !");
     			}
			}
			catch (InputMismatchException e){	// Le coup n'est pas un chiffre on redemande la saisie
   			System.out.println("Veuillez entrer un chiffre svp !");
   			scanner.next();
   		}
		}
		return gameChoose2;
	}

// Choix du mode de jeu pour le Morpion
	public GamePlayer humanVShuman(){
		System.out.println(System.lineSeparator());
		Scanner scanner = new Scanner(System.in);

		System.out.println("Saisissez un nom de joueur : ");
		String joueur1 = scanner.nextLine();
		System.out.println("Saisissez un nom de joueur : ");
		String joueur2 = scanner.nextLine();

		GamePlayer [][] grille = new GamePlayer [3][3];
		AbstractGame game = new TicTacToe(new Human(joueur1), new Human(joueur2));
		Orchestrator or = new Orchestrator();

		or.faireJouer(game);
		return null;
	}

	public GamePlayer humanVSjoueuraleatoire(){
		System.out.println(System.lineSeparator());
		Scanner scanner = new Scanner(System.in);

		System.out.println("Saisissez un nom de joueur : ");
 		String joueur1 = scanner.nextLine();

		GamePlayer [][] grille = new GamePlayer [3][3];
		AbstractGame game = new TicTacToe(new Human(joueur1), new RandomPlayer());
		Orchestrator or = new Orchestrator();

		or.faireJouer(game);
		return null;
	}

	public GamePlayer humanVSMinMaxPlayer(){
		System.out.println(System.lineSeparator());
		Scanner scanner = new Scanner(System.in);

		System.out.println("Saisissez un nom de joueur : ");
		String joueur1 = scanner.nextLine();

		GamePlayer [][] grille = new GamePlayer [3][3];
		AbstractGame game = new TicTacToe(new MinMaxPlayer(), new Human(joueur1));
		Orchestrator or = new Orchestrator();

		or.faireJouer(game);
		return null;
	}

	public GamePlayer joueuraleatoireVSMinMaxPlayer(){
		GamePlayer [][] grille = new GamePlayer [3][3];
		AbstractGame game = new TicTacToe(new RandomPlayer(), new MinMaxPlayer());
		Orchestrator or = new Orchestrator();

		or.faireJouer(game);
		return null;
	}

// Choix du mode de jeu pour le Nim
	public GamePlayer humanVShuman2(){
		System.out.println(System.lineSeparator());
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisissez un nom de joueur : ");
 		String joueur1 = scanner.nextLine();
		System.out.println("Saisissez un nom de joueur : ");
 		String joueur2 = scanner.nextLine();
		System.out.println("Saisissez n : ");
		int n = scanner.nextInt();
		System.out.println("Saisissez k : ");
		int k = scanner.nextInt();

		RandomPlayer rp = new RandomPlayer();
		AbstractGame gameNim = new Nim(n, k, new Human(joueur1), new Human(joueur2));
		Orchestrator or = new Orchestrator();

		or.faireJouer(gameNim);
		return null;
	}

	public GamePlayer humanVSjoueuraleatoire2(){
		System.out.println(System.lineSeparator());
		Scanner scanner = new Scanner(System.in);

		System.out.println("Saisissez un nom de joueur : ");
 		String joueur1 = scanner.nextLine();

		System.out.println("Saisissez n : ");
		int n = scanner.nextInt();
		System.out.println("Saisissez k : ");
		int k = scanner.nextInt();

		RandomPlayer rp = new RandomPlayer();
		AbstractGame gameNim = new Nim(n, k, new Human(joueur1), new RandomPlayer());
		Orchestrator or = new Orchestrator();

		or.faireJouer(gameNim);
		return null;
	}

	public GamePlayer humanVSMinMaxPlayer2(){
		System.out.println(System.lineSeparator());
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisissez un nom de joueur : ");
 		String joueur1 = scanner.nextLine();

		System.out.println("Saisissez n : ");
		int n = scanner.nextInt();
		System.out.println("Saisissez k : ");
		int k = scanner.nextInt();

		RandomPlayer rp = new RandomPlayer();
		AbstractGame gameNim = new Nim(n, k, new Human(joueur1),new MinMaxPlayer());
		Orchestrator or = new Orchestrator();

		or.faireJouer(gameNim);
		return null;
	}

	public GamePlayer joueuraleatoireVSMinMaxPlayer2(){
		System.out.println(System.lineSeparator());
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisissez n : ");
		int n = scanner.nextInt();
		System.out.println("Saisissez k : ");
		int k = scanner.nextInt();

		RandomPlayer rp = new RandomPlayer();
		AbstractGame gameNim = new Nim(n, k, new RandomPlayer(),new MinMaxPlayer());
		Orchestrator or = new Orchestrator();

		or.faireJouer(gameNim);
		return null;
	}
}
