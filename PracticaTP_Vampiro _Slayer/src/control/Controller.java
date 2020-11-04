package control;

import java.util.Scanner;
import GameObjects.Slayer;
import GameObjects.Vampire;
import lists.SlayerList;
import lists.VampireList;
import logic.GameObjectBoard;
import view.GamePrinter;
import logic.Game;

public class Controller {

	
	public final String prompt = "Command > ";
	public static final String helpMsg = String.format(
			"Available commands:%n" +
			"[a]dd <x> <y>: add a slayer in position x, y%n" +
			"[h]elp: show this help%n" + 
			"[r]eset: reset game%n" + 
			"[e]xit: exit game%n"+ 
			"[n]one | []: update%n");
	
	public static final String unknownCommandMsg = String.format("Unknown command");
	public static final String invalidCommandMsg = String.format("Invalid command");
	public static final String invalidPositionMsg = String.format("Invalid position");


    private Game game;
    private Scanner scanner;
    
    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    this.setScanner(scanner);
    }
    
	public Scanner getScanner() {
		return scanner;
	}

    public void setScanner(Scanner scanner) {
    	
    	this.scanner = scanner;
    }
    
    GameObjectBoard Board;
    GamePrinter Tab;
    SlayerList Slist;
    VampireList Vlist;
    String[][] board;
    Slayer[] Sarray;
    int Scont = Slist.getScont();
	int Vcont = Vlist.getContador_Vamp();
	Vampire[] Varray = Vlist.getVarray();
    
    public void  printGame() {
   	 System.out.println(game);
   }
    
    public void run() {
    	
    	boolean fin = false;
    	boolean ganador = false;
    	
    	do {
    		
    		fin = this.EjecutarOpcion(Board, Tab, Slist, board, Sarray);
    		ganador = game.HayGanador(Vcont, Sarray, Varray);
    		
    	}while(fin!= true && ganador != true);
    	

    }
    
    
    
    
    //FUNCION SELECC OPCION:
    
    public String SeleccionarOpcion() {
    	
    		System.out.println(this.helpMsg);
    		System.out.println(this.prompt);
    		String respuesta = scanner.nextLine();
    		String[] letras = respuesta.toLowerCase().trim().split("\\s+");
    	
    	return letras[0];
    }
    
    
    
    // FUNCION EJECUCION DE LA ACCION:
    
    public boolean EjecutarOpcion(GameObjectBoard Board, GamePrinter Tab, SlayerList Slist, String[][] board, Slayer[] Sarray) {
    	
    	boolean salir = false;
    	
    	switch(this.SeleccionarOpcion()) {
    	
    	case "a": 
    		
    			System.out.println("Ha seleccionado anyadir nuevo Slayer");
    			Board.addSlayer(Board,Tab, Slist, board, Sarray);
    			break;
    		
    	case "h":
    		
    			System.out.println("Ha seleccionado Help");
    			break;
    		
    	case "r":
    		
    			System.out.println("Ha seleccionado resetear el juego");
    			break;
    		
    	case "e":
    		
    			System.out.println("Ha seleccionado SALIR del juego");
    			salir = true;
    			break;
    	
    	case "n":
    		
    			System.out.println("Ha seleccionado avanzar de ciclo en el juego");
    			break;
    		
    	
    	}
    	
    	
    	
    	return salir;
    }

}
