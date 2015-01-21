package edu.agh.fis.utils.presistance;

/**
 * Abstrakcyjna interfejs spełniający CRUD
 */
public interface AbstractDAO<T> {

    T create(T t);

    void delete(final long id);

    T find(final long id);

    void update(final T t);
}
