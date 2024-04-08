package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.ClienteEntity;
import Entity.TiendaEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TiendaModel implements CRUD {

    @Override
    public Object create(Object object) {
        return null;
    }

    @Override
    public List<Object> readAll() {

        List<Object> ListTiendas = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM tienda;";

            PreparedStatement objprepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objprepare.executeQuery();

            while(objResult.next()){
                TiendaEntity objTienda = new TiendaEntity();

                objTienda.setId_tienda(objResult.getInt("id"));
                objTienda.setNombre_tienda(objResult.getString("nombre"));
                objTienda.setUbicacion(objResult.getString("ubicacion"));

                ListTiendas.add(objTienda);
            }


        } catch (SQLException e) {
            System.out.println("ERROR readAll Tienda" + e.getMessage());
        }

        ConfigDB.closeConnection();


        return ListTiendas;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }
}
