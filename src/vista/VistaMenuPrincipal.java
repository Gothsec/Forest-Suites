package vista;

import javax.swing.JFrame;

/**
 *
 * @author garav
 */
public class VistaMenuPrincipal extends JFrame{
    public VistaMenuPrincipal () {
        super("Forest Suites");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 600);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        VistaMenuPrincipal objMenu = new VistaMenuPrincipal();
    }
}


