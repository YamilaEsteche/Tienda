
package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class DAO {

    protected static Connection conexion = null;
    protected static Statement sentencia = null;
    protected static ResultSet resultado = null;

    private static final String USUARIO = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE = "tienda";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    protected static void conectarBase() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String url = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(url, USUARIO, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }

    protected static void desconectarBase() throws SQLException {
        try {
            if (conexion != null) {
                conexion.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (resultado != null) {
                resultado.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    protected static void insertarModificarEliminar(String sql) throws SQLException, ClassNotFoundException {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            throw ex;
        } finally {
            desconectarBase();
        }
    }

    protected static void consultarBase(String sql) throws ClassNotFoundException,SQLException {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            throw ex;
        }
    }

}
