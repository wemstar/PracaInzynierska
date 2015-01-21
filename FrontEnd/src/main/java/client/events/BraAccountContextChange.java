package client.events;

import client.bra.account.service.BraAccountDTO;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Event zmiany kontekstu rachunku
 */
public class BraAccountContextChange extends GwtEvent<BraAccountContextChangeHandler> {

    public static Type<BraAccountContextChangeHandler> TYPE = new Type<BraAccountContextChangeHandler>();
    private final BraAccountDTO braAccount;

    public BraAccountContextChange(BraAccountDTO item) {
        this.braAccount = item;
    }

    public BraAccountDTO getBraAccount() {
        return braAccount;
    }

    @Override
    public Type<BraAccountContextChangeHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(BraAccountContextChangeHandler handler) {
        handler.onBraAccountContextChangeHandler(this);
    }
}
