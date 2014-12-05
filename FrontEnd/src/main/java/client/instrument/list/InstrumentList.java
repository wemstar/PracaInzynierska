package client.instrument.list;

import client.instrument.order.service.NewOrderService;
import client.instrument.order.service.dto.InstrumentDTO;
import client.instrument.order.service.dto.MarketDTO;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.grid.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 04.12.14.
 */
public class InstrumentList extends Composite {
    private static final InstrumentDTO.InstrumetnDTOProperties gridProperties = GWT.create(InstrumentDTO.InstrumetnDTOProperties.class);
    private static InstrumentListUiBinder ourUiBinder = GWT.create(InstrumentListUiBinder.class);
    @UiField(provided = true)
    public ListStore<InstrumentDTO> listStore;
    @UiField
    public GridView<InstrumentDTO> gridView;
    @UiField
    public Grid<InstrumentDTO> grid;
    @UiField(provided = true)
    ColumnModel<InstrumentDTO> columnModel;
    RowExpander<InstrumentDTO> markets;

    public InstrumentList() {
        columnModel = initColumneModel();
        listStore = initListStore();
        initWidget(ourUiBinder.createAndBindUi(this));
        final InstrumentRadarChart instrumentRadarChart = new InstrumentRadarChart();

        NewOrderService.App.getInstance().getInstruments(new AsyncCallback<List<InstrumentDTO>>() {
            @Override
            public void onFailure(Throwable caught) {

            }

            @Override
            public void onSuccess(List<InstrumentDTO> result) {
                listStore.addAll(result);
            }
        });
        markets.initPlugin(grid);


    }

    private ListStore<InstrumentDTO> initListStore() {
        return new ListStore<InstrumentDTO>(gridProperties.isin());
    }

    private ColumnModel<InstrumentDTO> initColumneModel() {

        ColumnConfig<InstrumentDTO, String> isinCol = new ColumnConfig<InstrumentDTO, String>(gridProperties.isinProp(), 150, "Isin");
        ColumnConfig<InstrumentDTO, String> nameCol = new ColumnConfig<InstrumentDTO, String>(gridProperties.nameProp(), 150, "Nazwa");
        markets = new RowExpander<InstrumentDTO>(new AbstractCell<InstrumentDTO>() {
            @Override
            public void render(Context context, InstrumentDTO value, SafeHtmlBuilder sb) {
                for (MarketDTO marketDTO : value.getMarket())
                    sb.appendHtmlConstant("<br/> " + marketDTO.getName());
            }
        });
        List<ColumnConfig<InstrumentDTO, ?>> columns = new ArrayList<ColumnConfig<InstrumentDTO, ?>>();
        columns.add(isinCol);
        columns.add(nameCol);
        columns.add(markets);
        return new ColumnModel<InstrumentDTO>(columns);
    }

    interface InstrumentListUiBinder extends UiBinder<VerticalPanel, InstrumentList> {
    }
}