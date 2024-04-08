package Controller;

import Entity.ClienteEntity;
import Model.ClienteModel;
import Utils.utils;

import javax.swing.*;

import java.util.List;

import static javax.swing.JOptionPane.showInputDialog;

public class ClienteController {

    public static void create() {
        String nombre = showInputDialog("Ingresa el nombre del cliente: ");
        String apellidos = showInputDialog("Ingrese los apellidos del cliente: ");
        String email = showInputDialog("Ingrese el email: ");



        instanceModel().create(new ClienteEntity(nombre,apellidos,email));

    }

    public static void getAll(){
        String list = getAll(instanceModel().readAll());

        JOptionPane.showMessageDialog(null,list);
    }

    public static String getAll(List<Object> list){

        String ListaString = "Lista de Clientes: \n" ;
        for (Object temp: list){
            ClienteEntity objCliente = (ClienteEntity) temp;
            ListaString += objCliente.toString() + "\n";

        }
        return ListaString;
    }

    public static void delete(){
        Object[] options = utils.listToArray(instanceModel().readAll());
        ClienteEntity objSelected = (ClienteEntity) JOptionPane.showInputDialog(
                null,
                "Selecciona un Cliente",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(objSelected);
    }

    public static void  update(){
        Object[] options = utils.listToArray(instanceModel().readAll());

        ClienteEntity objSelected = (ClienteEntity) JOptionPane.showInputDialog(
                null,
                "Selecciona un cliente para actualizar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        objSelected.setNombre(JOptionPane.showInputDialog(null,"Ingresa el nuevo nombre:",objSelected.getNombre()));
        objSelected.setApellido(JOptionPane.showInputDialog(null,"Ingresa los nuevos apellidos:",objSelected.getApellido()));
        objSelected.setEmail(JOptionPane.showInputDialog(null,"Ingresa el nuevo email:",objSelected.getEmail()));

        instanceModel().update(objSelected);

    }





    public static ClienteModel instanceModel(){

        return new ClienteModel();
    }

}
