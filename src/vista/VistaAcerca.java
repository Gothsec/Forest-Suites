package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaAcerca extends JFrame {
    
    public JLabel label_titulo, label_alejo, label_oscar, label_camilo,
                  label_email_alejo, label_email_oscar, label_email_camilo,
                  label_icono_alejo, label_icono_oscar, label_icono_camilo,
                  label_codigo_alejo, label_codigo_oscar, label_codigo_camilo;
    public JButton boton_volver;
    public ImageIcon icono_volver, icono_alejo, icono_oscar, icono_camilo;
    public JPanel panel_alejo, panel_oscar, panel_camilo, subpanel_alejo, subpanel_oscar, subpanel_camilo,
                  espacio_en_blanco_alejo, espacio_en_blanco_oscar, espacio_en_blanco_camilo;
                  
    
    public VistaAcerca () {
        super("Forest Suites");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        crearGUI();
        
        setVisible(true);
    }
    
    public void crearGUI() {
        
        // LABELS
        
        label_titulo = new JLabel("Acerca");
        label_titulo.setBounds(170, 30, 200, 40);
        label_titulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(label_titulo);
        
        
        // Panel Alejo
        
        // Contenedor principal, ordenada los elementos verticalmente
        
        panel_alejo = new JPanel();
        panel_alejo.setLayout(new BoxLayout(panel_alejo, BoxLayout.X_AXIS));
        //panel_alejo.setBackground(Color.red);
        panel_alejo.setBounds(50, 100, 340, 100);
        
        // Subpanel que sirve para agrupar la informacion y ordenarla verticalmente
        
        subpanel_alejo = new JPanel();
        subpanel_alejo.setLayout(new BoxLayout(subpanel_alejo, BoxLayout.Y_AXIS));
        subpanel_alejo.setSize(180, 50);
        //subpanel_alejo.setBackground(Color.BLUE);
        
        // Se añade este panel para que ocupe un espacio entre el icono y los datos
        
        espacio_en_blanco_alejo = new JPanel();
        espacio_en_blanco_alejo.setSize(10, 70);
        // espacio_en_blanco.setBackground(Color.red);
        
        icono_alejo = new ImageIcon(getClass().getResource("../iconos/icono-alejo.png"));
        label_icono_alejo = new JLabel(icono_alejo);
        
        label_alejo = new JLabel("Alejandro Cuenca");
        label_alejo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        label_codigo_alejo = new JLabel("22644?? - 2724");
        label_codigo_alejo.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        label_email_alejo = new JLabel("emmanuel.cuenca@correounivalle.edu.co");
        label_email_alejo.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        panel_alejo.add(label_icono_alejo);
        panel_alejo.add(espacio_en_blanco_alejo);
        
        subpanel_alejo.add(label_alejo);
        subpanel_alejo.add(label_codigo_alejo);
        subpanel_alejo.add(label_email_alejo);
        
        panel_alejo.add(subpanel_alejo);
        
        add(panel_alejo);
        
        // -----------------------------------------------------------------------------------------------
        
        
        // Panel Oscar
        
        // Contenedor principal, ordenada los elementos verticalmente
        
        panel_oscar = new JPanel();
        panel_oscar.setLayout(new BoxLayout(panel_oscar, BoxLayout.X_AXIS));
        panel_oscar.setBounds(50, 200, 340, 100);
        
        // Subpanel que sirve para agrupar la informacion y ordenarla verticalmente
        
        subpanel_oscar = new JPanel();
        subpanel_oscar.setLayout(new BoxLayout(subpanel_oscar, BoxLayout.Y_AXIS));
        subpanel_oscar.setSize(180, 50);
       
        // Se añade este panel para que ocupe un espacio entre el icono y los datos
        
        espacio_en_blanco_oscar = new JPanel();
        espacio_en_blanco_oscar.setSize(10, 70);
        
        icono_oscar = new ImageIcon(getClass().getResource("../iconos/icono-oscar.png"));
        label_icono_oscar = new JLabel(icono_oscar);
        
        label_oscar = new JLabel("Oscar Hernandez");
        label_oscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        label_codigo_oscar = new JLabel("2264488 - 2724");
        label_codigo_oscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        label_email_oscar = new JLabel("oscar.hernandez@correounivalle.edu.co");
        label_email_oscar.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        panel_oscar.add(label_icono_oscar);
        panel_oscar.add(espacio_en_blanco_oscar);
        
        subpanel_oscar.add(label_oscar);
        subpanel_oscar.add(label_codigo_oscar);
        subpanel_oscar.add(label_email_oscar);
        
        panel_oscar.add(subpanel_oscar);
        
        add(panel_oscar);
        
        // -----------------------------------------------------------------------------------------------
        
        
        // Panel Camilo
        
        // Contenedor principal, ordenada los elementos verticalmente
        
        panel_camilo = new JPanel();
        panel_camilo.setLayout(new BoxLayout(panel_camilo, BoxLayout.X_AXIS));
        panel_camilo.setBounds(50, 300, 340, 100);
        
        // Subpanel que sirve para agrupar la informacion y ordenarla verticalmente
        
        subpanel_camilo = new JPanel();
        subpanel_camilo.setLayout(new BoxLayout(subpanel_camilo, BoxLayout.Y_AXIS));
        subpanel_camilo.setSize(180, 50);
       
        // Se añade este panel para que ocupe un espacio entre el icono y los datos
        
        espacio_en_blanco_camilo = new JPanel();
        espacio_en_blanco_camilo.setSize(10, 70);
        
        icono_camilo = new ImageIcon(getClass().getResource("../iconos/icono-camilo.png"));
        label_icono_camilo = new JLabel(icono_camilo);
        
        label_camilo = new JLabel("Camilo Garcia");
        label_camilo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        label_codigo_camilo = new JLabel("2264484 - 2724");
        label_codigo_camilo.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        label_email_camilo = new JLabel("camilo.avendano@correounivalle.edu.co");
        label_email_camilo.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        panel_camilo.add(label_icono_camilo);
        panel_camilo.add(espacio_en_blanco_camilo);
        
        subpanel_camilo.add(label_camilo);
        subpanel_camilo.add(label_codigo_camilo);
        subpanel_camilo.add(label_email_camilo);
        
        panel_camilo.add(subpanel_camilo);
        
        add(panel_camilo);
        
        
        // botón volver
        
        icono_volver = new ImageIcon(getClass().getResource("../iconos/icono-volver.png"));
        boton_volver = new JButton(icono_volver);
        boton_volver.setBackground(Color.white);
        boton_volver.setBounds(40, 35, 30, 30);
        add(boton_volver);
    }
    
}
