/**
  * This program defines a class Tableau for the Tableaux cells
  * @author Adeyanju, Jha, Novak, Thapa
  * @version 1.0
  */

  public class Tableau extends AbstractCell {

    //constructor
    public Tableau(){
      super(); //using AbstractCell's constructor
    }

    public boolean canAddTo(Card card){
      if (listOfCards.isEmpty()){
        return true;
      }
      else{
        int rankDifference;
        rankDifference = super.peekTop().getRank() - card.getRank();
        if (rankDifference == 1){
          if (!(super.peekTop().sameColor(card))){
              return true;
          }
        }
        return false;
      }
    }

    public boolean add(Card card){
      if (this.canAddTo(card)){
        listOfCards.add(card);
	      return true;
      }
      else{
        throw new IllegalArgumentException("Illegal Move");
      }
    }

    public boolean remove(Card card){
     if (!(this.isEmpty())){
      listOfCards.remove(card);
      return true;
     }
     return false;
    }

    public boolean canMoveTo(Cell destination) {
      if (destination instanceof FreeCell) {
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
