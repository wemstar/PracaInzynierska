package client.instrument.order.list;

import client.MainModule;
import client.events.ClientContextChange;
import client.events.ClientContextChangeHandler;
import client.file.search.service.ClientFileDTO;
import client.instrument.order.service.NewOrderService;
import client.instrument.order.service.dto.NewOrderDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridView;
import com.sencha.gxt.widget.core.client.info.Info;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 20.12.14.
 */
public class OrderList extends Composite {


    private static final OrderListGridProperties gridProperties = GWT.create(OrderListGridProperties.class);
    private static OrderListUiBinder ourUiBinder = GWT.create(OrderListUiBinder.class);
    @UiField(provided = true)
    public ListStore<NewOrderDTO> listStore;
    @UiField
    public GridView<NewOrderDTO> gridView;
    @UiField
    public Grid<NewOrderDTO> grid;
    @UiField(provided = true)
    public ColumnModel<NewOrderDTO> columnModel;

    public OrderList() {
        if (columnModel == null) {
            columnModel = initColumnModel();
            listStore = new ListStore<NewOrderDTO>(gridProperties.key());
            initWidget(ourUiBinder.createAndBindUi(this));
            MainModule.EVENT_BUS.addHandler(ClientContextChange.TYPE, new ClientContextChangeHandler() {
                @Override
                public void onClientContextChange(ClientContextChange event) {
                    setClientFile(event.getClientDetails());
                }
            });
        }
    }

    public void setClientFile(ClientFileDTO context) {
        NewOrderService.App.getInstance().getOrdersForClient(context.getClientNo(), new AsyncCallback<List<NewOrderDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                AlertMessageBox d = new AlertMessageBox("Błąd", "Problem podczas pobierania listy instrumentów");
                d.show();

            }

            @Override
            public void onSuccess(List<NewOrderDTO> result) {
                listStore.clear();
                listStore.addAll(result);
                Info.display("Pobieranie Instrumentów", "Pobrano " + result.size() + " instrumentów");
            }
        });
    }

    private ColumnModel<NewOrderDTO> initColumnModel() {

        ColumnConfig<NewOrderDTO, Long> idCol = new ColumnConfig<NewOrderDTO, Long>(gridProperties.id(), 150, "Id Zlecenia");
        ColumnConfig<NewOrderDTO, String> instrumentCol = new ColumnConfig<NewOrderDTO, String>(gridProperties.instrument(), 150, "Instrument");
        ColumnConfig<NewOrderDTO, String> marketCol = new ColumnConfig<NewOrderDTO, String>(gridProperties.market(), 150, "Rynek");
        ColumnConfig<NewOrderDTO, String> sideCol = new ColumnConfig<NewOrderDTO, String>(gridProperties.side(), 150, "Strona");
        ColumnConfig<NewOrderDTO, String> typeCol = new ColumnConfig<NewOrderDTO, String>(gridProperties.type(), 150, "Typ Zlecenia");
        ColumnConfig<NewOrderDTO, String> accountCol = new ColumnConfig<NewOrderDTO, String>(gridProperties.accountNumber(), 150, "Numer Rachunku");
        ColumnConfig<NewOrderDTO, Double> priceCol = new ColumnConfig<NewOrderDTO, Double>(gridProperties.price(), 150, "Cena");
        ColumnConfig<NewOrderDTO, Long> amountCol = new ColumnConfig<NewOrderDTO, Long>(gridProperties.amount(), 150, "Ilość");
        ColumnConfig<NewOrderDTO, String> fixCol = new ColumnConfig<NewOrderDTO, String>(gridProperties.fix(), 300, "Fix");

        List<ColumnConfig<NewOrderDTO, ?>> columns = new ArrayList<ColumnConfig<NewOrderDTO, ?>>();
        columns.add(idCol);
        columns.add(instrumentCol);
        columns.add(marketCol);
        columns.add(sideCol);
        columns.add(typeCol);
        columns.add(accountCol);
        columns.add(priceCol);
        columns.add(amountCol);

        return new ColumnModel<NewOrderDTO>(columns);
    }


    interface OrderListUiBinder extends UiBinder<ContentPanel, OrderList> {

    }

    interface OrderListGridProperties extends PropertyAccess<NewOrderDTO> {
        @Editor.Path("id")
        ModelKeyProvider<NewOrderDTO> key();

        ValueProvider<NewOrderDTO, Long> id();

        ValueProvider<NewOrderDTO, String> instrument();

        ValueProvider<NewOrderDTO, String> market();

        ValueProvider<NewOrderDTO, String> side();

        ValueProvider<NewOrderDTO, String> type();

        ValueProvider<NewOrderDTO, String> accountNumber();

        ValueProvider<NewOrderDTO, Double> price();

        ValueProvider<NewOrderDTO, Long> amount();

        ValueProvider<NewOrderDTO, String> fix();

    }
}