package services.interfaces;

import java.util.List;

public interface Servicio<T, K> {


    void add(T t);

    void update(T t);

    void delete(T t);

    List<T> findAll();
    T findById(K id);
}
