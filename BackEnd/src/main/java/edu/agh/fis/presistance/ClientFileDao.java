package edu.agh.fis.presistance;

import edu.agh.fis.entity.client.file.ClientFile;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wemstar on 06.09.14.
 */
@Repository
public class ClientFileDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<ClientFile> getByNo(long clientNo) {

        Criteria criteria=sessionFactory.getCurrentSession().createCriteria(ClientFile.class);
        return criteria.add(Restrictions.eq("clientNo",clientNo))
                .setResultTransformer(Transformers.aliasToBean(ClientFile.class))
                .list();

    }
}
