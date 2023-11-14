/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0
*/

package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import modelo.ModeloGraficoBarras;

public class VistaGraficoBarras extends JFrame {

    JFreeChart chart;
    public ImageIcon icono_volver;
    public JButton boton_volver;

    public VistaGraficoBarras() {
        super("Gráfico de Reservas por Duración de Estadía");
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        
        ModeloGraficoBarras modelo = new ModeloGraficoBarras(this);
        DefaultCategoryDataset dataset = modelo.crearGrafico();
        
        CrearGUI(dataset);

        setVisible(true);
    }
    
    public void CrearGUI(DefaultCategoryDataset dataset){
        JPanel panelContenedor = new JPanel();
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.X_AXIS));

        icono_volver = new ImageIcon(getClass().getResource("../iconos/icono-volver.png"));
        boton_volver = new JButton(icono_volver);
        boton_volver.setBackground(Color.white);
        boton_volver.setBounds(20, 520, 30, 30);
        add(boton_volver);
        
        chart = ChartFactory.createBarChart(
        "Cantidad de Reservas por Duración de Estadía",
        "Duración de Estadía (Días)",
        "Cantidad de Reservas",
        dataset,
        PlotOrientation.VERTICAL,
        true,
        true,
        false
        );

        ChartPanel panel = new ChartPanel(chart, false);
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(800, 520));
        panelContenedor.add(panel);

        add(panelContenedor);
    }
}