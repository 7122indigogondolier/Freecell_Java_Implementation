/**
  * This program defines the AbstractCell class
  * @author Adeyanju, Jha, Novak and Thapa
  * @version 2.0
  */

  import java.util.*;
  public abstract class AbstractCell implements Cell {

    //declaring instance variables
    protected ArrayList<Card> listOfCards;

    //constructor class
    public AbstractCell(){
      this.listOfCards = new ArrayList<Card>();
    }

    //declaring abstract methods
    public abstract boolean add(Card card);
    public abstract boolean remove(Card card);
    //public abstract boolean canMoveTo(Cell destination);
    public abstract boolean canAddTo(Card card);

    public boolean canMoveFrom(Cell source, Card card){
      if (source.isEmpty() || source instanceof HomeCell) {
        return false;
      } else {
        return this.canAddTo(card);
      }
    }

    public Card pop(){
    	 Card c = this.peekTop();
    	 this.remove(c);
    	 return c;
    }

    public boolean moveFrom(Cell source){

      boolean found=false;
      int sourceSize = source.size();

      if ((source instanceof Tableau) && (this instanceof Tableau)) {
        for (int i = 0; i < source.size(); i++) {
          if ((this.canMoveFrom(source, source.get(i))) && (source.inOrder(i))) {
            for (int x = i; x < sourceSize; x++) {
              this.initialAdd(source.get(i));
              source.remove(source.get(i));
              found = true;
            }
          }
        }
      }

      if(this.canMoveFrom(source, source.peekTop())) {
	        this.add(source.pop());
	        found = true;
	     }

       return found;
    }

    public int size() {
      return listOfCards.size();
    }

    public void clear() {
	     listOfCards.clear();
    }

    public boolean isEmpty() {
        return listOfCards.isEmpty();
    }

    public String toString() {
        String description = "Here is the list of cards in this cell: \n";
        description += "" + "\n";
        Iterator<Card> iterator = listOfCards.iterator();
        for (Card card: listOfCards){
  		      description += card.toString()
                        + "\n";
        }
        return description;
    }

    public Card peekTop() {
      return listOfCards.get(this.size()-1);
    }

    public Iterator<Card> iterator() {
      return listOfCards.iterator();
    }

    public void initialAdd(Card card) {
      listOfCards.add(card);
    }

    public Card get(int i) {
        if ((i >= this.size()) || i < 0) {
            return null;
        } else {
	           return listOfCards.get(i);
        }
    }

    public boolean inOrder(int index) {
        boolean found = false;
	      for (int i = index; i < this.size()-1; i++) {
	         int rankDifference = listOfCards.get(i).compareTo(listOfCards.get(i + 1));
	         if (rankDifference == 1){
	            found = true;
	         } else {
	           return false;
	         }
	      }
        return found;
    }
}
