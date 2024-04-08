package Database;

import java.util.List;

public interface CRUD {

    //Crear
    public Object create(Object object);

    //consultar

    public List<Object> readAll();

    //modificar

    public boolean update(Object object);

    //eliminar

    public boolean delete(Object object);

}
