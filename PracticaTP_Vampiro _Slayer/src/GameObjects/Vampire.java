package GameObjects;

import logic.Game;
import logic.Level;

public class Vampire {
	
	private int posVx;
	private int posVy;
	private static int numVamp;
	private boolean finish;
	private Game game;
	private int vida;
	public static int VidaInicial = 5;
	public static final int DANYO = 1;
	

	public Vampire(int posVx, int posVy, int numVamp, boolean finish, Game game, int vida) {
		
		this.posVy = posVx;
		this.posVy = posVy;
		this.numVamp = numVamp;
		this.finish = finish;
		this.game = game;
		this.vida = vida;
		
	}
	
	Level level;
	
	public int getnumVamp() {
		
		return numVamp;
	}
	
	public int getposVx() {
		
		return posVx;
	}
	
	public int getposVy() {
		
		return posVy;
	}
	
	public boolean getfinish() {
		
		return finish;
	}
	
	public Game getGame() {
		
		return game;
	}
	
	public void setPosVx(int posVx) {
		this.posVx = posVx;
	}

	public void setPosVy(int posVy) {
		this.posVy = posVy;
	}

	public static void setNumVamp(int numVamp) {
		Vampire.numVamp = numVamp;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public static void setVida(int vida) {
		Vida = vida;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	public int getVida(){
		
		return vida;
	}
	
	public void setVida(int vida){
		
		this.vida = vida;
	}

}
