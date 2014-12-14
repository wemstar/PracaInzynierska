package edu.agh.fis.core.client.file.presistance;

import edu.agh.fis.entity.client.file.ClientFile;
import edu.agh.fis.utils.presistance.AbstractDAOImpl;
import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

;

/**
 * Created by wemstar on 06.09.14.
 */
@Repository
@Transactional(readOnly = true)
class ClientFileDaoImpl extends AbstractDAOImpl<ClientFile> implements ClientFileDao {


    @Override
    public List<ClientFile> findByTemplete(ClientFile template) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ClientFile.class).setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        if (template != null) {
            if (template.getClientNo() != null && template.getClientNo() != 0)
                criteria = criteria.add(Restrictions.eq("clientNo", template.getClientNo()));
            if (template.getName() != null && template.getName().isEmpty())
                criteria = criteria.add(Restrictions.eq("name", template.getName()));
            if (template.getSurname() != null && template.getSurname().isEmpty())
                criteria = criteria.add(Restrictions.eq("surname", template.getSurname()));
            if (template.getPesel() != null && template.getPesel().isEmpty())
                criteria = criteria.add(Restrictions.eq("pesel", template.getPesel()));
        }

        return criteria.list();

    }
}
