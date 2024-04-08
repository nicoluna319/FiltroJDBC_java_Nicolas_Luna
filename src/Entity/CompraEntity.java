package Entity;

import java.sql.Date;
import java.time.LocalDate;

public class CompraEntity {

private int id_Compra;

private Date fecha_compra;

private int cantidad;

private int id_cliente;

private int id_producto;


    public CompraEntity() {
    }

    public CompraEntity(int id_Compra, Date fecha_compra, int cantidad, int id_cliente, int id_producto) {
        this.id_Compra = id_Compra;
        this.fecha_compra = fecha_compra;
        this.cantidad = cantidad;
        this.id_cliente = id_cliente;
        this.id_producto = id_producto;
    }

    public CompraEntity(String idCompra, String fechaCompra, String cantidad, int idCliente, ClienteEntity objCliente) {

    }

    public int getId_Compra() {
        return id_Compra;
    }

    public void setId_Compra(int id_Compra) {
        this.id_Compra = id_Compra;
    }

    public LocalDate getFecha_compra() {
        return fecha_compra.toLocalDate();
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    @Override
    public String toString() {
        return "CompraEntity{" +
                "id_Compra=" + id_Compra +
                ", fecha_compra=" + fecha_compra +
                ", cantidad=" + cantidad +
                ", id_cliente=" + id_cliente +
                ", id_producto=" + id_producto +
                '}';
    }


}
