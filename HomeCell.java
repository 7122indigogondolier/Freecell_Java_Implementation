/**
  * Foundation class
  * Part of the model
  * Programming project 6(Group Project- Adeyanju, Jha, Novak, Thapa)
  */

public class HomeCell extends AbstractCell{

	//constructor
	public HomeCell(){
	   super(); //using AbstractCell's constructor
	}


	/**
	* This boolean method checks to see if the homecell
	* pile is empty, and if the card's rank is one
	* (which is Ace), we can add it to empty homecell
	* if home cell pile is not empty , checks to see if the
	* card been added is
	* the same suit and one rank higher than the card
	* that is already in the pile.
	* @return true or false: after all criterion re checked
	*/

	public boolean canAddTo(Card card){
	  if (this.isEmpty()){
			if (card.getRank() == 1){
			   return true;}
			else{
			   return false;
			}
	 }
	  else{
			if (card.getSuit().toString().equals(this.peekTop().getSuit().toString()) && card.getRank() == this.peekTop().getRank()+1){
			     return true;
			}
			else{
			     return false;
			}
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
		throw new IllegalArgumentException("Illegal Move");
	}

	public boolean canMoveTo(Cell destination){
		throw new IllegalArgumentException("Illegal Move");
	}
}
