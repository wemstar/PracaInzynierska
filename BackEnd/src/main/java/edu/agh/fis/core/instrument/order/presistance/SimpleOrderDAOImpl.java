package edu.agh.fis.core.instrument.order.presistance;

import edu.agh.fis.entity.instrument.order.SimpleOrder;
import edu.agh.fis.utils.presistance.AbstractDAOImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by wemstar on 29.09.14.
 */
@Repository
public class SimpleOrderDAOImpl extends AbstractDAOImpl<SimpleOrder> implements SimpleOrderDAO {
}
