package edu.agh.fis.core.fix;

import edu.agh.fis.entity.instrument.order.NewOrder;

/**
 * Created by wemstar on 26.12.14.
 */
public interface SendMessage {
    void sendMessage(NewOrder order);
}
