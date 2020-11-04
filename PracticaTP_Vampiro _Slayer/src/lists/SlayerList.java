package lists;

import GameObjects.Slayer;
import logic.Game;
import logic.Level;

public class SlayerList {
	
	private Slayer Sarray[];
	private int Scont;
	public static final int MAX_SALYERS = 20;
	
	public SlayerList(Slayer Sarray[] , int Scont) {
		
		this.Sarray = new Slayer[MAX_SALYERS];
		this.Scont = Scont;
		
	}
	
	Level level;
	int tamArrayS, posX, posY;
	SlayerList Slist = new SlayerList(this.Sarray, this.Scont);
	
	
public Slayer[] setSarray(SlayerList Slist, int posX, int posY, Game game) {
		
		tamArrayS = level.getnumberOfVampires();
		
		for(int i = 0; i < tamArrayS; i++ ) {
			
			Slist.Sarray[i] = new Slayer(posX, posY, game);
			Slist.Scont++;
		}
		
		return Slist.Sarray;
		
	}
	

public Slayer[] getSarray() {
	
	return Sarray;
}

public int getScont() {
	
	return Scont;
}

public void setScont(int Scont) {
	
	this.Scont = Scont;
}

public static boolean SlayerVivo(SlayerList Slist, int pos) {
	
	boolean Smuerto = false;
	
	if(Slist.Sarray[pos].Vida == 0) {
		
		Smuerto = true;
	}
	
	return Smuerto;
}

	
	

}
