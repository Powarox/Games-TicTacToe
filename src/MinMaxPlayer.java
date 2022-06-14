package src;
import java.util.*;
import java.lang.*;

public class MinMaxPlayer implements GamePlayer {

	public int ChooseMove(AbstractGame game){
		return negamax(game, game.jc);
	}

// l'algorithme negamax prend en argument une instance de la class abstract et un joueur puis renvoie le meilleur coup possible pour le MinMaxPlayer
	public int negamax (AbstractGame game, GamePlayer jc){
		float meilleurValeur = Float.NEGATIVE_INFINITY;
		int meilleurcoup = 0;
		int vprime ;
		for(int coup : game.coupPossible()){
			game = game.getCopy();
			game.jouerTour(coup);
			jc = game.getCurrentPlayer();
			vprime = -evaluer(game, jc);
			if(vprime>meilleurValeur){
				meilleurValeur = vprime;
				meilleurcoup = coup;
			}
		}
		return meilleurcoup;
	}


	public int evaluer(AbstractGame game, GamePlayer jc){
		float res;
		int vprime ;
		int rtn = 0;
		if(game.getWinner() == false && game.jc == jc){
			return +1;
		}
		else if (game.getWinner() == false && game.jc != jc){
			return -1;
		}
		else if (game.getWinner() == true && game.getWinner() == false){
			return 0;
		}
		else{
			res = Float.NEGATIVE_INFINITY;
			for(int coup : game.coupPossible()){
				game = game.getCopy();
				game.jouerTour(coup);
				jc = game.getCurrentPlayer();
				vprime = -evaluer(game, jc);
				float res1 = Math.max(res, vprime);
				rtn = Math.round(res1);
			}
		return rtn;
		}
	}

// Affichage pour le joueur aleatoire avec son hashCode
	public String toString(){
		return("Joueur aleatoire #" + this.hashCode());
	}
}
