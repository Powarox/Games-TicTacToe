package src;
import java.util.*;

public class RandomPlayer implements GamePlayer {
	public Random rand;
	protected String name;
	public Random randomGenerator;

	AbstractGame game;

	public RandomPlayer(){
		this.rand = new Random();
	}

// C'est la mothode de l'interface GamePlayer
	public int ChooseMove(AbstractGame game){
		int y = game.coupPossible().size();
		int ind = this.rand.nextInt(y);
		return game.coupPossible().get(ind);
	}

	public String toString(){
		return("Joueur aleatoire #" + this.hashCode());
	}
}
