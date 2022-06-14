package src;
import java.util.*;

public class Player {
	protected String name;

// Constructeur de la class Player
	public Player (String getName){
		this.name = getName;
	}

// methode retournant le nom du joueur
	public String toString(){
		return name;
	}
}
