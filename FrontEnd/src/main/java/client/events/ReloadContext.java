package client.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * event zgłaszający konieczność przeładowania kontekstu
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
