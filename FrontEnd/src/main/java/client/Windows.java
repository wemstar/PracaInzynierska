package client;

import client.file.search.details.ClientFileDetails;
import client.file.search.grid.SearchResult;
import client.file.search.parameters.SearchClient;
import client.file.search.service.ClientFileDTO;
import client.instrument.list.composite.InstrumentListComposite;
import client.instrument.order.NewOrder;
import client.instrument.order.list.OrderList;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;

/**
 * Created by wemstar on 18.11.14.
 */
public class Windows {

    private static ClientFileDetails instance;
    private static NewOrder newOrderPanel;
    private static ClientFileDetails newClientFileDetails;
    private static OrderList orderListPanel;
    private static InstrumentListComposite instrumentListComposite;
    private static InstrumentListComposite braAccountInstrumentListComposite;

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
        Margins margins = new Margins();
        margins.setTop(10);
        margins.setRight(10);
        con.add(result, new HorizontalLayoutContainer.HorizontalLayoutData(0.5, 1, margins));
        return con;
    }

    public static NewOrder aNewOrderPanle() {

        if (newOrderPanel == null) newOrderPanel = new NewOrder();
        return newOrderPanel;
    }

    public static OrderList aNewOrderListPanel() {
        if (orderListPanel == null) orderListPanel = new OrderList();
        return orderListPanel;
    }


    public static Widget aNewClientFilePanel() {
        if (newClientFileDetails == null) newClientFileDetails = new ClientFileDetails();
        newClientFileDetails.setClientFile(new ClientFileDTO());
        newClientFileDetails.disableWidgets(true);
        return newClientFileDetails;
    }

    public static InstrumentListComposite anInstrumentListPanel() {
        if (instrumentListComposite == null) instrumentListComposite = new InstrumentListComposite();
        return instrumentListComposite;
    }

    public static InstrumentListComposite anBraAccountInstrumentListPanel() {
        if (braAccountInstrumentListComposite == null)
            braAccountInstrumentListComposite = new InstrumentListComposite();
        return braAccountInstrumentListComposite;
    }
}
