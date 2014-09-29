package edu.agh.fis.core.client.file.presistance;

import edu.agh.fis.entity.client.file.ClientFile;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by wemstar on 06.09.14.
 */
@Repository
@Transactional(readOnly = true)
public class ClientFileDaoImpl implements ClientFileDao {

//    @PersistenceContext
//    private EntityManager entityManager;

    static Logger log = Logger.getLogger(ClientFileDaoImpl.class.getName());


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<ClientFile> getByNo(long clientNo) {


        Session session = sessionFactory.getCurrentSession();
        ;
        Criteria criteria = session.createCriteria(ClientFile.class);

        List list = criteria.list();

        log.info("Hura " + list);
        return list;


    }

    @Override
    public void save(ClientFile clientFile) {
        //sessionFactory.getCurrentSession().save(clientFile);
    }
}
