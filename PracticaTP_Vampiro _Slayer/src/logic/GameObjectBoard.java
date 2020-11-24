package logic;

import logic.Game;
import logic.Level;
import logic.GameObjects.Player;
import logic.GameObjects.Vampire;
import logic.lists.SlayerList;
import logic.lists.VampireList;

import java.util.Random;

import view.GamePrinter;
import control.Controller;

public class GameObjectBoard {

	public static int MAX_DIM_X= 10;
	public static int MAX_DIM_Y= 10;
	
	private SlayerList Slist;
	private VampireList Vlist;
	
	public GameObjectBoard(){
		
		this.Slist = new SlayerList();
		this.Vlist = new VampireList();
		
	}	
	
	public SlayerList getSlist() {
		
		return Slist;
	}
	
	public VampireList getVlist() {
		
		return Vlist;
	}
	
	Level level;
	Game game;
	Player Player;
	GamePrinter Tab;
	Controller controller;
	Random Aleatorio;
	int Scont, money;
	
	
	double vampireFrequency = level.getvampireFrequency();
	int Vcont = Vlist.getContador_Vamp();
	//Vampire[] Varray = Vlist.getVarray();			

	public void addSlayer(GameObjectBoard Board, GamePrinter Tab, SlayerList this.Slist, String[][] board, Game game) {
		
		board = Tab.getBoard();
		money = Player.getMoney();
		Scont = Slist.getScont();
		
		int pos = 0;
		
		if(!game.PuedeComprarSlayer(Player)) {
			
			System.out.println(" ERROR, le usuario no posee suficiente dinero para comprar un Slayer nuevo... ");
			
		}else {
			
			System.out.println(" ELIJA LA POSICION DONDE AÑADIR EL SIGUIENTE SLAYER ");
			System.out.println(controller.prompt);
			int x = controller.getScanner().nextInt();
			int y = controller.getScanner().nextInt();
			
			if(board[x][y] == null) {
				
				pos = this.Slist.AnnadirSlayerLista(this.Slist,x,y,game);
				this.ColocarSlayerTablero(x, y, this.Slist, board, pos);
				Scont++;
				Slist.setScont(Scont);
				
			}else if(board[x][y] == "S") {
				
				System.out.println(" ERROR, esa posición está ocupada por otro Slayer ");
				
			}else if(board[x][y] == "V") {
				
				System.out.println(" ERROR, esa posición está ocupada un Vampiro ");
				
			}
		}
		
		}
	
	
	public void EliminarSlayer_Lista(SlayerList this.Slist, int posSx, int posSy) {
		
		int pos = 0;
		
		for(int i = 0; i < Slist.Sarray.length; i++){
			
			if(this.Slist.getSlayerOfArray(i).getPosSy == posSy){
				
				pos = i;
				
				if(!SlayerMuerto(SlayerList this.Slist, int pos)){
			
					System.out.println(" No se puede eliminar el Slayer, porque está vivo ")
			
				}else{
			
					for(int j = pos; j < Sarray.length; j++) {
					
						Sarray[j] = Sarray[j+1];
						Scont--;
						Slist.setScont(Scont);
						
					}
				}		
			}
		}
	
	}
	
	public void ColocarSlayerTablero(int x, int y, SlayerList this.Slist, String[][] board, int pos ) {
			
		Slist.getSlayerOfArray(pos).setPosSx(x);
		Slist.getSlayerOfArray(pos).setPosSy(y);
		board[x][y] = "S";

	}
	
	public boolean ColocarVampireTablero(int x, int y, String[][] board) {
		
		boolean colocado = false;
		
		if(board[x][y] == null) {
			
			board[x][y] = "V";
			colocado = true;
			
		}else if(board[x][y] == "V") {
			
			colocado = false;
		}
		
		return colocado;
	}
	
	public void EliminarVampire_Lista(Vampire[] Varray, int Scont, int posVx,int posVy) {
		
		for(int i = 0; i < Varray.length; i++) {
			
			if(Varray[i].getposVx() == posVx && Varray[i].getposVy() == posVy) {
				
				int pos = i;
				
				for(int j = pos; j < Varray.length; j++) {
					
					Varray[j] = Varray[j+1];
					Vcont--;
					Vlist.setContador_Vamp(Vcont);
					
				}
				
			}
			
		}
	}
	
	public void AddVampire(GameObjectBoard Board, GamePrinter Tab, VampireList this.Vlist, String[][] board, Random Aleatorio, Level level) {
		
		board = Tab.getBoard();
		//Varray = Vlist.getVarray();
		int posVampX = 0;
		int posVampY = 0;
		int dimY = 0;
		int i = 0;
		boolean puedeAnnadir = false;
		
		puedeAnnadir = game.PuedeAnyadirVampiro(level, Aleatorio);
		
		if(puedeAnnadir == false) {
			
			System.out.println(" El azar ha querido que no se genere un Vampiro nuevo en este ciclo");
		
		}else {
			
			posVampX = level.getdim_x();
			dimY = level.getdim_y();
			posVampY = Aleatorio.nextInt(dimY+1);
			
			if(Board.ColocarVampireTablero(posVampX, posVampY, board)) {
				
				Vampire AnnadirVampireLista(VampireList this.Vlist,posVampX, posVampY,game);
				
				/*Vlist.getVampireOfArray(i).setPosVx(posVampX);
				Vlist.getVampireOfArray(i).setPosVy(posVampY);
				i++;*/
				
				System.out.println(" Ha sido anyadido de manera correcta un Vampiro");
				
			}else {
				
				System.out.println(" ERROR, esa posición está ocupada un Vampiro ");
			}
			
		}
	}
		
	
}
