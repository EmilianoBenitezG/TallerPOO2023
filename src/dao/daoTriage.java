package dao;

import conexion.Conexion;
import modelo.Rol;
import modelo.Triage;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class daoTriage {
    private Conexion cx;

    public daoTriage() {
        cx = new Conexion();
    }

    // Método para almacenar el resultado de triaje en la base de datos
    public boolean almacenarResultadoTriage(String nombrePaciente, String resultadoTriage, String fechaTriage, String horaTriage, String dniPaciente) {
        String sql = "INSERT INTO Triage (nombre_paciente, resultado_triage, fecha_triage , hora_triage, dni_paciente) VALUES (?,?,?,?,?)";

        try (Connection connection = cx.conectar();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nombrePaciente);
            pstmt.setString(2, resultadoTriage);
            pstmt.setString(3, fechaTriage);
            pstmt.setString(4, horaTriage);
            pstmt.setString(5, dniPaciente);
            // Ejecutar la consulta
            pstmt.executeUpdate();

            return true; // Éxito al almacenar el resultado de triaje
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Error al almacenar el resultado de triaje
        }
    }
    
    public ArrayList<Triage> ConsultaTriage(){
		ArrayList<Triage> lista = new ArrayList<Triage>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps=cx.conectar().prepareStatement("SELECT * FROM Triage");
			rs=ps.executeQuery();
			while(rs.next()) {
				String nombrePaciente = rs.getString("nombre_paciente");
				String resultadoTriage = rs.getString("resultado_triage");
				Triage triage = new Triage();
				
				triage.setId(rs.getInt("id"));
				triage.setNombre_paciente(rs.getString("nombre_paciente"));
				triage.setResultado_triage(rs.getString("resultado_triage"));
				triage.setFecha_triage(rs.getString("fecha_triage"));
				triage.setHora_triage(rs.getString("hora_triage"));
				triage.setMotivo_cambio(rs.getString("motivo_cambio"));
				triage.setColor_final(rs.getString("color_final"));
				lista.add(triage);
			}
		} catch (SQLException e) {
			
		}
		
		return lista;
		
	}
    
  
    public ArrayList<String> obtenerNombreYDNIPacientesDesdeAdmision() {
        ArrayList<String> pacientes = new ArrayList<>();
        String sql = "SELECT NombreApellido, DNI FROM Admision"; // Seleccionar NombreApellido y DNI

        try (Connection connection = cx.conectar();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet resultSet = pstmt.executeQuery()) {
            while (resultSet.next()) {
                String nombreApellido = resultSet.getString("NombreApellido");
                String dni = resultSet.getString("DNI");
                String pacienteInfo = nombreApellido + " - " + dni; // Combinar nombre y DNI en una sola cadena
                pacientes.add(pacienteInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pacientes;
    }

        public boolean actualizarMotivoCambio(String nombrePaciente, String motivoCambio) {
            String sql = "UPDATE Triage SET motivo_cambio = ? WHERE nombre_paciente = ?";

            try (Connection connection = cx.conectar();
                 PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, motivoCambio);
                pstmt.setString(2, nombrePaciente);

                // Ejecutar la consulta
                pstmt.executeUpdate();

                return true; // Éxito al actualizar el motivo de cambio
            } catch (SQLException e) {
                e.printStackTrace();
                return false; // Error al actualizar el motivo de cambio
            }
        }

        public boolean almacenarColorFinal(String nombrePaciente, String colorResultado, String fechaTriage, String horaTriage) {
            String sql = "INSERT INTO Triage (color_final, fecha_triage, hora_triage) VALUES (?, ?, ?, ?)";

            try (Connection connection = cx.conectar();
                 PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, nombrePaciente);
                pstmt.setString(2, colorResultado);
                pstmt.setString(3, fechaTriage);
                pstmt.setString(4, horaTriage);

                // Ejecutar la consulta
                pstmt.executeUpdate();

                return true; // Éxito al almacenar el resultado en la columna "color_final" de la tabla "Triage"
            } catch (SQLException e) {
                e.printStackTrace();
                return false; // Error al almacenar el resultado en la columna "color_final" de la tabla "Triage"
            }
        }

        public boolean verificarRegistroExistente(String nombrePaciente) {
            String sql = "SELECT COUNT(*) FROM Triage WHERE nombre_paciente = ?";
            
            try (Connection connection = cx.conectar();
                 PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, nombrePaciente);

                // Ejecutar la consulta y obtener el resultado
                try (ResultSet resultSet = pstmt.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0; // Si count es mayor que 0, significa que ya existe un registro
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false; // Si ocurre un error o no se encuentra el registro, retornar false
        }

        public boolean actualizarColorFinalYMotivoCambio(String nombrePaciente, String nuevoResultado, String colorSeleccionado) {
            String sql = "UPDATE Triage SET color_final = ?, motivo_cambio = ? WHERE nombre_paciente = ?";

            try (Connection connection = cx.conectar();
                 PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, colorSeleccionado);
                pstmt.setString(2, nuevoResultado);
                pstmt.setString(3, nombrePaciente);

                // Ejecutar la consulta
                int rowsUpdated = pstmt.executeUpdate();

                return rowsUpdated > 0; // Si se actualizó al menos una fila, significa éxito
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false; // Error al actualizar
        }
        public String getColorActualPaciente(String nombrePaciente) {
            String sql = "SELECT resultado_triage FROM Triage WHERE nombre_paciente = ?";

            try (Connection connection = cx.conectar();
                 PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, nombrePaciente);
                try (ResultSet resultSet = pstmt.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("resultado_triage");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null; // Devuelve null si no se encuentra el color actual
        }


  
        private int puntuacionRespiracion;
		private int puntuacionFiebre;
		private int puntuacionPulso;
		private int puntuacionDolorPecho;
		private int PuntuacionLesionesGraves;
		private int PuntuacionLesionesLeves;
		private int PuntuacionEstadoMental;
		private int PuntuacionSangrado;
		private int PuntuacionVomitos;
		private int SignosdeShock;
		private int Conciencia;

    // Métodos para establecer la puntuación de cada síntoma
    public void setPuntuacionRespiracion(int puntuacionRespiracion) {
        this.puntuacionRespiracion = puntuacionRespiracion;
    }
    
    public void setPuntuacionFiebre(int puntuacionFiebre) {
        this.puntuacionFiebre = puntuacionFiebre;
    }

    public void setPuntuacionPulso(int puntuacionPulso) {
        this.puntuacionPulso = puntuacionPulso;
    }

    public void setPuntuacionDolorPecho(int puntuacionDolorPecho) {
        this.puntuacionDolorPecho = puntuacionDolorPecho;
    }

    public void setPuntuacionLesionesGraves(int puntuacionLesionesGraves) {
    	this.PuntuacionLesionesGraves = puntuacionLesionesGraves;
    }
    
    public void setPuntuacionLesionesLeves(int puntuacionLesionesLeves) {
    	this.PuntuacionLesionesLeves = puntuacionLesionesLeves;
    }
    
    public void setPuntuacionEstadoMental(int puntuacionEstadoMental) {
    	this.PuntuacionEstadoMental = puntuacionEstadoMental;
    }
    
    public void setPuntuacionSangrado(int puntuacionSangrado) {
    	this.PuntuacionSangrado = puntuacionSangrado;
    }
    
    public void setPuntuacionVomitos(int puntuacionVomitos) {
    	this.PuntuacionVomitos = puntuacionVomitos;
    }
    
    public void setPuntuacionSignosdeShock(int puntuacionSignosdeShock) {
    	this.SignosdeShock = puntuacionSignosdeShock;
    }
    
    public void setPuntuacionConciencia(int puntuacionConciencia) {
    	this.Conciencia = puntuacionConciencia;
    }
  
}