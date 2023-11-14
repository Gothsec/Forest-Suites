package vista;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloGraficoTorta;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;

public class VistaGraficoTorta extends JFrame {

    JFreeChart chart;
    public ImageIcon icono_volver;
    public JButton boton_volver;

    public VistaGraficoTorta() {
        super("Gráfico de Tipos de Habitación ocupadas");
        setSize(800, 600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        crearGrafico();

        ChartPanel panel = new ChartPanel(chart, false);
        panel.setBounds(10, 20, 760, 520);
        add(panel);

        icono_volver = new ImageIcon(getClass().getResource("../iconos/icono-volver.png"));
        boton_volver = new JButton(icono_volver);
        boton_volver.setBackground(Color.white);
        boton_volver.setBounds(20, 520, 30, 30);
        add(boton_volver);

        setVisible(true);
    }

    public void crearGrafico() {
        ModeloGraficoTorta modelo = new ModeloGraficoTorta();
        DefaultPieDataset data = modelo.getData();

        chart = ChartFactory.createPieChart(
                "Cantidad de tipos de habitación ocupadas",
                data,
                true,
                true,
                false
        );

        // Personalizacion
        chart.setBackgroundPaint(Color.LIGHT_GRAY);
        chart.getTitle().setPaint(Color.DARK_GRAY);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);

        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})",  // Formato: {0} es la clave (nombre), {1} es el valor, {2} es el porcentaje
                new java.text.DecimalFormat("0"),  // Formato del valor
                new java.text.DecimalFormat("0.00%") // Formato del porcentaje
        );
        plot.setLabelGenerator(labelGenerator);
    }

    public static void main(String[] args) {
        VistaGraficoTorta torta = new VistaGraficoTorta();
    }
}
