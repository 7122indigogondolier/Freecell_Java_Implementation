/**
  * This program tests the game and the cells
  * @author Adeyanju, Jha, Novak, Thapa
  * @version 1.0
  */

  public class Tester{

    public static void main(String[] args){
      Game game = new Game();
      System.out.println("");
      System.out.println("Initial state of the game (Displaying all cells)");
      System.out.println("Expect empty cells: ");
      System.out.println(game);

      System.out.println("");
      System.out.println("Dealing the cards to the Tableau cells");
      //game.deal();
      System.out.println("Displaying only the first Tableau cell");
      System.out.println(game.getTCell(0).toString());
      System.out.println("Size of first Tableau cell (Expect 7): " + game.getTCell(0).size());
      System.out.println("Size of second Tableau cell (Expect 7): " + game.getTCell(1).size());
      System.out.println("Size of third Tableau cell (Expect 7): " + game.getTCell(2).size());
      System.out.println("Size of fourth Tableau cell (Expect 7): " + game.getTCell(3).size());
      System.out.println("Size of fifth Tableau cell (Expect 6): " + game.getTCell(4).size());
      System.out.println("Size of sixth Tableau cell (Expect 6): " + game.getTCell(5).size());
      System.out.println("Size of seventh Tableau cell (Expect 6): " + game.getTCell(6).size());
      System.out.println("Size of eighth (and last) Tableau cell (Expect 6): " + game.getTCell(7).size());

      System.out.println("");
      System.out.println("Moving the card at the top of tableau cell 1 to free cell 1");
      System.out.println(game.move(game.getTCell(0), game.getFCell(0)));
      System.out.println("Testing moveCount (Expect 1): " + game.getMoveCount());
      System.out.println("Displaying the size of free cell 1 (Expect 1): " + game.getFCell(0).size());
      System.out.println("Displaying the size of tableau cell 1 (Expect 6): " + game.getTCell(0).size());
      System.out.println("Displaying free cell 1: ");
      System.out.println(game.getFCell(0));
      System.out.println("Displaying tableau cell 1: ");
      System.out.println(game.getTCell(0));

      System.out.println("Testing home cell 1 (Expect 0): " + game.getHCell(0).size());
      System.out.println("Testing home cell 2 (Expect 0): " + game.getHCell(1).size());
      System.out.println("Testing home cell 3 (Expect 0): " + game.getHCell(2).size());
      System.out.println("Testing home cell 4 (Expect 0): " + game.getHCell(3).size());

      //test exceptions here by uncommenting the following lines of code one at a time (exceptions stop the flow of the program)
      System.out.println("");
      //System.out.println("Moving the top card in tableau cell 2 to tableau cell 3 (Might raise exception): ");
      //game.move(game.getTCell(2), game.getTCell(3));

      //System.out.println("Moving the top card in tableau cell 4 to home cell 1 (Might raise exception): ");
      //game.move(game.getTCell(4), game.getHCell(1));

      //System.out.println("Trying to remove card from home cell 1 (Expect exception): ");
      //game.move(game.getHCell(1), game.getFCell(2));

      //System.out.println("Trying to add illegal card to home cell: ");
      //System.out.println("Expect exception: ");
      //Card illegalCard = new Card(Suit.spade, 3);
      //game.getHCell(3).add(illegalCard);

      //System.out.println("Trying to add more than one card in a free cell: ");
      //System.out.println("Expect exception: ");
      //Card firstCard = new Card(Suit.spade, 1);
      //Card secondCard = new Card(Suit.spade, 2);
      //game.getFCell(4).add(firstCard);
      //game.getFCell(4).add(secondCard);

      //testing tableau cell pile of cards (trying to move cards from the middle of the pile)
      //System.out.println("Trying to remove cards from the middle of the tableau cell pile: ");
      //System.out.println("Might raise exception: ");
      //game.move(game.getTCell(7), game.getTCell(2));




      //testing home cells
      //adding two cards of the same suit in order in home cell 2
      System.out.println("");
      System.out.println("Adding two legal cards into home cell 2");
      Card card1 = new Card(Suit.spade, 1);
      Card card2 = new Card(Suit.spade, 2);
      game.getHCell(2).add(card1);
      game.getHCell(2).add(card2);
      System.out.println("Size of home cell 2 (Expect 2): " + game.getHCell(2).size());
      System.out.println("");
      System.out.println("Displaying home cell 2: ");
      System.out.println(game.getHCell(2).toString());
    }
  }
