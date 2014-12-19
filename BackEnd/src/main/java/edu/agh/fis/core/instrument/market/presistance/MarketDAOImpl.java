package edu.agh.fis.core.instrument.market.presistance;

import edu.agh.fis.entity.instrument.details.Markets;
import edu.agh.fis.utils.presistance.AbstractDAOImpl;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wemstar on 15.12.14.
 */
@Repository
public class MarketDAOImpl extends AbstractDAOImpl<Markets> implements MarketDAO {
    @Override
    public List<Markets> getActiveMarkets() {

        return sessionFactory.getCurrentSession()
                .createCriteria(Markets.class).add(Restrictions.eq("active", true))
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .list();

    }

    @Override
    public Markets find(String market) {
        return (Markets) sessionFactory.getCurrentSession()
                .get(Markets.class, market);
    }
}
