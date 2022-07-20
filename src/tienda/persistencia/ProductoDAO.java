
package tienda.persistencia;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import tienda.entidades.Producto;


public final class ProductoDAO extends DAO{
    
    public static void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe ingresar un producto");
            }
            
            String sql = "insert into producto (nombre, precio, codigoFabricante)"
                    + " values ('"+producto.getNombre()+"',"+producto.getPrecio()+","+producto.getCodigoFabricante()+")";
            
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            desconectarBase();
        }
    }
    
    public static ArrayList<Producto> listarProductos() throws ClassNotFoundException, SQLException {
        try {
            String sql = "SELECT nombre FROM producto";

            consultarBase(sql);

            Producto producto = null;
            ArrayList<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (ClassNotFoundException | SQLException e) {
            desconectarBase();
            throw e;
        }
    }
      // pasar a servicio despues de probar VVV
    public static void mostrarListaPorPantalla() throws Exception {
        
        try {
            ArrayList<Producto> productos = listarProductos();
            
            if (productos == null) {
                throw new Exception("No hay productos que mostrar");
            }
            
            for (Producto producto : productos) {
                System.out.println(producto.toString());
            }
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
}
