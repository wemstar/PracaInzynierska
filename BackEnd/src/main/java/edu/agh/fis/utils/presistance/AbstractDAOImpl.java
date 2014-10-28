package edu.agh.fis.utils.presistance;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by wemstar on 29.09.14.
 */
@Transactional
public abstract class AbstractDAOImpl<T> implements AbstractDAO<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T> type;

    public AbstractDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public T create(final T t) {
        this.sessionFactory.getCurrentSession().persist(t);
        return t;
    }

    @Override
    public void delete(final long id) {
        sessionFactory.getCurrentSession().delete(find(id));
    }

    @Override
    public T find(final long id) {
        return (T) sessionFactory.getCurrentSession().get(type, id);
    }

    @Override
    public void update(final T t) {
        sessionFactory.getCurrentSession().update(t);
    }

}
