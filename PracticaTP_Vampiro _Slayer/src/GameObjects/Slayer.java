package GameObjects;

import logic.Game;

public class Slayer {
	
	private int posX;
	private int posY;
	private int vida;
	public static int VidaInicial = 3;
	public static final int DANYO = 1;
	public static final int Coste = 50;
	private Game game;
	
	public Slayer(int posX, int posY, Game game, int vida){
		
		this.posX = posX;
		this.posY = posY;
		this.game = game;
		this.vida = vida
		
	}
	
	public int getPosSx() {
		
		return posX;
	}
	
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
