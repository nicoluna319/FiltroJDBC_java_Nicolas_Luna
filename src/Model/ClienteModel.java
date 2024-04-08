package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.ClienteEntity;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteModel implements CRUD {


    @Override
    public Object create(Object object) {

        Connection objConnection = ConfigDB.openConnection();

        ClienteEntity objCliente = (ClienteEntity) object;

        try {

            String sql = "INSERT INTO cliente(nombre, apellido,email) VALUES(?,?,?);";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,objCliente.getNombre());

            objPrepare.setString(2,objCliente.getApellido());

            objPrepare.setString(3,objCliente.getEmail());

            objPrepare.execute();


            ResultSet objResult = objPrepare.getGeneratedKeys();

            while(objResult.next()){

                objCliente.setId_cliente(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "El cliente fue agregado correctamente");

        }catch(Exception e){
            System.out.println("Error al crear cliente" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objCliente;
    }

    @Override
    public List<Object> readAll() {

        List<Object> ListClientes = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM cliente;";

            PreparedStatement objprepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objprepare.executeQuery();

            while(objResult.next()){
                ClienteEntity objCliente = new ClienteEntity();

                objCliente.setId_cliente(objResult.getInt("id"));
                objCliente.setNombre(objResult.getString("nombre"));
                objCliente.setApellido(objResult.getString("apellido"));
                objCliente.setEmail(objResult.getString("email"));

                ListClientes.add(objCliente);
            }


        } catch (SQLException e) {
            System.out.println("ERROR readAll Cliente" + e.getMessage());
        }

        ConfigDB.closeConnection();


        return ListClientes;

    }

    @Override
    public boolean delete(Object object) {
        Connection objConnection = ConfigDB.openConnection();
        ClienteEntity objCliente = (ClienteEntity) object;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM cliente WHERE id = ?;";
            PreparedStatement objprepare = objConnection.prepareStatement(sql);

            objprepare.setInt(1,objCliente.getId_cliente());

            int totalAfectadas = objprepare.executeUpdate();

            if (totalAfectadas > 0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null,"Cliente Eliminado Correctamente");
            }
        }catch (SQLException e) {

            System.out.println("ERROR > " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return isDeleted;
    }
    @Override
    public boolean update(Object object) {
        Connection objConnection = ConfigDB.openConnection();
        ClienteEntity objCliente = (ClienteEntity) object;

        boolean isUpdated = false;

        try {
            String sql = "UPDATE FROM cliente SET nombre=?, apellidos=?, email=?, id=?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objCliente.getNombre());
            objPrepare.setString(2,objCliente.getApellido());
            objPrepare.setString(3,objCliente.getEmail());
            objPrepare.setInt(4,objCliente.getId_cliente());

            int totalAfectadas = objPrepare.executeUpdate();

            if (totalAfectadas > 0){

                isUpdated = true;

                JOptionPane.showMessageDialog(null,"Cliente actualizado correctamente");
            }

        }catch (SQLException e){
            System.out.println("ERROR" + e.getMessage());
        }

        ConfigDB.closeConnection();

        return isUpdated;
    }


}
