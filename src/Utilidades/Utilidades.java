package Utilidades;

import javax.swing.JOptionPane;

public class Utilidades {
    
    public Utilidades () {
        
    }
    
    // Metodo para reutilizar una ventana emergente y simplificar el codigo
    
    public void ventanaEmergente (String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}