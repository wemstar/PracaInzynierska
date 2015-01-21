package edu.agh.fis.core.fix;

import edu.agh.fis.entity.instrument.order.NewOrder;

/**
 * Klasa tworzy wiadomości FIX dla zlecenia
 */
public interface SendMessage {

    /**
     * Tworzy wiadomości FIX
     *
     * @param order zlecenie
     */
    void sendMessage(NewOrder order);
}
