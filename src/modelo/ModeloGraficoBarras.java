
package modelo;

import conexion_base.Conexion;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import vista.VistaGraficoBarras;


public class ModeloGraficoBarras {
    
    VistaGraficoBarras obj_vista;
    JFreeChart chart;
    
    public ModeloGraficoBarras(VistaGraficoBarras obj_vista) {
        this.obj_vista = obj_vista;
    }
    
    public DefaultCategoryDataset crearGrafico() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    Conexion objConexion = new Conexion();
    boolean errorConexion = objConexion.conectarMySQL("forest_suites_db", "root", "", "127.0.0.1");

    if (!errorConexion) {
        try {
            System.out.println("Gráfico creado correctamente.");
            String[][] datos = objConexion.consultaMatrizAll("cliente");

            // Inicializar contadores para cada duración de estadía
            int unoATresDias = 0;
            int cuatroASieteDias = 0;
            int masDeSieteDias = 0;

            for (String[] fila : datos) {
                String checkin = fila[4].trim();
                String checkout = fila[5].trim();

                // Calcular la duración de estadía en días
                int duracion = calcularDuracionEstadia(checkin, checkout);

                // Incrementar el contador correspondiente
                if (duracion >= 1 && duracion <= 3) {
                    unoATresDias++;
                } else if (duracion >= 4 && duracion <= 7) {
                    cuatroASieteDias++;
                } else {
                    masDeSieteDias++;
                }
            }

            dataset.addValue(unoATresDias, "Cantidad de Reservas", "1-3 Días");
            dataset.addValue(cuatroASieteDias, "Cantidad de Reservas", "4-7 Días");
            dataset.addValue(masDeSieteDias, "Cantidad de Reservas", "Más de 7 Días");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al interactuar con la base de datos");
            e.printStackTrace();
        } finally {
            objConexion.desconectar();
        }
    }
    return dataset;
}
    
        private int calcularDuracionEstadia(String checkin, String checkout) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            java.util.Date fechaCheckin = dateFormat.parse(checkin);
            java.util.Date fechaCheckout = dateFormat.parse(checkout);
            long diferenciaMillis = fechaCheckout.getTime() - fechaCheckin.getTime();
            int diferenciaDias = (int) (diferenciaMillis / (1000 * 60 * 60 * 24));
            return diferenciaDias;
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }
        
}
