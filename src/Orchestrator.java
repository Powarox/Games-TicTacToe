package src;
import java.util.*;

public class Orchestrator {
	AbstractGame game;
	AbstractGame game2;
	GamePlayer player;

	public void faireJouer(AbstractGame game){	// Boucle de jeu qui appel toute les methode nécéssaire
		game2 = game.getCopy();
		while(game.getWinner() == false){			// la partie s'arrête si on à un gagnant || On sort du While
			player = game.getCurrentPlayer();
			System.out.println(game.situationToString());
			System.out.println("C'est au tour de " + player + " de Jouer");
			int index = player.ChooseMove(game);
			game.jouerTour(index);
			System.out.println(game.moveToString(index));
			if(game.isOver() == true){					// Ou si la grille (Pour le Moprion) est remplit || On sort du While
				break;
			}
		}
		if(game.isOver() == true){	// IsOver true dans le Morpion --> On à match null || dans le Nim --> On à un gagnant
			if(game.getWinner() == true){	// On effectue une deuxième boucle if ici pour contrer le Nim qui doit forcement avoir un gagant
				System.out.println("Partie fini, Le vainqueur est : " + game.jc);
				System.out.println(" ");
				while(game2.rejouer() == true){	// Appel la Methode rejouer pour savoir si le joueur veut continuer
					Orchestrator or = new Orchestrator();
					or.faireJouer(game2);
				}
			}
			else{	// Si isOver est true et getWinner False --> la partie est fini mais il n'y aucun gagnant (Que pour le Morpion)
				System.out.println("La Partie est Null, Egalite !");
				System.out.println(" ");
				while(game2.rejouer() == true){	// Appel la Methode rejouer pour savoir si le joueur veut continuer
				  	Orchestrator or = new Orchestrator();
					or.faireJouer(game2);
				}
			}
		}
		else{	// Si isOver est false cela veut dire que getWinner est true donc on affiche le gagnant
			game.changerJoueur();	// On appel denouveau changerJoueur pour afficher le bon gagnant
			System.out.println(game.situationToString());
			System.out.println("Partie fini, Le vainqueur est : " + game.jc);
			System.out.println(" ");
			while(game2.rejouer() == true){	// Appel la Methode rejouer pour savoir si le joueur veut continuer
			  	Orchestrator or = new Orchestrator();
				or.faireJouer(game2);
			}
		}
	}
}
