package lists;

import GameObjects.Vampire;
import logic.Game;
import logic.Level;

public class VampireList {
	
	private Vampire [] Varray;
	private int Vcont;
	public static final int MAX_VAMP = 10;
	
	public VampireList(Vampire Varray[] , int Vcont) {
		
		this.Varray = new Vampire [MAX_VAMP];
		this.Vcont = Vcont;
		
	}
	
	VampireList Vlist = new VampireList(this.Varray, this.Vcont);
	Level level;
	int posVx, posVy, numVamp, tamArrayV;
	boolean finish; 
	Game game;
	
	public Vampire[] setVarray(VampireList Vlist, int posVx, int posVy, int numVamp, boolean finish, Game game) {
		
		tamArrayV = level.getnumberOfVampires();
		
		for(int i = 0; i < tamArrayV; i++ ) {
			
			Vlist.Varray[i] = new Vampire(posVx, posVy, numVamp, finish, game);
			Vlist.Vcont++;
		}
		
		return Vlist.Varray;
		
	}
	
	public Vampire[] getVarray() {
		
		return Varray;	
	}
	
	public int getContador_Vamp() {
		
		return Vcont;
	}
	
	public void setContador_Vamp(int Vcont) {
		
		this.Vcont = Vcont;
	}
	
	
	
	public boolean VampVivo(VampireList Vlist, int pos) {
		
		boolean Vmuerto = false;
		
		if(Vlist.Varray[pos].Vida == 0) {
			
			Vmuerto = true;
		}
		
		return Vmuerto;
	}
	
	
		
		
	}

