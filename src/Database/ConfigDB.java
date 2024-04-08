package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    static Connection objConnection = null;

    public static  Connection openConnection(){
        try{
            /*Class.forName("com.mysql.cj.jdbc.Driver");*/
            String url = "jdbc:mysql://127.0.0.1:3306/centrocomercial";
            String user = "root";
            String password = "";

            objConnection = DriverManager.getConnection(url, user, password);
            System.out.println("Me conecté perfectamente");

        }catch (SQLException e){
            System.out.println("ERROR No se pudo establecer la conexion con la DB");
        }
        return objConnection;

    }

    public static void closeConnection(){
        try {
            if (objConnection != null) objConnection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
