package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import modelo.Medico;
import modelo.DetallesEspecialidad;

public class daoMedico {
	private Conexion cx;

	public daoMedico() {
		cx = new Conexion();
	}

	public void cerrarConexion() {
		cx.desconectar();
	}

	// Inserta un nuevo médico en la base de datos
	public boolean insertarMedico(Medico medico, DetallesEspecialidad detallesEspecialidad) {
	    Connection connection = null;
	    PreparedStatement ps = null;
	    boolean salida = false;
	    int intentos = 3;

	    try {
	        connection = cx.conectar();
	        connection.setAutoCommit(false);

	        while (intentos > 0) {
	            try {
	                int funcionarioId = obtenerFuncionarioId(medico.getNombre(), medico.getApellido());

	                if (funcionarioId > 0) {
	                    String insertMedicoSQL = "INSERT INTO Medicos (funcionario_id, matricula) VALUES (?, ?)";
	                    ps = connection.prepareStatement(insertMedicoSQL);
	                    ps.setInt(1, funcionarioId);
	                    ps.setString(2, medico.getMatricula());
	                    ps.executeUpdate();

	                    if (detallesEspecialidad != null) {
	                        String insertDetallesEspecialidadSQL = "INSERT INTO MedicosEspecialidades (medico_id, especialidad_id, fechaObtencion, universidad) VALUES (?, ?, ?, ?)";
	                        ps = connection.prepareStatement(insertDetallesEspecialidadSQL);
	                        ps.setInt(1, obtenerMedicoIdPorFuncionarioId(funcionarioId));
	                        ps.setInt(2, obtenerEspecialidadIdPorNombre(detallesEspecialidad.getEspecialidad()));
	                        ps.setString(3, detallesEspecialidad.getFechaObtencion());
	                        ps.setString(4, detallesEspecialidad.getUniversidad());
	                        ps.executeUpdate();
	                    }

	                    connection.commit();
	                    salida = true;
	                    break;
	                } else {
	                    System.err.println("El ID de Funcionarios proporcionado no es válido.");
	                    break;
	                }
	            } catch (SQLException e) {
	                System.err.println("Error al insertar médico: " + e.getMessage());
	                intentos--;
	                try {
	                    Thread.sleep(1000);
	                } catch (InterruptedException ex) {
	                    Thread.currentThread().interrupt();
	                }
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al conectar a la base de datos: " + e.getMessage());
	    } finally {
	        try {
	            if (connection != null) {
	                connection.setAutoCommit(true);
	                connection.close();
	            }
	        } catch (SQLException e) {
	            System.err.println("Error al restablecer la conexión: " + e.getMessage());
	        }
	    }

	    return salida;
	}

	
	private int obtenerFuncionarioId(String nombre, String apellido) {
	    Connection connection = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    int funcionarioId = -1;

	    try {
	        connection = cx.conectar();
	        String selectFuncionarioIdSQL = "SELECT id FROM Funcionarios WHERE nombre = ? AND apellido = ?";
	        ps = connection.prepareStatement(selectFuncionarioIdSQL);
	        ps.setString(1, nombre);
	        ps.setString(2, apellido);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            funcionarioId = rs.getInt("id");
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al obtener el ID de Funcionarios: " + e.getMessage());
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Error al cerrar recursos: " + e.getMessage());
	        }
	    }
	    return funcionarioId;
	}
	
	private int obtenerMedicoIdPorFuncionarioId(int funcionarioId) {
	    Connection connection = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    int medicoId = -1;

	    try {
	        connection = cx.conectar();
	        String selectMedicoIdSQL = "SELECT id FROM Medicos WHERE funcionario_id = ?";
	        ps = connection.prepareStatement(selectMedicoIdSQL);
	        ps.setInt(1, funcionarioId);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            medicoId = rs.getInt("id");
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al obtener el ID de Medico por Funcionario ID: " + e.getMessage());
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Error al cerrar recursos: " + e.getMessage());
	        }
	    }
	    return medicoId;
	}
	
	// Consulta y retorna la lista de todos los médicos con detalles de especialidad
	public ArrayList<Medico> consultarMedicos() {
		ArrayList<Medico> lista = new ArrayList<Medico>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = cx.conectar().prepareStatement("SELECT Funcionarios.id AS funcionario_id, nombre, apellido, fechaNacimiento, domicilio, DNI, telFijo, telCelular, estadoCivil, email, Matricula, MedicosEspecialidades.fechaObtencion, universidad, Especialidades.nombreEspecialidad AS especialidad FROM Medicos INNER JOIN Funcionarios ON Medicos.funcionario_id = Funcionarios.id LEFT JOIN MedicosEspecialidades ON Medicos.funcionario_id = MedicosEspecialidades.medico_id LEFT JOIN Especialidades ON MedicosEspecialidades.especialidad_id = Especialidades.id");
			rs = ps.executeQuery();
			while (rs.next()) {
				Medico medico = new Medico();
				medico.setFuncionarioId(rs.getInt("funcionario_id"));
				medico.setNombre(rs.getString("nombre"));
				medico.setApellido(rs.getString("apellido"));
				medico.setFechaNacimiento(rs.getString("fechaNacimiento"));
				medico.setDomicilio(rs.getString("domicilio"));
				medico.setDNI(rs.getString("DNI"));
				medico.setTelFijo(rs.getString("telFijo"));
				medico.setTelCelular(rs.getString("telCelular"));
				medico.setEstadoCivil(rs.getString("estadoCivil"));
				medico.setEmail(rs.getString("email"));
				medico.setMatricula(rs.getString("Matricula"));
				medico.setId(rs.getInt("funcionario_id"));
				if (rs.getString("fechaObtencion") != null) {
				    DetallesEspecialidad detallesEspecialidad = new DetallesEspecialidad();
				    detallesEspecialidad.setFechaObtencion(rs.getString("fechaObtencion"));
				    detallesEspecialidad.setUniversidad(rs.getString("universidad"));
				    detallesEspecialidad.setEspecialidad(rs.getString("especialidad"));
				    medico.setDetallesEspecialidad(detallesEspecialidad);
				}
				lista.add(medico);
			}
			cx.desconectar();
		} catch (SQLException e) {
			System.err.println("Error al consultar médicos: " + e.getMessage());
		}
		return lista;
	}
	
	// Busca médicos por matrícula
    public ArrayList<Medico> buscarMedicosPorMatricula(String matricula) {
        ArrayList<Medico> medicos = new ArrayList<Medico>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = cx.conectar();

            String query = "SELECT * FROM Medicos WHERE matricula = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, matricula);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Medico medico = new Medico();
                medico.setId(resultSet.getInt("id"));
                medico.setNombre(resultSet.getString("nombre"));
                medico.setApellido(resultSet.getString("apellido"));
                medico.setMatricula(resultSet.getString("matricula"));
                medicos.add(medico);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return medicos;
    }
    
    // Obtiene el id de la tabla especialidad
    public int obtenerEspecialidadIdPorNombre(String nombreEspecialidad) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int especialidadId = -1;

        try {
            connection = cx.conectar();
            String query = "SELECT id FROM Especialidades WHERE nombreEspecialidad = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, nombreEspecialidad);
            rs = ps.executeQuery();

            if (rs.next()) {
                especialidadId = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el ID de la especialidad por nombre: " + e.getMessage());
        } finally {
        }
        return especialidadId;
    }

}