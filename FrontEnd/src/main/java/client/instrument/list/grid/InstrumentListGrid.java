package client.instrument.list.grid;

import client.events.InstrumentListDetailsSelected;
import client.instrument.list.composite.InstrumentListComposite;
import client.instrument.service.InstrumentListDetails;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridView;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 21.12.14.
 */
public class InstrumentListGrid extends Composite {
    private static final InstrumentListDetailsProperties gridProperties = GWT.create(InstrumentListDetailsProperties.class);
    private static InstrumentListGridUiBinder ourUiBinder = GWT.create(InstrumentListGridUiBinder.class);
    @UiField(provided = true)
    public ListStore<InstrumentListDetails> listStore;
    @UiField
    public GridView<InstrumentListDetails> gridView;
    @UiField
    public Grid<InstrumentListDetails> grid;
    @UiField(provided = true)
    ColumnModel<InstrumentListDetails> columnModel;

    public InstrumentListGrid() {
        if (listStore == null) {
            listStore = new ListStore<InstrumentListDetails>(gridProperties.key());
            columnModel = initColumnModel();
            initWidget(ourUiBinder.createAndBindUi(this));
            grid.getSelectionModel().addSelectionChangedHandler(new SelectionChangedEvent.SelectionChangedHandler<InstrumentListDetails>() {
                @Override
                public void onSelectionChanged(SelectionChangedEvent<InstrumentListDetails> event) {
                    InstrumentListComposite.EVENT_BUS.fireEvent(new InstrumentListDetailsSelected(event.getSelection().get(0)));
                }
            });
        }

    }

    public void setData(List<InstrumentListDetails> data) {
        listStore.clear();
        listStore.addAll(data);
        gridView.refresh(true);

    }

    private ColumnModel<InstrumentListDetails> initColumnModel() {
        ColumnConfig<InstrumentListDetails, String> nameCol = new ColumnConfig<InstrumentListDetails, String>(gridProperties.isin(), 150, "ISIN");
        ColumnConfig<InstrumentListDetails, String> surnameCol = new ColumnConfig<InstrumentListDetails, String>(gridProperties.name(), 150, "Nazwa");
        ColumnConfig<InstrumentListDetails, String> peselCol = new ColumnConfig<InstrumentListDetails, String>(gridProperties.market(), 150, "Rynek");
        ColumnConfig<InstrumentListDetails, Double> dateCol = new ColumnConfig<InstrumentListDetails, Double>(gridProperties.sellPrice(), 150, "Cena sprzedaży");
        ColumnConfig<InstrumentListDetails, Double> noCol = new ColumnConfig<InstrumentListDetails, Double>(gridProperties.buyPrice(), 150, "Cena kupna");

        List<ColumnConfig<InstrumentListDetails, ?>> columns = new ArrayList<ColumnConfig<InstrumentListDetails, ?>>();
        columns.add(nameCol);
        columns.add(surnameCol);
        columns.add(peselCol);
        columns.add(dateCol);
        columns.add(noCol);

        return new ColumnModel<InstrumentListDetails>(columns);
    }


    interface InstrumentListGridUiBinder extends UiBinder<ContentPanel, InstrumentListGrid> {
    }

    interface InstrumentListDetailsProperties extends PropertyAccess<InstrumentListDetails> {
        @Editor.Path("isin")
        ModelKeyProvider<InstrumentListDetails> key();

        ValueProvider<InstrumentListDetails, String> isin();

        ValueProvider<InstrumentListDetails, String> name();

        ValueProvider<InstrumentListDetails, String> market();

        ValueProvider<InstrumentListDetails, Double> sellPrice();

        ValueProvider<InstrumentListDetails, Double> buyPrice();

    }
}