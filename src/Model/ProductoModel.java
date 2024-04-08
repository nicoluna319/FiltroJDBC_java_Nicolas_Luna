package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.ProductoEntity;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoModel implements CRUD {

    @Override
    public Object create(Object object) {

        Connection objConnection = ConfigDB.openConnection();

        ProductoEntity objProducto = (ProductoEntity) object;

        try {

            String sql = "INSERT INTO producto(id, nombre, precio,id_tienda) VALUES(?,?,?,?);";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setInt(1,objProducto.getId_producto());

            objPrepare.setString(2,objProducto.getNombre_producto());

            objPrepare.setDouble(3,objProducto.getPrecio());
            objPrepare.setInt(4,objProducto.getId_tienda());

            objPrepare.execute();


            ResultSet objResult = objPrepare.getGeneratedKeys();

            while(objResult.next()){

                objProducto.setId_producto(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "El producto fue agregado correctamente");

        }catch(Exception e){
            System.out.println("Error al crear producto" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objProducto;
    }

    @Override
    public List<Object> readAll() {
        List<Object> ListProductos = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM producto;";

            PreparedStatement objprepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objprepare.executeQuery();

            while(objResult.next()){
                ProductoEntity objProducto = new ProductoEntity();

                objProducto.setId_producto(objResult.getInt("id"));
                objProducto.setNombre_producto(objResult.getString("nombre"));
                objProducto.setPrecio(objResult.getDouble("precio"));
                objProducto.setStock(objResult.getInt("stock"));
                objProducto.setId_tienda(objResult.getInt("id_tienda"));

                ListProductos.add(objProducto);
            }


        } catch (SQLException e) {
            System.out.println("ERROR readAll Producto" + e.getMessage());
        }

        ConfigDB.closeConnection();


        return ListProductos;
    }

    @Override
    public boolean update(Object object) {
        Connection objConnection = ConfigDB.openConnection();
        ProductoEntity objProducto = (ProductoEntity) object;

        boolean isUpdated = false;

        try {
            String sql = "UPDATE FROM producto SET nombre=?, precio=?, stock=?, id=?, id_tienda=?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objProducto.getNombre_producto());
            objPrepare.setDouble(2,objProducto.getPrecio());
            objPrepare.setInt(3,objProducto.getStock());
            objPrepare.setInt(4,objProducto.getId_producto());
            objPrepare.setInt(5,objProducto.getId_tienda());

            int totalAfectadas = objPrepare.executeUpdate();

            if (totalAfectadas > 0){

                isUpdated = true;

                JOptionPane.showMessageDialog(null,"Producto actualizado correctamente");
            }

        }catch (SQLException e){
            System.out.println("ERROR al actualizar producto" + e.getMessage());
        }

        ConfigDB.closeConnection();

        return isUpdated;
    }

    @Override
    public boolean delete(Object object) {
        Connection objConnection = ConfigDB.openConnection();
        ProductoEntity objProducto = (ProductoEntity) object;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM producto WHERE id = ?;";
            PreparedStatement objprepare = objConnection.prepareStatement(sql);

            objprepare.setInt(1,objProducto.getId_producto());

            int totalAfectadas = objprepare.executeUpdate();

            if (totalAfectadas > 0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null,"Producto Eliminado Correctamente");
            }
        }catch (SQLException e) {

            System.out.println("ERROR al eliminar con sql > " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return isDeleted;
    }
}
