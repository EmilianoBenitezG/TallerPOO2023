package vista;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        String columnName = table.getColumnName(column);

        // Verifica si la columna actual es "Color Sugerido" o "Color Final."
        if ("Color Sugerido".equals(columnName) || "Color Final".equals(columnName)) {
            if (value != null) {
                String color = value.toString();

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
                    case "Azul":
                        setBackground(new Color(60, 60, 186)); // Color azul claro (RGB)
                        break;
                    default:
                        setBackground(table.getBackground());
                }
            } else {
                // Si el valor es nulo, usa el color de fondo predeterminado.
                setBackground(table.getBackground());
            }
        } else {
            // Si no es una de las columnas especificadas, usa el color de fondo predeterminado.
            setBackground(table.getBackground());
        }

        return this;
    }
}
