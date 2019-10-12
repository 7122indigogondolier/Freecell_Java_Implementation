/**
  * This is the Cell Interface
  * @author: Adeyanju, Jha, Novak and Thapa
  * @version 2.0
  */

  import java.util.*;

  public interface Cell extends Iterable<Card> {

    /**
      * Returns the size of the cell
      * @return size returns integer value which is the size of the cell
      */
    public int size();

    /**
      * Returns true if the cell is is empty
      * @return isEmpty returns a Boolean type
      */
    public boolean isEmpty();

    /**
      * Adds a card to the cell
      * @param card of type Card
      */
    public boolean add(Card card);

    /**
      * Removes and returns a card from the cell
      * @return remove returns a card from the cell
      */
    public Card pop();

    /**
    * @param card
    * @return true if can remove and false if otherwise
    */
    public boolean remove(Card card);

    /**
      * Returns true if a card or a pile of cards can be removed from the cell
      * @param source of type Cell
      */
    public boolean canMoveFrom(Cell source, Card card);

    /**
      * Returns true if a card or a pile of cards can be removed from the cell
      * @param destination of type Cell
      */
    //public boolean canMoveTo(Cell destination);

    /**
      * Returns true if card can be added to the destination cell
      * @param card of type Card
      * @return canAddTo returns true if card can be added to destination cell
      */
    public boolean canAddTo(Card card);

    /**
      * Returns string representation of Cell
      * @return toString returns a string representation of Cell class
      */
    public String toString();

    /**
      * Returns the card at the top of the pile in the cell
      * @return peekTop returns a card type
      */
    public Card peekTop();

    /**
      * Loop cards contained in the cell
      * @return card returns cards in cell
      */
    public Iterator<Card> iterator();

   /**
     * Moves card from source.
	   * @param source
	   * @return a boolean. True if can move card from source,
	   * false otherwise.
	   */
   public boolean moveFrom(Cell source);

   /**
	   * Clears the game
     */
   public void clear();

   /**
      * Adds a card to the tableau cell
      * @param card of type Card which is the card to be added onto the pile in the cell
      */
    public void initialAdd(Card card);

    /**
      * Returns the card from the pile according to the index
      * @param i of int type which is the card index
      * @return get method returns a Card according to the index passed as argument
      */

    public Card get(int i);

   // /**
   //    * Returns true if the cards in the Tableau cell are ordered in ascending rank ordere
   //    * @return inOrder returns boolean value true if cards in the cell are ordered appropriately
   //    */
   public boolean inOrder(int index);
   


 }
