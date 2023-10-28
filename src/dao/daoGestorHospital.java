package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import conexion.Conexion;
import modelo.Asignacion;
import modelo.Medico;
import modelo.Paciente;

//Clase daoGestorHospital que maneja la comunicacion con la base de datos para informes del hospital
public class daoGestorHospital {
	
	private Conexion cx;

	// Constructor que inicializa la conexion a la base de datos
    public daoGestorHospital() {
        cx = new Conexion();
    }
	
    // Metodos para generar informes

    // Metodo para obtener la cantidad de pacientes atendidos en un rango de fechas por un medico
	public ArrayList<String> cantPacFechas(int ID) {
		 ArrayList<String> cantidad = null;
		return cantidad;
	}
	
	// Metodo para obtener la cantidad de pacientes atendidos en un rango de fechas por un medico y agregarlos a un modelo de tabla
	public DefaultTableModel cantPacFechas(DefaultTableModel modelo, String fechaDesde, String fechaHasta, String medico) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Object resultado[]= new Object[2];
			ps=cx.conectar().prepareStatement("SELECT matricula_medico, COUNT(DISTINCT dni_paciente) AS cantidad_pacientes_atendidos "
					+ "FROM Asignacion a inner join Medicos m on a.matricula_medico = m.matricula WHERE matricula_medico = ? "
					+ " AND fecha BETWEEN ? AND ? GROUP BY matricula_medico ORDER BY cantidad_pacientes_atendidos DESC");
			ps.setString(1, medico);
			ps.setString(2, fechaDesde);
			ps.setString(3, fechaHasta);
			rs=ps.executeQuery();
			while(rs.next()) {
				if (rs.getString("matricula_medico") != null && rs.getString("cantidad_pacientes_atendidos") != null) {
					resultado[0]=rs.getString("matricula_medico");
					resultado[1]=rs.getString("cantidad_pacientes_atendidos");
				}else {
					resultado[0]="no hay registros";
					resultado[1]="0";
				}
					modelo.addRow(resultado);
			} 
			
		} catch (SQLException e) {
		
		// Manejo de excepciones
		}
		return modelo;
	}

	// Metodo para obtener estadisticas de pacientes menores y mayores de 18 años atendidos en un rango de fechas
	public DefaultTableModel cantPacFechasEdades(DefaultTableModel modelo, String fechaDesde, String fechaHasta) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Object resultado[]= new Object[2];
			ps=cx.conectar().prepareStatement("SELECT SUM(CASE WHEN edad < 18 THEN 1 ELSE 0 END) AS menores_de_18, "
					+ "SUM(CASE WHEN edad >= 18 THEN 1 ELSE 0 END) AS mayores_de_18 "
					+ "FROM Asignacion a INNER JOIN Pacientes p ON a.dni_paciente = p.DNI WHERE fecha BETWEEN ? AND ?");
			ps.setString(1, fechaDesde);
			ps.setString(2, fechaHasta);
			rs=ps.executeQuery();
			while(rs.next()) {
				if (rs.getString("menores_de_18") != null && rs.getString("mayores_de_18") != null) {
					resultado[0]=rs.getString("menores_de_18");
					resultado[1]=rs.getString("mayores_de_18");
				}else {
					resultado[0]="0";
					resultado[1]="0";
				}
					modelo.addRow(resultado);
			} 
			
		} catch (SQLException e) {
		
		// Manejo de excepciones
		}
		return modelo;
	}
	
	public DefaultTableModel medicoAtendioPacFechas(DefaultTableModel modelo, String fechaDesde, String fechaHasta) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Object resultado[]= new Object[2];
			ps=cx.conectar().prepareStatement("SELECT NombreApellido, COUNT(*) as cantidad_consultas FROM Admision "
					+ "WHERE Fecha BETWEEN ? AND ? GROUP BY NombreApellido Order by cantidad_consultas desc");
			ps.setString(1, fechaDesde);
			ps.setString(2, fechaHasta);
			rs=ps.executeQuery();
			while(rs.next()) {
				if (rs.getString("NombreApellido") != null && rs.getString("cantidad_consultas") != null) {
					resultado[0]=rs.getString("NombreApellido");
					resultado[1]=rs.getString("cantidad_consultas");
				}
					modelo.addRow(resultado);
			} 
			if (resultado[0]==null && resultado[1]==null) {
				resultado[0]="no hay pacientes";
				resultado[1]="0";
				modelo.addRow(resultado);
			}
			
		} catch (SQLException e) {
			
		}
		return modelo;
	}
	
	public DefaultTableModel consultaPacFechas(DefaultTableModel modelo, String fechaDesde, String fechaHasta) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Object resultado[]= new Object[2];
			ps=cx.conectar().prepareStatement("SELECT apellido || ' ' || nombre AS NombreApellido, COUNT(DISTINCT dni_paciente) as cantidad_pacientes_atendidos "
					+ "FROM Asignacion a inner join Medicos m on a.matricula_medico = m.matricula inner join Funcionarios f on m.funcionario_id = f.id "
					+ "WHERE fecha BETWEEN ? AND ? GROUP BY apellido,nombre order by cantidad_pacientes_atendidos DESC");
			ps.setString(1, fechaDesde);
			ps.setString(2, fechaHasta);
			rs=ps.executeQuery();
			while(rs.next()) {
				if (rs.getString("NombreApellido") != null && rs.getString("cantidad_pacientes_atendidos") != null) {
					resultado[0]=rs.getString("NombreApellido");
					resultado[1]=rs.getString("cantidad_pacientes_atendidos");
				}
					modelo.addRow(resultado);
			} 
			if (resultado[0]==null && resultado[1]==null) {
				resultado[0]="no hay medicos";
				resultado[1]="0";
				modelo.addRow(resultado);
			}
			
		} catch (SQLException e) {
			
		}
		return modelo;
	}
	
	public DefaultTableModel triageFechasConColores(DefaultTableModel modelo, String fechaDesde, String fechaHasta) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Object resultado[]= new Object[2];
			ps=cx.conectar().prepareStatement("SELECT CASE WHEN color_final IS NOT NULL AND TRIM(color_final) <> '' THEN color_final "
					+ "ELSE resultado_triage END AS color, COUNT(*) as cantidad FROM Triage WHERE fecha_triage BETWEEN ? AND ? "
					+ "GROUP BY resultado_triage ORDER BY cantidad DESC");
			ps.setString(1, fechaDesde);
			ps.setString(2, fechaHasta);
			rs=ps.executeQuery();
			while(rs.next()) {
				if (rs.getString("color") != null && rs.getString("cantidad") != null) {
					resultado[0]=rs.getString("color");
					resultado[1]=rs.getString("cantidad");
				}
					modelo.addRow(resultado);
			} 
			if (resultado[0]==null && resultado[1]==null) {
				resultado[0]="no hay triage";
				resultado[1]="0";
				modelo.addRow(resultado);
			}
			
		} catch (SQLException e) {
			
		}
		return modelo;
	}
	
	public DefaultTableModel cantTriageConColorPropSistColorAsignadoFunc(DefaultTableModel modelo) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Object resultado[]= new Object[4];
			ps=cx.conectar().prepareStatement("SELECT triador, resultado_triage, color_final, COUNT(*) AS cantidad_cambios FROM Triage "
					+ "WHERE resultado_triage IS NOT NULL AND color_final IS NOT NULL GROUP BY triador, resultado_triage, color_final");
			rs=ps.executeQuery();
			while(rs.next()) {
				if (rs.getString("triador") != null && rs.getString("resultado_triage") != null && rs.getString("color_final") != null && rs.getString("cantidad_cambios") != null) {
					resultado[0]=rs.getString("triador");
					resultado[1]=rs.getString("resultado_triage");
					resultado[2]=rs.getString("color_final");
					resultado[3]=rs.getString("cantidad_cambios");
				}
					modelo.addRow(resultado);
			} 
			if (resultado[0]==null && resultado[1]==null && resultado[2]==null && resultado[3]==null) {
				resultado[0]="no hay triador";
				resultado[1]="no hay color";
				resultado[0]="no hay color";
				resultado[1]="0";
				modelo.addRow(resultado);
			}
			
		} catch (SQLException e) {
			
		}
		return modelo;
	}
	

}
