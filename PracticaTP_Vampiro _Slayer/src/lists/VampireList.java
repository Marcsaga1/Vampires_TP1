package lists;

import GameObjects.Vampire;
import logic.Game;
import logic.Level;

public class VampireList {
	
	private Vampire [] Varray;
	private int Vcont;
	public static final int MAX_VAMP = 10;
	
	public VampireList(Vampire[] Varray , int Vcont) {
		
		this.Varray = new Vampire [MAX_VAMP];
		this.Vcont = Vcont;
		
	}
	
	//VampireList Vlist = new VampireList(this.Varray, this.Vcont);
	Level level;
	int posVx, posVy, numVamp, tamArrayV, vida;
	boolean finish; 
	Game game;
	
	/*public void Vampire CrearVarray(VampireList Vlist, int posVx, int posVy, int numVamp, boolean finish, Game game, int vida) {
		
		tamArrayV = level.getnumberOfVampires();
		
		for(int i = 0; i < tamArrayV; i++ ) {
			
			Vlist.Varray[i] = new Vampire(posVx, posVy, numVamp, finish, game, vida);
			Vcont++;
			Vlist.setContador_Vamp(Vcont);
		}
		
		//return Vlist.Varray;
	}*/
	
	public int getContador_Vamp() {
		
		return Vcont;
	}
	
	public void setContador_Vamp(int Vcont) {
		
		this.Vcont = Vcont;
	}
	
	public Vampire getVampireOfArray(int i){
		
		return Varray[i];
	}
	
	
	public boolean VampMuerto(VampireList Vlist, int pos) {
		
		boolean Vmuerto = false;
		
		if(Vlist.getVampireOfArray(pos).getVida == 0) {
			
			Vmuerto = true;
		}
		
		return Vmuerto;
	}
	
	public void Vampire AnnadirVampireLista(VampireList Vlist, int x, int y, Game game) {
	
	Vlist.Varray[getContador_Vamp()] = new Vampire(Vampire.setPosVx(x), Vampire.setPosVy(y), game);
	Vcont++;
	this.setContador_Vamp(Vcont);
	pos = getContador_Vamp() - 1;
	
	}
	

	}

