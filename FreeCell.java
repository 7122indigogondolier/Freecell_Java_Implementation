/**
 * The FreeCell class represents the FreeCell pile which holds only one card
 * @author - Adeyanju, Jha, Novak, Thapa
 * @version 1.0
 *
*/


public class FreeCell extends AbstractCell {

    /**
     * Constructor method that calls the contructor method in parent class, AbstractCell
    */
    public FreeCell() {
        super();
    }

    /**
     * Adds the card to the FreeCell pile if the pile is empty
     * @param card to be added
     * @return nothing
    */
    public boolean add(Card card) {
        if (this.canAddTo(card)) {
            this.listOfCards.add(card);
		 return true;
        } else {
          throw new IllegalArgumentException("Illegal Move");
        }
    }

    /**
     * Removes the card from the FreeCell pile if the pile is not empty and returns a list containing the cards
     * @param index of card in the pile
     * @return a card at the index number
    */
    public boolean remove(Card card) {
        if (!(this.isEmpty())) {
            this.listOfCards.remove(card);
            return true;
        } else {
          throw new IllegalArgumentException("Illegal Move");
        }
    }


    /**
     * Checks if the given card can be added to the pile or no
     * @param card to see if it can be added
     * @return true if card can be added to pile, false otherwise
    */
    public boolean canAddTo(Card card) {
        if (this.isEmpty()) {
          return true;
        }
        return false;
    }


    /**
     * Checks if a card can be moved from FreeCell pile to the other piles
     * @param Cell that is potential destination for the card to be moved
     * @return true if card can be moved to the passed destination
    */
    public boolean canMoveTo(Cell destination) {
        if (destination instanceof Tableau) {
            if (destination.canAddTo(this.peekTop())) {
                return true;
            }
        } else if (destination instanceof HomeCell) {
            if (destination.canAddTo(this.peekTop())) {
                return true;
            }
        }
        return false;
    }

}
