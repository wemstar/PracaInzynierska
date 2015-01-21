package edu.agh.fis.core.trader;

import edu.agh.fis.entity.instrument.order.NewOrder;

/**
 * Validuje zlecenie
 */
public interface AccountValidator {

    /**
     * Waliduje zlecenie
     *
     * @param newOrder zlecenie
     * @return TRUE jeśli zlecenie może przejśc dalej
     */
    boolean validateAccount(NewOrder newOrder);
}
