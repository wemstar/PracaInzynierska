package client.events;

import client.bra.account.service.BraAccountDTO;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by wemstar on 08.12.14.
 */
public class BraAccountEvent extends GwtEvent<BraAccountContextChangeHandler> {

    public static Type<BraAccountContextChangeHandler> TYPE = new Type<BraAccountContextChangeHandler>();
    private final BraAccountDTO braAccount;

    public BraAccountEvent(BraAccountDTO item) {
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
