package client.events;

import client.file.search.service.SearchClientDTO;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by wemstar on 08.12.14.
 */
public class ClientContextChange extends GwtEvent<ClientContextChangeHandler> {

    public static Type<ClientContextChangeHandler> TYPE = new Type<ClientContextChangeHandler>();
    private SearchClientDTO clientDetails;

    public ClientContextChange(SearchClientDTO clientDetails) {
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

    public SearchClientDTO getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(SearchClientDTO clientDetails) {
        this.clientDetails = clientDetails;
    }
}
