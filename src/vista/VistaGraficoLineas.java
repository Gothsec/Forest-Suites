package vista;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import modelo.ModeloGraficoLineas;

public class VistaGraficoLineas extends JFrame {

    private JFreeChart chart;
    private ModeloGraficoLineas modelo;
    public JButton boton_volver;

    public VistaGraficoLineas() {
        super("Gráfico de Líneas");
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        modelo = new ModeloGraficoLineas();
        chart = createChart(modelo.createDataset());
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 520));

        // Crear el botón de retroceso
        boton_volver = new JButton(new ImageIcon(getClass().getResource("../iconos/icono-volver.png")));
        boton_volver.setBackground(Color.white);

        JPanel panelContenedor = new JPanel();
        panelContenedor.setLayout(new BorderLayout());
        panelContenedor.add(chartPanel, BorderLayout.EAST);
        panelContenedor.add(boton_volver, BorderLayout.NORTH);

        add(panelContenedor);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createLineChart(
                "Reservas de Habitaciones por Mes",
                "Mes",
                "Cantidad",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        CategoryPlot plot = chart.getCategoryPlot();
        CategoryItemRenderer renderer = new LineAndShapeRenderer(true, true);
        plot.setRenderer(renderer);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinesVisible(true);

        return chart;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaGraficoLineas lineas = new VistaGraficoLineas();
            lineas.setVisible(true);
        });
    }
}
