package logic;

import GameObjects.Slayer;
import GameObjects.Vampire;
import lists.SlayerList;
import lists.VampireList;
import logic.Game;
import logic.Level;

import java.util.Random;

import GameObjects.Player;
import view.GamePrinter;
import control.Controller;

public class GameObjectBoard {

	public static int MAX_DIM_X= 10;
	public static int MAX_DIM_Y= 10;
	
	SlayerList Slist;
	VampireList Vlist;
	Level level;
	Game game;
	Player Player;
	GamePrinter Tab;
	Controller controller;
	Random Aleatorio;
	int Scont, money;
	//double vampireFrequency;
	
	double vampireFrequency = level.getvampireFrequency();
	int Vcont = Vlist.getContador_Vamp();
	Vampire[] Varray = Vlist.getVarray();			
			
	public void addSlayer(GameObjectBoard Board, GamePrinter Tab, SlayerList Slist, String[][] board, Slayer[] Sarray) {
		
		board = Tab.getBoard();
		money = Player.getMoney();
		Sarray = Slist.getSarray();
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
			
				this.ColocarSlayerTablero(x, y, Sarray, board, pos);
				Slist.setSarray(Slist, x, y, game);
				Scont = Scont++;
				Slist.setScont(Scont);
				
			}else if(board[x][y] == "S") {
				
				System.out.println(" ERROR, esa posición está ocupada por otro Slayer ");
				
			}else if(board[x][y] == "V") {
				
				System.out.println(" ERROR, esa posición está ocupada un Vampiro ");
				
			}
		}
		
		}
	
	
	public void EliminarSlayer_Lista(Slayer []Sarray, int Scont, int posSx, int posSy) {
		
		for(int i = 0; i < Sarray.length; i++) {
			
			if( Sarray[i].getPosSx() == posSx && Sarray[i].getPosSy() == posSy) {
				
				int posS = i;
				
				for(int j = posS; j < Sarray.length; j++) {
					
					Sarray[j] = Sarray[j+1];
					Scont--;
					Slist.setScont(Scont);
				}
			}
			
			
		}
	}
	
	public void ColocarSlayerTablero(int x, int y, Slayer[] Sarray, String[][] board, int pos ) {
			
		Sarray[pos].setPosSx(x);
		Sarray[pos].setPosSy(y);
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
	
	public void AddVampire(GameObjectBoard Board, GamePrinter Tab, VampireList Vlist, String[][] board, Vampire[] Varray, Random Aleatorio, Level level) {
		
		board = Tab.getBoard();
		Varray = Vlist.getVarray();
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
				
				Varray[i].setPosVx(posVampX);
				Varray[i].setPosVy(posVampY);
				i++;
				
				System.out.println(" Ha sido anyadido de manera correcta un Vampiro");
				
			}else {
				
				System.out.println(" ERROR, esa posición está ocupada un Vampiro ");
			}
			
		}
	}
		
	
}
