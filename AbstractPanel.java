/**
  * This program defines the AbstractPanel class
  * Project group: Adeyanju, Jha, Novak and Thapa
  * @version 1.0
  */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Represents the GUI component for painting an image of a playing card.
 * @author lambertk
 *
 */
public abstract class AbstractPanel extends JPanel{

    protected Cell cell;
    protected ViewInformer viewInformer;

    /**
     * Constructor to display a given card's image.
     * @param c the cell to display.
     */
    public AbstractPanel(Cell cell, ViewInformer viewInformer){
        this.cell = cell;
	   this.viewInformer = viewInformer;
        this.setBackground(new Color(200, 159, 217));
        addMouseListener(new PanelListener());
    }

    /**
     * Paints the card's face image if a card is present, otherwise, paints the back side image.
     */
    public void paintComponent(Graphics g){
	super.paintComponent(g);
	setBackground(Color.BLUE);
    }

    /**
     * Gets and returns the cell
     */
    public Cell getCell(){
    	return cell;
    }

    /**
    * Informs AppView class when a mouse is clicked.
    * @param MouseEvent E
    */
    private class PanelListener extends MouseAdapter{
	  public void mousePressed(MouseEvent E){
	     viewInformer.panelPressed(AbstractPanel.this);
	  }
   }

}
