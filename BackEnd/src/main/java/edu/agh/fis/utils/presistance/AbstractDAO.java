package edu.agh.fis.utils.presistance;

/**
 * Created by wemstar on 29.09.14.
 */
public interface AbstractDAO<T> {

    T create(T t);

    void delete(final long id);

    T find(final long id);

    void update(final T t);
}
