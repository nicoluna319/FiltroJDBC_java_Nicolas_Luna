package Entity;

public class ProductoEntity {

    private int id_producto;
    private String nombre_producto;
    private Double precio;
    private int stock;

    private int id_tienda;

    public ProductoEntity() {
    }

    public ProductoEntity(int id_producto, String nombre_producto, Double precio, int stock, int id_tienda) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.stock = stock;
        this.id_tienda = id_tienda;
    }

    public ProductoEntity(String nombre, String precio, String stock, String idTienda) {

    }

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ProductoEntity{" +
                "id_producto=" + id_producto +
                ", nombre_producto='" + nombre_producto + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", id_tienda=" + id_tienda +
                '}';
    }
}
