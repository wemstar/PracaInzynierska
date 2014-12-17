package edu.agh.fis.core.instrument.order.presistance;

import edu.agh.fis.entity.instrument.order.NewOrder;
import edu.agh.fis.utils.presistance.AbstractDAOImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by wemstar on 29.09.14.
 */
@Repository
class SimpleOrderDAOImpl extends AbstractDAOImpl<NewOrder> implements SimpleOrderDAO {
}
