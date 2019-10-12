/**
  * Game class
  * Part of the model
  * @author Adeyanju, Jha, Novak, Thapa
  * @version 1.0
  */
import java.util.*;


public class Game{

    //instance variables
    private Deck deck;
    private int moveCount;
    private Cell[] free = new Cell[4];
    private Cell[] home = new Cell[4];
    private Cell[] tableau = new Cell[8];

    /**
      * Constructor class sets the initial state of the object
      */
    public Game(){
      for (int i = 0; i < 4; i ++){
		      free[i] = new FreeCell();
	        home[i] = new HomeCell();
      }
  	  for (int i = 0; i < 8; i ++){
  		    tableau[i] = new Tableau();
      }
      moveCount = 0;
      reset();
  	}

  /**
    * Creates a new deck, shuffles and deals
    * the card for a new game.
  */
  public void reset(){
  	for (Cell cellF : free){
  	    cellF.clear();
  	}
    for (Cell cellH : home){
  	   cellH.clear();
  	}
  	for (Cell cellT : tableau){
  	   cellT.clear();
  	}
  	deck = new Deck();
  	deck.shuffle();
  	this.deal();
    this.moveCount = 0;
  }

  /**
    * Deals a specific number of cards to a specific pile
    * @param int n : the specific number of cards in the pile
    * @param Tableau t: the specific pile in which the cards are going to be dealt to
    */
   public void divvy(int n, Cell t){
        for (int j=0; j<n; j++) {
            Card card1 = deck.deal();
            card1.turn();
            t.initialAdd(card1);
        }
    }

    /**
    * Deals cards to the tableau class piles,
    * dealing 7 cards to the first four piles and 6 to the last four
    */
    public void deal(){
	     for (int i = 0; i < 4; i++) {
		       divvy(7, tableau[i]);
 	     }
	     for (int i = 4; i < 8; i++) {
		       divvy(6, tableau[i]);
 	     }
    }

      /**
        * Returns true if the game is over, false otherwise
        * @return isGameOver returns boolean value true/false
        */
      public Boolean isGameOver(){
        if (hasWinner() || hasLoser()){
          return true;
        }
        else{
          return false;
        }
      }

    /**
      * Returns true if there is a winner, false otherwise
      * @return hasWinner returns boolean value true/false
      */
    public boolean hasWinner(){
	     for (Cell cell: tableau){
	        if (!(cell.inOrder(0))){
            return false;
	        }
       }
       for (Cell cell: home){
         if (cell.size() == 13){
           return true;
         }
       }
       return true;
    }

    /**
    ``* Returns true if there is a loser
      * @return hasLoser returns boolean value true if there is no more legal moves left
      */
    public boolean hasLoser(){
      for (Cell element : free){
        if (!(element.size() == 1)){
          return false;
        }
      }
      for (int i = 0; i < 8; i++){
        for (Cell hCell: home){
          if (tableau[i].size() == 0) {
            return false;
          }
          if (hCell.canMoveFrom(tableau[i], tableau[i].peekTop())){
            return false;
          }
        }
        int j = i + 1;
        while (j < 8){
          if (tableau[j].size() == 0) {
            return false;
          }
          if (tableau[i].canMoveFrom(tableau[j], tableau[j].peekTop()) || tableau[j].canMoveFrom(tableau[i], tableau[i].peekTop())){
            return false;
          }
          j++;
        }
      }
      return true;
    }

    /**
      * Moves the game to the next step and updates all the values appropriately
      * @param source of type Cell is the source cell from which the card/s are going to be moved
      * @param destination of type Cell is the destination cell to which the card/s are going to be moved
      * @return boolean value true if there is a move made, false otherwise
      */
    public boolean move(Cell source, Cell destination){
       if (!(this.isGameOver())){
	     moveCount += 1;
          return destination.moveFrom(source);

       }
       return false;
    }

    /**
      * Returns a tableau cell
      * @param i of type int which is the index of the tableau cell (Tableau1, or Tableau2 etc)
      * @return getTCell returns a cell of type Tableau
      */
      public Cell getTCell(int i){
        if (i <= 8){
          return tableau[i];
        }
        else{
          throw new IllegalArgumentException("Index between 1 and 8 only");
        }
      }

    /**
      * Returns a free cell
      * @param i of type int which is the index of the free cell (FreeCell1, or FreeCell2 etc)
      * @return getFCell returns a cell of type FreeCell
      */
      public Cell getFCell(int i){
        if (i <= 4) {
          return free[i];
        }
        else{
          throw new IllegalArgumentException("Index between 1 and 4 only");
        }
      }

    /**
      * Returns a home cell
      * @param i of type int which is the index of the home cell (HomeCell1, or HomeCell2 etc)
      * @return getHCell returns a cell of type HomeCell
      */
      public Cell getHCell(int i){
        if (i <= 4) {
          return home[i];
        }
        else{
          throw new IllegalArgumentException("Index between 1 and 4 only");
        }
      }

    /**
      * Returns the move count in the game
      * @return getMOveCount returns moveCount of type int
      */
    public int getMoveCount(){
      return this.moveCount;
    }


    /**
      * Returns the String value that represents the current game status
      * @return String value which contains the current status of the game
      */
    public String toString(){
      String result = "\n";
      for (Cell cell: free){
	    result += "Free" + cell.toString() + "\n";
      }
      for (Cell cell: home){
	    result += "Home" + cell.toString() + "\n";
      }
      for (Cell cell: tableau){
	    result += "Tableau" + cell.toString() + "\n";
      }
      return result;
    }
}
