package Controller;

import Entity.ClienteEntity;
import Entity.TiendaEntity;
import Model.ClienteModel;
import Model.TiendaModel;

import javax.swing.*;
import java.util.List;

public class TiendaController {

    public static void getAll(){
        String list = getAll(instanceModel().readAll());

        JOptionPane.showMessageDialog(null,list);
    }

    public static String getAll(List<Object> list){

        String ListaString = "Lista de Tiendas: \n" ;
        for (Object temp: list){
            TiendaEntity objTienda = (TiendaEntity) temp;
            ListaString += objTienda.toString() + "\n";

        }
        return ListaString;
    }




    public static TiendaModel instanceModel(){

        return new TiendaModel();
    }

}
