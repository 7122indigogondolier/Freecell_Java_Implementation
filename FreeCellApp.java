import javax.swing.JFrame;

/**
 * Generic main method template for any GUI-based application.
 * Instantiates a model and passes it to a new view.
 * @author Novak,  Jha, Thapa, Adeyanju
 * Project 7
 *
 */
public class FreeCellApp{

    public static void main(String[] args){
        final Game game = new Game();
        final JFrame view = new AppView(game);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(800, 650);
        view.setVisible(true);
    }
}
