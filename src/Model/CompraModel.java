package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.ClienteEntity;
import Entity.CompraEntity;
import Entity.ProductoEntity;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraModel implements CRUD {

    @Override
    public Object create(Object object) {

        Connection objConnection = ConfigDB.openConnection();

        CompraEntity objCompra = (CompraEntity) object;

        try {

            String sql = "INSERT INTO compra(id, fecha_compra, cantidad,id_cliente, id_producto) VALUES(?,?,?,?,?);";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setInt(1,objCompra.getId_Compra());

            objPrepare.setDate(2, Date.valueOf(objCompra.getFecha_compra()));

            objPrepare.setInt(3,objCompra.getCantidad());
            objPrepare.setInt(4,objCompra.getId_cliente());
            objPrepare.setInt(5,objCompra.getId_producto());

            objPrepare.execute();


            ResultSet objResult = objPrepare.getGeneratedKeys();

            while(objResult.next()){

                objCompra.setId_Compra(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "La compra fue agregada correctamente");

        }catch(Exception e){
            System.out.println("Error al crear la compra" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objCompra;
    }

    @Override
    public List<Object> readAll() {
        List<Object> listCompras = new ArrayList<>();

        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM compra \n" +
                    "INNER JOIN cliente ON cliente.id = compra.id_cliente \n"+
                    "INNER JOIN producto ON producto.id = compra.id_producto;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while(objResult.next()){
                CompraEntity objCompra = new CompraEntity();
                ClienteEntity objCliente = new ClienteEntity();
                ProductoEntity objProducto = new ProductoEntity();

                objCompra.setId_Compra(objResult.getInt("compra.id"));
                objCompra.setFecha_compra(objResult.getDate("compra.fecha_compra"));
                objCompra.setCantidad(objResult.getInt("compra.cantidad"));
                objCompra.setId_cliente(objResult.getInt("compra.id_cliente"));
                objCompra.setId_producto(objResult.getInt("compra.id_producto"));


                objCliente.setId_cliente(objResult.getInt("cliente.id_cliente"));
                objProducto.setId_producto(objResult.getInt("producto.id_producto"));
                objCompra.setId_cliente(objCliente.getId_cliente());
                objCompra.setId_producto(objProducto.getId_producto());
                listCompras.add (objCompra);


            }

        }catch (SQLException e){
            System.out.println("ERROR" + e.getMessage());
        }

        ConfigDB.closeConnection();

        return listCompras;
    }

    @Override
    public boolean update(Object object) {

        Connection objConnection = ConfigDB.openConnection();
        CompraEntity objCompras = (CompraEntity) object;

        boolean isUpdated = false;

        try {
            String sql = "UPDATE FROM compra SET id=?, fecha_compra=?, cantidad=?, id_cliente=?, id_producto=?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,objCompras.getId_Compra());
            objPrepare.setDate(2,Date.valueOf(objCompras.getFecha_compra()));
            objPrepare.setInt(3,objCompras.getCantidad());
            objPrepare.setInt(4,objCompras.getId_cliente());
            objPrepare.setInt(5,objCompras.getId_producto());

            int totalAfectadas = objPrepare.executeUpdate();

            if (totalAfectadas > 0){

                isUpdated = true;

                JOptionPane.showMessageDialog(null,"Compra actualizada correctamente");
            }

        }catch (SQLException e){
            System.out.println("ERROR al actualizar compra" + e.getMessage());
        }

        ConfigDB.closeConnection();

        return isUpdated;
    }

    @Override
    public boolean delete(Object object) {

        Connection objConnection = ConfigDB.openConnection();

        CompraEntity objCompras = (CompraEntity) object;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM compra WHERE id = ?;";
            PreparedStatement objprepare = objConnection.prepareStatement(sql);

            objprepare.setInt(1,objCompras.getId_Compra());

            int totalAfectadas = objprepare.executeUpdate();

            if (totalAfectadas > 0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null,"Compra Eliminada Correctamente");
            }
        }catch (SQLException e) {

            System.out.println("ERROR al eliminar con sql > " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return isDeleted;
    }
}
