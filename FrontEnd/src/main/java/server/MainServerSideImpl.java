package server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import client.MainServerSide;

/**
 * Created by wemstar on 17.09.14.
 */
public class MainServerSideImpl extends RemoteServiceServlet implements MainServerSide {
    @Override
    public String hello() {
        return "Hura";
    }
}