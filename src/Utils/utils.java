package Utils;

import java.util.List;

public class utils {
    public static <T> T[] listToArray(List<T> list){

        //CREAR UN ARREGLO DEL OBJECT DEL TAMAÑO DE LA LISTA

        T[] array = (T[]) new Object[list.size()];

        int i=0;

        for (T iterador : list){
            array[i++]=iterador;
        }

        return array;

    }

}
