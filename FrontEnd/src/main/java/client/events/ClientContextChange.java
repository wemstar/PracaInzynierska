package client.events;

import client.file.search.service.ClientFileDTO;
import com.google.gwt.event.shared.GwtEvent;

/**
 * event zmiany kontekstu klienta
 */
public class ClientContextChange extends GwtEvent<ClientContextChangeHandler> {

    public static Type<ClientContextChangeHandler> TYPE = new Type<ClientContextChangeHandler>();
    private ClientFileDTO clientDetails;

    public ClientContextChange(ClientFileDTO clientDetails) {
        this.clientDetails = clientDetails;
    }

    @Override
    public Type<ClientContextChangeHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ClientContextChangeHandler handler) {
        handler.onClientContextChange(this);

    }

    public ClientFileDTO getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(ClientFileDTO clientDetails) {
        this.clientDetails = clientDetails;
    }
}
