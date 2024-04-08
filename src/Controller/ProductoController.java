package Controller;

import Entity.ProductoEntity;
import Model.ProductoModel;
import Utils.utils;

import javax.swing.*;
import java.util.List;

import static javax.swing.JOptionPane.showInputDialog;

public class ProductoController {


    public static void create() {
        String nombre = showInputDialog("Ingresa el nombre del producto: ");
        String precio = showInputDialog("Ingrese el precio del producto: ");
        String stock = showInputDialog("Ingrese el stock: ");
        String id_tienda = showInputDialog("Ingrese el id de la tienda: ");


        instanceModel().create(new ProductoEntity(nombre,precio,stock,id_tienda));

    }

    public static void getAll(){
        String list = getAll(instanceModel().readAll());

        JOptionPane.showMessageDialog(null,list);
    }

    public static String getAll(List<Object> list){

        String ListaString = "Lista de Productos: \n" ;
        for (Object temp: list){
            ProductoEntity objProducto = (ProductoEntity) temp;
            ListaString += objProducto.toString() + "\n";

        }
        return ListaString;
    }

    public static void delete(){
        Object[] options = utils.listToArray(instanceModel().readAll());
        ProductoEntity objSelected = (ProductoEntity) showInputDialog(
                null,
                "Selecciona un Producto",
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

        ProductoEntity objSelected = (ProductoEntity) showInputDialog(
                null,
                "Selecciona un Producto para actualizar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        objSelected.setNombre_producto(showInputDialog(null,"Ingresa el nuevo nombre:",objSelected.getNombre_producto()));
        objSelected.setPrecio(Double.valueOf(showInputDialog(null,"Ingresa El nuevo precio:",objSelected.getPrecio())));
        objSelected.setStock(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el nuevo stock:",objSelected.getStock())));
        objSelected.setId_tienda(Integer.parseInt(showInputDialog(null,"Ingresa el nuevo id de tienda:",objSelected.getId_tienda())));


        instanceModel().update(objSelected);

    }



    public static ProductoModel instanceModel(){

        return new ProductoModel();
    }
}
