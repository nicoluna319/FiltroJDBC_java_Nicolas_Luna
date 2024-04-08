package Entity;

public class TiendaEntity {

    private int id_tienda;
    private String nombre_tienda;
    private String ubicacion;

    public TiendaEntity() {
    }

    public TiendaEntity(int id_tienda, String nombre_tienda, String ubicacion) {
        this.id_tienda = id_tienda;
        this.nombre_tienda = nombre_tienda;
        this.ubicacion = ubicacion;
    }

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public String getNombre_tienda() {
        return nombre_tienda;
    }

    public void setNombre_tienda(String nombre_tienda) {
        this.nombre_tienda = nombre_tienda;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "TiendaEntity{" +
                "id_tienda=" + id_tienda +
                ", nombre_tienda='" + nombre_tienda + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
