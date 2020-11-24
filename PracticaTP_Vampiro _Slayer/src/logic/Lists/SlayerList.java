package logic.Lists;

import logic.Game;
import logic.Level;
import logic.GameObjects.Slayer;

public class SlayerList {
	
	private Slayer[] Sarray;
	private int Scont;
	public static final int MAX_SALYERS = 20;
	
	public SlayerList(Slayer Sarray[] , int Scont) {
		
		this.Sarray = new Slayer[MAX_SALYERS];
		this.Scont = Scont;
		
	}
	
	Level level;
	int tamArrayS, posX, posY;
	SlayerList Slist = new SlayerList(this.Sarray, this.Scont);
	
	
/*public Slayer[] setSarray(SlayerList Slist, int posX, int posY, Game game) {
		
		tamArrayS = level.getnumberOfVampires();
		
		for(int i = 0; i < tamArrayS; i++ ) {
			
			Slist.Sarray[i] = new Slayer(posX, posY, game);
			Slist.Scont++;
		}
		
		return Slist.Sarray;
		
	}*/
	

/*public Slayer[] getSarray() {
	
	return Sarray;
}*/

public int getScont() {
	
	return Scont;
}

public void setScont(int Scont) {
	
	this.Scont = Scont;
}

public boolean SlayerMuerto(SlayerList Slist, int pos) {
	
	boolean Smuerto = false;
	
	if(this.getSlayerOfArray(pos).getVida == 0) {
		
		Smuerto = true;
	}
	
	return Smuerto;
}
	
	public Slayer getSlayerOfArray(int i){
		
		return Sarray[i];
	}
	
	
public int Slayer AnnadirSlayerLista(SlayerList Slist, int x, int y, Game game) {
	
	int pos = 0;
	
	Slist.Sarray[getScont()] = new Slayer(Slayer.setPosSx(x), Slayer.setPosSy(y), game);
	Scont++;
	setScont(Scont);
	pos = getScont() - 1;
	
	return pos;
}



}
