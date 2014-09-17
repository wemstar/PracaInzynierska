package client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.core.client.GWT;

/**
 * Created by wemstar on 17.09.14.
 */
@RemoteServiceRelativePath("MainServerSide")
public interface MainServerSide extends RemoteService {
    /**
     * Utility/Convenience class.
     * Use MainServerSide.App.getInstance() to access static instance of MainServerSideAsync
     */
    public static class App {
        private static final MainServerSideAsync ourInstance = (MainServerSideAsync) GWT.create(MainServerSide.class);

        public static MainServerSideAsync getInstance() {
            return ourInstance;
        }
    }
}
