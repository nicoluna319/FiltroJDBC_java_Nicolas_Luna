import Controller.ClienteController;
import Controller.CompraController;
import Controller.ProductoController;
import Controller.TiendaController;
import Database.ConfigDB;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ConfigDB.openConnection();

        int option = 0, option2 = 0;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                    1.Administrar Tiendas
                    2.Administrar Clientes
                    3.Administrar Productos
                    4.Administrar Compras
                    5.Salir

                    Ingrese una opcion:
                    """));
            switch (option) {
                case 1: do {
                    option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1.Listar Tiendas
                                5.Salir

                                Ingrese una opcion:
                                """));

                    switch (option2) {

                        case 1:
                            TiendaController.getAll();
                            break;

                    }


                } while (option2 != 5);
                    break;

                case 2:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1.Listar Clientes
                                2.crear un Cliente
                                3.Eliminar un Cliente
                                4.Actualizar un Cliente
                                5.Salir

                                Ingrese una opcion:
                                """));

                        switch (option2) {

                            case 1:
                                ClienteController.getAll();
                                break;
                            case 2:
                                ClienteController.create();
                                break;
                            case 3:
                                ClienteController.delete();
                                break;
                            case 4:
                                ClienteController.update();
                                break;
                        }


                    } while (option2 != 5);
                    break;
                case 3:do {
                    option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1.Listar Productos
                                2.crear un Producto
                                3.Eliminar un Producto
                                4.Actualizar un Producto
                                5.Listar ID de Tiendas
                                6.Salir

                                Ingrese una opcion:
                                """));

                    switch (option2) {

                        case 1:
                            ProductoController.getAll();
                            break;
                        case 2:
                            ProductoController.create();
                            break;
                        case 3:
                            ProductoController.delete();
                            break;
                        case 4:
                            ProductoController.update();
                            break;
                        case 5:
                            TiendaController.getAll();
                            break;
                    }


                } while (option2 != 5);
                    break;
                case 4:do {
                    option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1.Listar Compras
                                2.crear una Compra
                                3.Eliminar una Compra
                                4.Actualizar Compras
                                5..Salir

                                Ingrese una opcion:
                                """));

                    switch (option2) {

                        case 1:
                            CompraController.getAll();
                            break;
                        case 2:
                            CompraController.create();
                            break;
                        case 3:
                            CompraController.delete();
                            break;
                        case 4:
                            CompraController.update();
                            break;
                    }


                } while (option2 != 5);

                    break;
            }
        } while (option != 5);
    }
}