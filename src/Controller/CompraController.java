package Controller;

import Entity.ClienteEntity;
import Entity.CompraEntity;
import Entity.ProductoEntity;
import Model.CompraModel;
import Utils.utils;

import javax.swing.*;
import java.sql.Date;
import java.util.List;

import static javax.swing.JOptionPane.showInputDialog;

public class CompraController {
    public static void create() {
        String id_Compra = showInputDialog("Ingresa el id de la compra: ");
        String fecha_compra = showInputDialog("Ingrese la fecha de la compra: YYYY-MM-dd");
        String cantidad = showInputDialog("Ingrese el stock: ");
        String id_cliente = showInputDialog("Ingrese el id de la tienda: ");
        String id_producto = showInputDialog("Ingrese el id de la tienda: ");

        Object[] optionsCliente = utils.listToArray(ClienteController.instanceModel().readAll());
        Object[] optionsProducto = utils.listToArray(ClienteController.instanceModel().readAll());

        ClienteEntity objCliente = (ClienteEntity) JOptionPane.showInputDialog(null,
                "Seleccione un cliente: ",
                "",JOptionPane.QUESTION_MESSAGE,
                null,
                optionsCliente,
                optionsCliente[0]);



        ProductoEntity objProducto = (ProductoEntity) JOptionPane.showInputDialog(null,
                "Seleccione un Producto: ",
                "",JOptionPane.QUESTION_MESSAGE,
                null,
                optionsProducto,
                optionsProducto[0]);

        instanceModel().create(new CompraEntity(id_Compra,fecha_compra,cantidad, objCliente.getId_cliente(), objCliente));

    }

    public static void getAll(){
        String ListaString = getAll(instanceModel().readAll());
        JOptionPane.showMessageDialog(null,ListaString);


    }

    public static String getAll(List<Object> list){
        String ListaString = "Lista de Compras: \n" ;
        for (Object temp: list){
            CompraEntity objCompras = (CompraEntity) temp;
            ListaString += objCompras.toString() + "\n";

        }
        return ListaString;

    }

    public static void delete(){
        Object[] options = utils.listToArray(instanceModel().readAll());
        CompraEntity objSelected = (CompraEntity) showInputDialog(
                null,
                "Selecciona una Compra",
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

        CompraEntity objSelected = (CompraEntity) showInputDialog(
                null,
                "Selecciona una compra para actualizar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        objSelected.setId_Compra(Integer.parseInt(showInputDialog(null,"Ingresa el nuevo ID de compra:",objSelected.getId_Compra())));
        objSelected.setFecha_compra(Date.valueOf(showInputDialog(null,"Ingresa la nueva fecha de compra:",objSelected.getFecha_compra())));
        objSelected.setCantidad(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa la nueva cantidad:",objSelected.getCantidad())));
        objSelected.setId_cliente(Integer.parseInt(showInputDialog(null,"Ingresa el nuevo id de Cliente:",objSelected.getId_cliente())));
        objSelected.setId_producto(Integer.parseInt(showInputDialog(null,"Ingresa el nuevo id de producto:",objSelected.getId_producto())));

        instanceModel().update(objSelected);

    }



    public static CompraModel instanceModel(){

        return new CompraModel();
    }

}

