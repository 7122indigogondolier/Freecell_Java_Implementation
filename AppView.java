
/**
 * The main window for dealing from a deck of cards.
 * @author Novak, Jha, Thapa, Adeyanju
 * Project 7
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AppView extends JFrame{
    private TopPanel[] homePanel = new TopPanel[4];
    private TopPanel[] freePanel = new TopPanel[4];
    private BottomPanel[] tableauPanel = new BottomPanel[8];

    private Game game;
    private AbstractPanel fromPanel;
    private AppViewInformer viewInformer = new AppViewInformer();

    JLabel label3 = new JLabel("Move(s): 0");

    /**
      * Contructor method for class AppView: Sets the initial state of the object of class AppView
      * @param freeCell of type Game
      */
    public AppView(Game freeCell){
        this.setTitle("The Game of Free Cell");
        this.game = freeCell;
        //create new GUI elements
        JLabel label1 = new JLabel("Free Cells", SwingConstants.CENTER);
        JLabel label2 = new JLabel("Home Cells", SwingConstants.CENTER);

        Container pane = getContentPane();
	  pane.setBackground(new Color(230, 179, 237));

        for (int i=0; i<4; i++) {
            homePanel[i] = new TopPanel(freeCell.getHCell(i), viewInformer);
            freePanel[i] = new TopPanel(freeCell.getFCell(i), viewInformer);
        }

        for (int i=0; i<8; i++) {
            tableauPanel[i] = new BottomPanel(freeCell.getTCell(i), viewInformer);
        }

        JButton game_button = new JButton("New Game");
        label3.setText("Move(s): " + game.getMoveCount());



//starts a new game after the ongoing game ends
        game_button.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
	    int newGameButton = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new game?", "Start a new game", JOptionPane.YES_NO_OPTION);
         if (newGameButton == JOptionPane.YES_OPTION){
            game.reset();
            label3.setText("Move(s): "+game.getMoveCount());
            fromPanel = null;
	       AppView.this.repaint();
         }
               }});


        //ADD ACTION LISTENER FOR card panels here!

        //create a panel for the top row
        JPanel labelpanel = new JPanel();
        labelpanel.setLayout(new GridLayout(1, 3));
        labelpanel.add(label1);
        labelpanel.add(label2);


        //create the top row for free and home card slots
        JPanel home_panel = new JPanel();
	   home_panel.setBackground(new Color(200, 159, 217));
        home_panel.setLayout(new GridLayout(1, 8));
        for (int i=0; i<4; i++) {
            home_panel.add(freePanel[i]);
        }
        for (int i=0; i<4; i++) {
            home_panel.add(homePanel[i]);
        }

        //create the middle row for tableau card slots
        JPanel tableau_panel = new JPanel();
	   tableau_panel.setBackground(new Color(200, 159, 217));
        tableau_panel.setLayout(new GridLayout(1, 8));
        for (int i=0; i<8; i++) {
            tableau_panel.add(tableauPanel[i]);
        }

        //create a button panel for the bottom row
        JPanel buttonpanel = new JPanel();
	   buttonpanel.setBackground(Color.WHITE);
        buttonpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5,3));
        buttonpanel.add(game_button);
        buttonpanel.add(label3, -1);
        //add all of the elements to the main container

        JButton button;
	   GridBagLayout layout = new GridBagLayout();
        pane.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        //button = new JButton("Button 1");
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        pane.add(labelpanel, c);
        //
        //button = new JButton("Button 2");
        c.gridx = 0;
        c.gridy = 1;
        c.ipady = 100;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        pane.add(home_panel, c);

        c.gridx = 0;
        c.gridy = 2;
        c.ipady = 300;
        pane.add(tableau_panel, c);

        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 2;       //third row
        pane.add(buttonpanel, c);


    }

    private class AppViewInformer implements ViewInformer{
	  public void panelPressed(AbstractPanel selectedPanel){
          selectedPanel.setBackground(Color.GREEN);
          //System.out.println("panelPressed has been called");
	     if (fromPanel == null){
		  fromPanel = selectedPanel;
    	     }
    	     else if (fromPanel == selectedPanel){
      fromPanel.setBackground(new Color(200, 159, 217));
		  fromPanel = null;

    	     }
    	     else{
		  if (game.move(fromPanel.getCell(), selectedPanel.getCell())){
        label3.setText("Move(s): " + game.getMoveCount());
		    fromPanel.repaint();
		    selectedPanel.repaint();
        fromPanel.setBackground(new Color(200, 159, 217));
        selectedPanel.setBackground(new Color(200, 159, 217));
		    if (game.hasWinner()){
			 JOptionPane.showMessageDialog(null, "You Win! Select New Game button to play again", "Message", JOptionPane.INFORMATION_MESSAGE);
		    }
		    else if (game.hasLoser()){
			 JOptionPane.showMessageDialog(null, "Oops! You can no longer make any move and have lost the game. Select New Game button to start over", "Message", JOptionPane.INFORMATION_MESSAGE);
		    }
	       }
		  else{
		    JOptionPane.showMessageDialog(null, "Alert! Alert! You have made an illegal move", "Message", JOptionPane.INFORMATION_MESSAGE);
        fromPanel.setBackground(new Color(200, 159, 217));
        selectedPanel.setBackground(new Color(200, 159, 217));
		  }
          fromPanel = null;
    	     }
       //fromPanel = null;
       }
    }
}
