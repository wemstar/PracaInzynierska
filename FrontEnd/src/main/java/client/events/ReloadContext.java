package client.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by wemstar on 14.12.14.
 */
public class ReloadContext extends GwtEvent<ReloadContextHandler> {

    public static Type<ReloadContextHandler> TYPE = new Type<ReloadContextHandler>();

    @Override
    public Type<ReloadContextHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ReloadContextHandler handler) {
        handler.onContextReload(this);
    }
}
