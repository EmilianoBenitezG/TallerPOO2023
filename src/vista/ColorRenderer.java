package vista;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ColorRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Llamada al renderer padre para que haga su trabajo.
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Obtén el modelo de la tabla para acceder a los datos.
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Obtén el valor de la celda correspondiente al color.
        String color = model.getValueAt(row, 1).toString();

        // Asigna el color de fondo según el valor.
        switch (color) {
            case "Rojo":
                setBackground(Color.RED);
                break;
            case "Naranja":
                setBackground(Color.ORANGE);
                break;
            case "Amarillo":
                setBackground(Color.YELLOW);
                break;
            case "Verde":
                setBackground(Color.GREEN);
                break;
            default:
                setBackground(table.getBackground());
        }

        return this;
    }
}
