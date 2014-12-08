package client.events;

import com.google.gwt.event.shared.EventHandler;

/**
 * Created by wemstar on 08.12.14.
 */
public interface ClientContextChangeHandler extends EventHandler {

    void onClientContextChange(ClientContextChange event);
}
