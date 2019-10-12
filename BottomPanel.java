
/**
 * Represents the GUI component for painting an image of a playing card.
 * @author lambertk
 * Project Group: Adeyanju, Jha, Novak and Thapa
 */

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends AbstractPanel{

   /**
     * Constructor to display a given card's image.
     * @param c the cell to display.
     */
  public BottomPanel(Cell cell, ViewInformer viewInformer){
	   super(cell, viewInformer);
  }


  public void paintComponent(Graphics g){
	    int y = 0;
    	if (cell.isEmpty()){
    		Icon image = Card.getBack();
    		g.setColor(Color.yellow);
    		int x = (getWidth() - image.getIconWidth()) / 2;
    		g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
    	}
    	else{
  	   for (Card card : cell){
      		Icon image = card.getImage();
      		int x = (getWidth() - image.getIconWidth()) / 2;
      		image.paintIcon(this, g, x, y);
  		    y += 35;
	     }
     }
  }

}
