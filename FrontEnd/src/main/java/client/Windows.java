package client;

import client.file.search.details.ClientFileDetails;
import client.file.search.grid.SearchResult;
import client.file.search.parameters.SearchClient;
import client.instrument.list.InstrumentList;
import client.instrument.order.NewOrder;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;

/**
 * Created by wemstar on 18.11.14.
 */
public class Windows {

    private static ClientFileDetails instance;
    private static NewOrder newOrderPanel;
    private static InstrumentList instrumentList;

    public static ClientFileDetails aClientFileDetailsPanel()
    {
        if(instance==null)instance= new ClientFileDetails();
        return instance;
    }

    public static HorizontalLayoutContainer aSearchPanel()
    {
        HorizontalLayoutContainer con = new HorizontalLayoutContainer();
        SearchResult result = new SearchResult();
        con.add(new SearchClient().setResult(result), new HorizontalLayoutContainer.HorizontalLayoutData(0.5, 1));
        con.add(result, new HorizontalLayoutContainer.HorizontalLayoutData(0.5, 1));
        return con;
    }

    public static NewOrder aNewOrderPanle() {

        if (newOrderPanel == null) newOrderPanel = new NewOrder();
        return newOrderPanel;
    }

    public static Widget aInstrumentListPanle() {
        if (instrumentList == null) instrumentList = new InstrumentList();
        return instrumentList;
    }
}
