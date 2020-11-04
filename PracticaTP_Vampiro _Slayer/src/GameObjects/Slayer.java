package GameObjects;

import logic.Game;

public class Slayer {
	
	private int posX;
	private int posY;
	public static int Vida = 3;
	public static final int DANYO = 1;
	public static final int Coste = 50;
	private Game game;
	
	public Slayer(int posX, int posY, Game game){
		
		this.posX = posX;
		this.posY = posY;
		this.game = game;
		
	}
	
	public int getPosSx() {
		
		return posX;
	}
	
	/*public int getPosSy() {
		
		return posY;
	}*/
	
	public void setPosSx(int posX) {
		
		this.posX = posX;
	}
	
	public void setPosSy(int posY) {
		
		this.posY = posY;
	}

	public int getPosSy() {
		// TODO Auto-generated method stub
		return posY;
	}
	
	
	}
