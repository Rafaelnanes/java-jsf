package rbn.edu.dao;

import java.util.List;

public interface IGenericDAO<T> {

    void add(T obj);

    void update(T obj);

    List<T> getAll();

    T getById(long id);

    void remove(long id);

}
