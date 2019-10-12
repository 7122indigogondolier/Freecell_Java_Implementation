import javax.swing.*;
import java.awt.*;

/**
 * Represents the GUI component for painting an image of a playing card.
 * @author lambertk
 * Project Group: Adeyanju, Jha, Novak, Thapa
 */

public class TopPanel extends AbstractPanel{

   /**
     * Constructor to display a given card's image.
     * @param c the cell to display.
     */
  public TopPanel(Cell cell, ViewInformer viewInformer){
	super(cell, viewInformer);
  }

  public void paintComponent(Graphics g){
     	Icon image;

    		image = Card.getBack();
    		g.setColor(Color.black);
    		int x = (getWidth() - image.getIconWidth()) / 2;
    		int y = (getHeight() - image.getIconHeight()) / 2;
    		g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());

      if (! (cell.isEmpty())) {
        for (Card card : cell){
            image = card.getImage();
    		x = (getWidth() - image.getIconWidth()) / 2;
            y = (getHeight() - image.getIconHeight()) / 2;
    		image.paintIcon(this, g, x, y);
       }
      }
    }

}
