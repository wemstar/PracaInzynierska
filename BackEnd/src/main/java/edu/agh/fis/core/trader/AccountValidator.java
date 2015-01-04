package edu.agh.fis.core.trader;

import edu.agh.fis.entity.instrument.order.NewOrder;

/**
 * Created by wemstar on 04.01.15.
 */
public interface AccountValidator {

    boolean validateAccount(NewOrder newOrder);
}
