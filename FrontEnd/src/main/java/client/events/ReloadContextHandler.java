package client.events;

import com.google.gwt.event.shared.EventHandler;

/**
 * Created by wemstar on 14.12.14.
 */
public interface ReloadContextHandler extends EventHandler {
    void onContextReload(ReloadContext reloadContext);
}
