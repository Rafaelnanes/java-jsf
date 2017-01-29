package rbn.edu.service;

import java.io.Serializable;
import java.util.List;

import rbn.edu.exceptions.BusinessException;

public interface IGenericService<T> extends Serializable {

    void add(T t) throws BusinessException;

    void update(T t) throws BusinessException;

    List<T> getAll();

    T getById(long id);

    void remove(long id) throws BusinessException;

}
